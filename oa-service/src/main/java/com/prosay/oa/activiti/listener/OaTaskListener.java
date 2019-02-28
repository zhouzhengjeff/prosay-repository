package com.prosay.oa.activiti.listener;

import com.prosay.oa.domain.Application;
import com.prosay.oa.domain.User;
import com.prosay.oa.service.UserService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OaTaskListener implements TaskListener {

    @Autowired
    private UserService userService;

    @Override
    public void notify(DelegateTask delegateTask) {
//        delegateTask.get
        // 获取提交申请的申请人
        Application application = (Application) delegateTask.getVariable("application");
        // 申请人的编号
        Integer applicantId = application.getApplicantId();
        User applicant = this.userService.findUserById(applicantId);

        // 根据申请人查询这个申请人的部门经理
        User departmentManager = this.userService.findDepartmentManagerByApplicant(applicant);

        delegateTask.setAssignee(departmentManager.getUserName());
    }
}
