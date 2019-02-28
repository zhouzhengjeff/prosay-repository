package com.prosay.oa.web.controller;

import com.prosay.oa.service.ProcessDefinitionService;
import org.activiti.engine.repository.ProcessDefinition;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/processDefinition")
public class ProcessDefinitionController {

    @Autowired
    private ProcessDefinitionService processDefinitionService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<ProcessDefinition> processDefinitionList = this.processDefinitionService.findAllLastProcessDefinitionList();
        model.addAttribute("processDefinitionList", processDefinitionList);
        return "processDefinition/list";
    }

    @GetMapping("/deploy")
    public String deploy() {
        return "processDefinition/deploy";
    }

    @PostMapping("/deploy")
    public String deploy(MultipartFile resource, HttpServletRequest request) {
        try {
            String path = request.getRealPath("/process");
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }

            String filename = resource.getOriginalFilename();
            File uploadFile = new File(file, filename);
            resource.transferTo(uploadFile);

            this.processDefinitionService.deploy(uploadFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/processDefinition/findAll";
    }

    @GetMapping("/{key}/delete")
    public String delete(@PathVariable String key) {
        this.processDefinitionService.deleteProcessDefinitionByKey(key);
        return "redirect:/processDefinition/findAll";
    }

    @GetMapping("/{processDefinitionId}/showProcessImage")
    public String showProcessImage(@PathVariable String processDefinitionId, HttpServletResponse response) {
        InputStream inputStream = null;
        ServletOutputStream outputStream = null;
        byte[] buffer = null;
        int length = 0;

        try {
            inputStream = this.processDefinitionService.findProcessDefinitionResourceById(processDefinitionId);

            response.setHeader("contentType", "image/png");
            response.setHeader("contentDisposition", "attachment;filename=document.png");
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

        return "redirect:/processDefinition/findAll";
    }

}
