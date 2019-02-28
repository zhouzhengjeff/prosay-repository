package com.prosay.oa.service;

import com.prosay.oa.domain.Template;

import java.util.List;

public interface TemplateService {

    List<Template> findAllTTemplateList();

    void deleteTemplateById(Integer templateId);

    void addTemplate(Template template);

    Template findTemplateById(Integer templateId);

    void modifyTemplate(Template template);
}
