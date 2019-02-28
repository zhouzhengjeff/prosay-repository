package com.prosay.oa.web.controller;

import com.prosay.oa.domain.Application;
import com.prosay.oa.domain.Template;
import com.prosay.oa.domain.User;
import com.prosay.oa.service.ApplicationService;
import com.prosay.oa.service.TemplateService;
import com.prosay.oa.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/workflow")
public class WorkflowController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/findTemplateList")
    public String findTemplateList(Model model) {
        List<Template> templateList = this.templateService.findAllTTemplateList();
        model.addAttribute("templateList", templateList);
        return "workflow/template_list";
    }

    @GetMapping("/submit/{templateId}")
    public String submit(@PathVariable Integer templateId, Model model) {
        Template template = this.templateService.findTemplateById(templateId);
        model.addAttribute("template", template);
        return "workflow/submit";
    }

    @PostMapping("/submit")
    public String submit(Integer templateId, MultipartFile applicationDocumentPath, HttpServletRequest request) {
        try {
            // 根据模板编号查询模板
            Template template = this.templateService.findTemplateById(templateId);

            // 获取当前登录的用户
            User user = this.getCurrentLoginedUser();

            String path = request.getRealPath("/application");
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }

            String originalFilename = applicationDocumentPath.getOriginalFilename();
            String applicationTemplatePath = file.getAbsolutePath() + File.separator + originalFilename;

            // 实现上传
            applicationDocumentPath.transferTo(new File(file,originalFilename));

            Application application = new Application();
            application.setApplicationDocumentPath(applicationTemplatePath);
            application.setApplicationDate(new Date());
            // 申请人
            application.setApplicantId(user.getUserId());
            application.setApplicationStatus(Application.APPLICATION_STATUS_APPROVING);
            application.setApplicationTitle(template.getTemplateName() + "_" + user.getLoginName() + "_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            application.setTemplateId(templateId);

            this.applicationService.submitApplication(application);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/workflow/findApplicationListBySelf";
    }

    @GetMapping("/findApplicationListBySelf")
    public String findApplicationListBySelf(Model model) {
        User user = getCurrentLoginedUser();
        List<Application> applicationList = this.applicationService.findApplicationListByCurrentLoginedUser(user);
        model.addAttribute("applicationList",applicationList);
        return "workflow/mySubmittedList";
    }

    private User getCurrentLoginedUser() {
        String loginName = (String) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        // 根据登录名称查询该用户
        return this.userService.findUserByLoginName(loginName);
    }


}
