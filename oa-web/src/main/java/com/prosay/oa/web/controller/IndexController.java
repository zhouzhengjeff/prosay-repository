package com.prosay.oa.web.controller;

import com.prosay.oa.domain.Privilege;
import com.prosay.oa.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/left")
    public String left(Model model) {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        String loginName = (String) principalCollection.getPrimaryPrincipal();
        // TODO 根据当前登录的用户查询出该用户的所有的顶层权限
        List<Privilege> topPrivilegeList = this.userService.findAllTopPrivilegeListByLoginName(loginName);
        model.addAttribute("topPrivilegeList",topPrivilegeList);
        return "left";
    }

    @GetMapping("/right")
    public String right() {
        return "right";
    }

    @GetMapping("/top")
    public String top() {
        return "top";
    }

    @GetMapping("/bottom")
    public String bottom() {
        return "bottom";
    }
}
