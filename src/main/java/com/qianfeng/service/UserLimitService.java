package com.qianfeng.service;

import com.qianfeng.vo.VUserLimit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 下午 4:54
 */
public interface UserLimitService {

    public Map findSearch(String no, Integer flag,int page,int limit);



}
