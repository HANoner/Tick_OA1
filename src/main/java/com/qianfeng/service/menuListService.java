package com.qianfeng.service;

import com.qianfeng.vo.VMenuList;

import java.util.List;

/**
 * @author feng
 * @create 2019-04-13 下午 3:52
 */
public interface menuListService {
    public List<VMenuList> findAll(String uno);
}
