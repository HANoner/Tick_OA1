package com.qianfeng.service;

import com.qianfeng.entity.role;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-16 上午 10:25
 */
public interface RoleService {
    public Map roleAll(String rolename);

    public void roleDeleteById(int id);
}
