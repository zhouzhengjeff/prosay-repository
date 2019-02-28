package com.prosay.oa.web.controller;

import com.prosay.oa.domain.Privilege;
import com.prosay.oa.domain.Role;
import com.prosay.oa.service.PrivilegeService;
import com.prosay.oa.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping("/findAll")
    @RequiresPermissions("role:findAll")
    public String findAll(Model model) {
        List<Role> roleList = this.roleService.findAllRoleList();
        model.addAttribute("roleList", roleList);
        return "role/list";
    }

    @GetMapping("/{roleId}/setPrivilege")
    @RequiresPermissions("role:setPrivilege")
    public String setPrivilege(@PathVariable Integer roleId, Model model) {
        Role role = this.roleService.findRoleById(roleId);

        // TODO 查询出所有的顶层权限节点
        List<Privilege> topPrivilegeList = this.privilegeService.findTopPrivilegeList();
        model.addAttribute("role", role);
        model.addAttribute("topPrivilegeList", topPrivilegeList);
        return "role/setPrivilege";
    }

    @PostMapping("/{roleId}/setPrivilege")
    @RequiresPermissions("role:setPrivilege")
    public String setPrivilege(@PathVariable Integer roleId, Integer[] privilegeIds) {
        this.roleService.setPrivilege(roleId, privilegeIds);
        return "redirect:/role/findAll";
    }
}
