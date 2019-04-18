package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.authorityMapper;
import com.qianfeng.entity.authority;
import com.qianfeng.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-17 下午 4:12
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private authorityMapper authoritymapper;
    @Override
    public Map findAuthorityList(int page,int limit) {
        PageHelper.startPage(page,limit);
        List<authority> authoritylist = authoritymapper.findAuthoritylist();
        long count = ((Page)authoritylist).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",authoritylist);
        return map;
    }
}
