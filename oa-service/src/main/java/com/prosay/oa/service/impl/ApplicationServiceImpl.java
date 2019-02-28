package com.prosay.oa.service.impl;

import com.prosay.oa.domain.Application;
import com.prosay.oa.domain.ApplicationExample;
import com.prosay.oa.domain.Template;
import com.prosay.oa.domain.User;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.mapper.ApplicationMapper;
import com.prosay.oa.mapper.TemplateMapper;
import com.prosay.oa.mapper.UserMapper;
import com.prosay.oa.service.ApplicationService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 提交申请
     * @param application
     */
    @Override
    public void submitApplication(Application application) {
        // 添加申请
        this.applicationMapper.insertSelective(application);

        Integer templateId = application.getTemplateId();
        // 根据模板编号查询出模板
        Template template = this.templateMapper.selectByPrimaryKey(templateId);
        // 根据模板查询出了流程定义key
        String processDefinitionKey = template.getProcessDefinitionKey();

        // 定义流程变量
        Map<String,Object> variables = new HashMap<>();
        variables.put("application",application);

        // 启动流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);

        // 办理提交申请的任务
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();

        // 申请人的编号
        Integer applicantId = application.getApplicantId();
        // 查询出申请人
        User assignee = this.userMapper.selectByPrimaryKey(applicantId);
        // 根据代办人以及流程实例编号查询出该任务
        Task task = taskQuery.taskAssignee(assignee.getUserName()).processInstanceId(processInstance.getProcessInstanceId()).singleResult();
        taskService.complete(task.getId());
    }

    @Override
    public List<Application> findApplicationListByCurrentLoginedUser(User user) {
        if (user == null) {
            throw new SsmException("");
        }

        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andApplicantIdEqualTo(user.getUserId());

        return this.applicationMapper.selectByExample(applicationExample);
    }
}
