package com.prosay.oa.vo;

import com.prosay.oa.domain.Department;

import java.io.Serializable;

public class DepartmentVo implements Serializable {

    private static final long serialVersionUID = 6853934555826038109L;

    private Department department;

    private String parentDeparmtentName;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getParentDeparmtentName() {
        return parentDeparmtentName;
    }

    public void setParentDeparmtentName(String parentDeparmtentName) {
        this.parentDeparmtentName = parentDeparmtentName;
    }
}
