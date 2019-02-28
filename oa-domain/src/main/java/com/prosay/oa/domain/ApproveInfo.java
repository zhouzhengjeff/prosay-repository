package com.prosay.oa.domain;

import java.util.Date;

public class ApproveInfo {
    private Integer approveInfoId;

    private Date approveDate;

    private String approveStatus;

    private String approveComment;

    private Integer approverId;

    private Integer applicationId;

    public Integer getApproveInfoId() {
        return approveInfoId;
    }

    public void setApproveInfoId(Integer approveInfoId) {
        this.approveInfoId = approveInfoId;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }

    public String getApproveComment() {
        return approveComment;
    }

    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment == null ? null : approveComment.trim();
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }
}