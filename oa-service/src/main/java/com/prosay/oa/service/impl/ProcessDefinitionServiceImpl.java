package com.prosay.oa.service.impl;

import com.prosay.oa.exception.SsmException;
import com.prosay.oa.service.ProcessDefinitionService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

@Service
@Transactional
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {

    @Autowired
    private ProcessEngine processEngine;

    @Override
    public List<ProcessDefinition> findAllLastProcessDefinitionList() {
        RepositoryService repositoryService = this.processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        processDefinitionQuery.orderByProcessDefinitionVersion().asc();
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.list();

        Map<String, ProcessDefinition> map = new HashMap<>();
        for (ProcessDefinition processDefinition : processDefinitionList) {
            map.put(processDefinition.getKey(), processDefinition);
        }

        return new ArrayList<>(map.values());
    }

    @Override
    public void deploy(String filename) {
        ZipInputStream zipInputStream = null;
        if (StringUtils.isBlank(filename)) {
            throw new SsmException("");
        }

        try {
            RepositoryService repositoryService = this.processEngine.getRepositoryService();
            DeploymentBuilder deployment = repositoryService.createDeployment();

            zipInputStream = new ZipInputStream(new FileInputStream(filename));
            deployment.addZipInputStream(zipInputStream);
            deployment.deploy();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteProcessDefinitionByKey(String key) {
        if (StringUtils.isBlank(key)) {
            throw new SsmException("");
        }

        RepositoryService repositoryService = this.processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.processDefinitionKey(key).list();
        for (ProcessDefinition processDefinition : processDefinitionList) {
            String deploymentId = processDefinition.getDeploymentId();
            repositoryService.deleteDeployment(deploymentId, true);
        }
    }

    @Override
    public InputStream findProcessDefinitionResourceById(String processDefinitionId) {
        RepositoryService repositoryService = this.processEngine.getRepositoryService();
        return repositoryService.getProcessDiagram(processDefinitionId);
    }

    @Override
    public String findProcessDefinitionNameByKey(String key) {
        RepositoryService repositoryService = this.processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionKey(key).latestVersion().singleResult();
        return processDefinition.getName();
    }
}
