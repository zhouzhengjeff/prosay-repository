package com.prosay.oa.service.impl;

import com.prosay.oa.domain.Department;
import com.prosay.oa.domain.DepartmentExample;
import com.prosay.oa.exception.SsmException;
import com.prosay.oa.mapper.DepartmentMapper;
import com.prosay.oa.service.DepartmentService;
import com.prosay.oa.vo.DepartmentVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentVo> findTopDepartmentVoList() {
        List<DepartmentVo> departmentVoList = new ArrayList<>();
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andParentIdIsNull();

        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        generateDepartmentVoList(departmentVoList, departmentList);
        return departmentVoList;
    }

    @Override
    public List<DepartmentVo> findDepartmentVoListByParentId(Integer parentId) {
        List<DepartmentVo> departmentVoList = new ArrayList<>();

        if (parentId == null || parentId <= 0) {
            throw new SsmException("");
        }

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<Department> departmentList = this.departmentMapper.selectByExample(departmentExample);
        generateDepartmentVoList(departmentVoList, departmentList);

        return departmentVoList;

    }

    @Override
    public List<DepartmentVo> findEqualLevelDepartmentVoListById(Integer id) {
        List<DepartmentVo> departmentVoList = new ArrayList<>();
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();

        Department department = this.departmentMapper.selectByPrimaryKey(id);
        Integer level = department.getDepartmentLevel();

        criteria.andDepartmentLevelEqualTo(level);

        List<Department> departmentList = this.departmentMapper.selectByExample(departmentExample);
        generateDepartmentVoList(departmentVoList, departmentList);

        return departmentVoList;
    }

    @Override
    public Department findDepartmentById(Integer id) {
        if (id == null || id <= 0) {
            throw new SsmException("");
        }
        return this.departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> findAllDepartmentList() {
        DepartmentExample departmentExample = new DepartmentExample();
        return this.departmentMapper.selectByExample(departmentExample);
    }

    private void generateDepartmentVoList(List<DepartmentVo> departmentVoList, List<Department> departmentList) {
        if (CollectionUtils.isNotEmpty(departmentList)) {
            for (Department department : departmentList) {
                DepartmentVo departmentVo = new DepartmentVo();
                departmentVo.setDepartment(department);

                // 查询当前的部门的父部门
                Integer parentId = department.getParentId();
                if (parentId == null) {
                    departmentVo.setParentDeparmtentName(null);
                } else {
                    Department parentDepartment = this.departmentMapper.selectByPrimaryKey(parentId);
                    if (parentDepartment != null) {
                        departmentVo.setParentDeparmtentName(parentDepartment.getDepartmentName());
                    }
                }
                departmentVoList.add(departmentVo);
            }
        }
    }
}
