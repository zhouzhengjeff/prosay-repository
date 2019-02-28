package com.prosay.oa.domain;

public class Template {
    private Integer templateId;

    private String templateName;

    private String processDefinitionKey;

    private String templateDocumentPath;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey == null ? null : processDefinitionKey.trim();
    }

    public String getTemplateDocumentPath() {
        return templateDocumentPath;
    }

    public void setTemplateDocumentPath(String templateDocumentPath) {
        this.templateDocumentPath = templateDocumentPath == null ? null : templateDocumentPath.trim();
    }
}