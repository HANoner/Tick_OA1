package com.qianfeng.service;

import com.qianfeng.entity.check;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 下午 4:10
 */
public interface checkService {
    public Map findAll(int page, int limit);

    public void processDelById(int id);
    public void processAdd(check check);

}
