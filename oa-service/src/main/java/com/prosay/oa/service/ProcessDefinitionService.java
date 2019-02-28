package com.prosay.oa.service;

import org.activiti.engine.repository.ProcessDefinition;

import java.io.InputStream;
import java.util.List;

public interface ProcessDefinitionService {

    /**
     * 查询出最新版本的流程定义
     * @return
     */
    List<ProcessDefinition> findAllLastProcessDefinitionList();

    /**
     * 部署流程定义
     * @param filename
     */
    void deploy(String filename);

    void deleteProcessDefinitionByKey(String key);

    InputStream findProcessDefinitionResourceById(String processDefinitionId);

    String findProcessDefinitionNameByKey(String key);
}
