package com.prosay.oa.web.controller;

import com.prosay.oa.domain.Department;
import com.prosay.oa.service.DepartmentService;
import com.prosay.oa.vo.DepartmentVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findTopDepartmentList")
    @RequiresPermissions("department:findTopDepartmentList")
    public String findTopDepartmentList(Model model) {
        List<DepartmentVo> topDepartmentVoList = this.departmentService.findTopDepartmentVoList();
        model.addAttribute("topDepartmentVoList", topDepartmentVoList);
        return "department/list";
    }

    @GetMapping("/{parentId}/findDepartmentChildrenList")
    @RequiresPermissions("department:findDepartmentChildrenList")
    public String findDepartmentChildrenList(@PathVariable Integer parentId, Model model) {
        List<DepartmentVo> departmentVoList = this.departmentService.findDepartmentVoListByParentId(parentId);
        model.addAttribute("departmentVoList",departmentVoList);
        model.addAttribute("parentId",parentId);
        return "department/list_level2";
    }

    @GetMapping("/{id}/findPrevLevelDepartmentList")
    @RequiresPermissions("department:findPrevLevelDepartmentList")
    public String findPrevLevelDepartmentList(@PathVariable Integer id,Model model) {
        Department department = this.departmentService.findDepartmentById(id);
        List<DepartmentVo> departmentVoList = this.departmentService.findEqualLevelDepartmentVoListById(id);
        model.addAttribute("departmentVoList",departmentVoList);

        Integer parentId = department.getParentId();
        if (parentId == null) {
            return "redirect:/department/findTopDepartmentList";
        }

        model.addAttribute("parentId",parentId);
        return "department/list_level2";
    }
}
