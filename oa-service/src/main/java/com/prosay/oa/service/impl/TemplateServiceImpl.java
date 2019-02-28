package com.prosay.oa.service.impl;

import com.prosay.oa.domain.Template;
import com.prosay.oa.domain.TemplateExample;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.mapper.TemplateMapper;
import com.prosay.oa.service.TemplateService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public List<Template> findAllTTemplateList() {
        TemplateExample templateExample = new TemplateExample();
        List<Template> templateList = this.templateMapper.selectByExample(templateExample);
        return templateList;
    }


    @Override
    public void deleteTemplateById(Integer templateId) {
        if (templateId == null || templateId <= 0) {
            throw new SsmException("");
        }

        try {
            // TODO 删除时，相应的文件也被删除
            Template template = this.templateMapper.selectByPrimaryKey(templateId);
            String templateDocumentPath = template.getTemplateDocumentPath();
            File templateFile = new File(templateDocumentPath);
            if (templateFile.exists()) {
                FileUtils.forceDelete(templateFile);
            }

            this.templateMapper.deleteByPrimaryKey(templateId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTemplate(Template template) {
        if (template == null) {
            throw new SsmException("");
        }

        this.templateMapper.insert(template);
    }

    @Override
    public void modifyTemplate(Template template) {
        if (template == null) {
            throw new SsmException("");
        }
        this.templateMapper.updateByPrimaryKeySelective(template);
    }

    @Override
    public Template findTemplateById(Integer templateId) {
        if (templateId == null || templateId <= 0) {
            throw new SsmException("");
        }

        return this.templateMapper.selectByPrimaryKey(templateId);
    }
}
