package com.prosay.oa.web.controller;

import com.prosay.oa.domain.Template;
import com.prosay.oa.service.ProcessDefinitionService;
import com.prosay.oa.service.TemplateService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ProcessDefinitionService processDefinitionService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Template> templateList = this.templateService.findAllTTemplateList();
        model.addAttribute("templateList", templateList);
        return "template/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<ProcessDefinition> processDefinitionList = this.processDefinitionService.findAllLastProcessDefinitionList();
        model.addAttribute("processDefinitionList", processDefinitionList);
        model.addAttribute("action", "add");
        return "template/save";
    }

    @PostMapping("/add")
    public String add(String templateName,
                      String processDefinitionKey,
                      MultipartFile templateDocumentPath, HttpServletRequest request) {
        try {
            File file = uploadTempleFile(templateDocumentPath, request);

            Template template = new Template();
            template.setTemplateName(templateName);
            template.setProcessDefinitionKey(processDefinitionKey);
            template.setTemplateDocumentPath(file.getAbsolutePath());
            this.templateService.addTemplate(template);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/template/findAll";
    }

    @GetMapping("/delete/{templateId}")
    public String delete(@PathVariable Integer templateId) {
        this.templateService.deleteTemplateById(templateId);
        return "redirect:/template/findAll";
    }

    @GetMapping("/update/{templateId}")
    public String update(@PathVariable Integer templateId, Model model) {
        Template template = this.templateService.findTemplateById(templateId);
        List<ProcessDefinition> processDefinitionList = this.processDefinitionService.findAllLastProcessDefinitionList();

        model.addAttribute("template", template);
        model.addAttribute("processDefinitionList", processDefinitionList);
        model.addAttribute("action", "update");

        return "template/save";
    }

    @PostMapping("/update")
    public String update(Integer templateId,
                         String templateName,
                         String processDefinitionKey,
                         MultipartFile templateDocumentPath, HttpServletRequest request) {
        try {
            String uploadPath = request.getRealPath("/template");
            File uploadFile = new File(uploadPath);
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }

            // TODO
            Template template = this.templateService.findTemplateById(templateId);
            template.setTemplateName(templateName);
            template.setProcessDefinitionKey(processDefinitionKey);

            // 更新模板文件
            if (templateDocumentPath != null) {
                String oldDocumentPath = template.getTemplateDocumentPath();
                File oldTemplateFile = new File(oldDocumentPath);
                if (oldTemplateFile.exists()) {
                    FileUtils.forceDelete(oldTemplateFile);
                }

                String originalFilename = templateDocumentPath.getOriginalFilename();
                File file = new File(uploadFile, originalFilename);
                templateDocumentPath.transferTo(file);

                template.setTemplateDocumentPath(file.getAbsolutePath());
            }

            this.templateService.modifyTemplate(template);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/template/findAll";

    }

    @GetMapping("/download/{templateId}")
    public String download(@PathVariable Integer templateId, HttpServletResponse response) {
        InputStream inputStream = null;
        ServletOutputStream outputStream = null;
        byte[] buffer = null;
        int length = 0;

        try {
            Template template = this.templateService.findTemplateById(templateId);
            String templateDocumentPath = template.getTemplateDocumentPath();
            String fileName = templateDocumentPath.substring(templateDocumentPath.lastIndexOf("\\") + 1);
            response.setHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            inputStream = new FileInputStream(templateDocumentPath);
            buffer = new byte[inputStream.available()];

            outputStream = response.getOutputStream();
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    private File uploadTempleFile(MultipartFile templateDocumentPath, HttpServletRequest request) throws IOException {
        String uploadPath = request.getRealPath("/template");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }

        // TODO 上传操作
        String originalFilename = templateDocumentPath.getOriginalFilename();
        File file = new File(uploadFile, originalFilename);

        templateDocumentPath.transferTo(file);
        return file;
    }
}
