package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.roleMapper;
import com.qianfeng.entity.role;
import com.qianfeng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-16 上午 10:25
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private roleMapper roleMapper;


    @Override
    public Map roleAll(String rolename) {

        List<role> roles = roleMapper.roleAll(rolename);


        Map<String,Object> map = new HashMap<>();

        map.put("msg","");
        map.put("data",roles);
        map.put("code",0);
        return map;
    }

    @Override
    public void roleDeleteById(int id) {
        roleMapper.roleDeleteById(id);
    }


}
