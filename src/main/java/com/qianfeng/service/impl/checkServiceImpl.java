package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.checkMapper;
import com.qianfeng.entity.check;
import com.qianfeng.service.checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 下午 4:11
 */
@Service
public class checkServiceImpl implements checkService {
    @Autowired
    private checkMapper checkmapper;
     @Override
    public Map<String, Object> findAll(int page, int limit) {
         PageHelper.startPage(page,limit);
         List<check> all = checkmapper.findAll();
         long count  = ((Page)all).getTotal();
         Map<String,Object> map = new HashMap<>();
         map.put("code",0);
         map.put("msg","");
         map.put("count",count);
         map.put("data",all);
         return map;
    }




}
