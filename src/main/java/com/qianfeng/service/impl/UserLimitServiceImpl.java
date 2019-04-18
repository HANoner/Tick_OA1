package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.userMapper;
import com.qianfeng.service.UserLimitService;
import com.qianfeng.vo.VUserLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 下午 4:54
 */
@Service
public class UserLimitServiceImpl implements UserLimitService {
    @Autowired
    private userMapper userMapper;

    @Override
    public Map findSearch(String no, Integer flag, int page, int limit) {

        PageHelper.startPage(page,limit);
        List<VUserLimit> search = userMapper.findSearch(no, flag);
        long count  =  ((Page)search).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",search);

        return map;
    }
}
