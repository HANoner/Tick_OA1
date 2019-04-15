package com.qianfeng.service.impl;

import com.qianfeng.dao.roleMapper;
import com.qianfeng.entity.user;
import com.qianfeng.service.menuListService;
import com.qianfeng.vo.VMenuList;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author feng
 * @create 2019-04-13 下午 3:53
 */
@Service
public class menuListServiceImpl implements menuListService {

    @Autowired
    private roleMapper roledao;
    @Override
    public List<VMenuList> findAll(String uno) {
        List<VMenuList> vMenuLists = roledao.findAll(uno);
        return vMenuLists;
    }
}
