package com.prosay.oa.web.controller;

import com.prosay.oa.domain.Department;
import com.prosay.oa.domain.Role;
import com.prosay.oa.domain.User;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.service.DepartmentService;
import com.prosay.oa.service.RoleService;
import com.prosay.oa.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if (StringUtils.isNotBlank(exceptionClassName)) {
            if (exceptionClassName.equals(UnknownAccountException.class.getName())) {
                throw new SsmException("账号不存在!");
            } else if (exceptionClassName.equals(IncorrectCredentialsException.class.getName())) {
                throw new SsmException("密码不匹配");
            }
        }

        return "login";
    }

    @GetMapping("/findAll")
    @RequiresPermissions("user:findAll")
    public String findAll(Model model) {
        List<User> userList = this.userService.findAllUserList();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("/add")
    @RequiresPermissions("user:add")
    public String add(Model model) {
        List<Department> departmentList = this.departmentService.findAllDepartmentList();
        List<Role> roleList = this.roleService.findAllRoleList();
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("roleList", roleList);
        return "user/save";
    }

    @PostMapping("/add")
    @RequiresPermissions("user:add")
    public String add(User user, @RequestParam(value = "roleIdList") Integer[] roleIds) {
        this.userService.addUser(user, roleIds);
        return "redirect:/user/findAll";
    }
}
