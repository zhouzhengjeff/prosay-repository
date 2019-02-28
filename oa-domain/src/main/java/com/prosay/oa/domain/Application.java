package com.prosay.oa.domain;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {

    private static final long serialVersionUID = 7245585803452191104L;

    public static final String APPLICATION_STATUS_APPROVING = "审批中";
    public static final String APPLICATION_STATUS_UNPASSED = "未通过";
    public static final String APPLICATION_STATUS_PASSED = "已通过";

    private Integer applicationId;

    private String applicationTitle;

    private Date applicationDate;

    private String applicationStatus;

    private String applicationDocumentPath;

    /**
     * 申请人的编号
     */
    private Integer applicantId;

    private Integer templateId;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationTitle() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle = applicationTitle == null ? null : applicationTitle.trim();
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus == null ? null : applicationStatus.trim();
    }

    public String getApplicationDocumentPath() {
        return applicationDocumentPath;
    }

    public void setApplicationDocumentPath(String applicationDocumentPath) {
        this.applicationDocumentPath = applicationDocumentPath == null ? null : applicationDocumentPath.trim();
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
}