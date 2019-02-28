package com.prosay.oa.web.function;

import com.prosay.oa.domain.Department;
import com.prosay.oa.domain.Privilege;
import com.prosay.oa.domain.Role;
import com.prosay.oa.domain.User;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OaFunction {

    // static关键字的对象，spring ioc不能注入
    private static UserService userService;

    private static DepartmentService departmentService;

    private static PrivilegeService privilegeService;

    private static RoleService roleService;

    private static ProcessDefinitionService processDefinitionService;

    @Autowired
    public void setUserService(UserService userService) {
        OaFunction.userService = userService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        OaFunction.departmentService = departmentService;
    }

    @Autowired
    public void setPrivilegeService(PrivilegeService privilegeService) {
        OaFunction.privilegeService = privilegeService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        OaFunction.roleService = roleService;
    }

    @Autowired
    public void setProcessDefinitionService(ProcessDefinitionService processDefinitionService) {
        OaFunction.processDefinitionService = processDefinitionService;
    }

    public static Department findDepartmentByUser(User user) {
        if (user == null) {
            throw new SsmException("");
        }

        return departmentService.findDepartmentById(user.getDepartmentId());
    }

    public static String findAllRoleNamesByUser(User user) {
        StringBuilder roleNameString = new StringBuilder();

        if (user == null) {
            throw new SsmException("");
        }

        List<Role> roleList = userService.findAllRoleListByUserId(user.getUserId());
        for (Role role : roleList) {
            roleNameString.append(role.getRoleName()).append(",");
        }

        roleNameString.deleteCharAt(roleNameString.lastIndexOf(","));
        return roleNameString.toString();
    }

    public static List<Privilege> findPrivilegeChildrenById(Integer id) {
        if (id == null || id <= 0) {
            throw new SsmException("");
        }

        return privilegeService.findPrivilegeChildrenById(id);
    }

    public static String isChecked(Role role, Integer privilegeId) {
        if (role == null) {
            throw new SsmException("");
        }

        if (privilegeId == null || privilegeId <= 0) {
            throw new SsmException("");
        }

        List<Privilege> privilegeList = roleService.findPrivilegeListByRoleId(role.getRoleId());
        for (Privilege privilege : privilegeList) {
            if (privilege.getPrivilegeId().equals(privilegeId)) {
                return "checked";
            }
        }

        return "";
    }

    public static String findProcessDefinitionNameByKey(String key) {
        if (StringUtils.isBlank(key)) {
            throw new SsmException("");
        }

        return processDefinitionService.findProcessDefinitionNameByKey(key);
    }
}
