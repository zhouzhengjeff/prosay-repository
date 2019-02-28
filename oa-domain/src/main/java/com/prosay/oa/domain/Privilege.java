package com.prosay.oa.domain;

import java.util.Objects;

public class Privilege {
    private Integer privilegeId;

    private String privilegeName;

    private String privilegeUrl;

    private Integer privilegeLevel;

    private String privilegeIsLeaf;

    private String privilegeIsModule;

    private Integer parentId;

    private String privilegeCode;

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl == null ? null : privilegeUrl.trim();
    }

    public Integer getPrivilegeLevel() {
        return privilegeLevel;
    }

    public void setPrivilegeLevel(Integer privilegeLevel) {
        this.privilegeLevel = privilegeLevel;
    }

    public String getPrivilegeIsLeaf() {
        return privilegeIsLeaf;
    }

    public void setPrivilegeIsLeaf(String privilegeIsLeaf) {
        this.privilegeIsLeaf = privilegeIsLeaf == null ? null : privilegeIsLeaf.trim();
    }

    public String getPrivilegeIsModule() {
        return privilegeIsModule;
    }

    public void setPrivilegeIsModule(String privilegeIsModule) {
        this.privilegeIsModule = privilegeIsModule == null ? null : privilegeIsModule.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode == null ? null : privilegeCode.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return Objects.equals(privilegeId, privilege.privilegeId) &&
                Objects.equals(privilegeName, privilege.privilegeName) &&
                Objects.equals(privilegeUrl, privilege.privilegeUrl) &&
                Objects.equals(privilegeLevel, privilege.privilegeLevel) &&
                Objects.equals(privilegeIsLeaf, privilege.privilegeIsLeaf) &&
                Objects.equals(privilegeIsModule, privilege.privilegeIsModule) &&
                Objects.equals(parentId, privilege.parentId) &&
                Objects.equals(privilegeCode, privilege.privilegeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privilegeId, privilegeName, privilegeUrl, privilegeLevel, privilegeIsLeaf, privilegeIsModule, parentId, privilegeCode);
    }
}