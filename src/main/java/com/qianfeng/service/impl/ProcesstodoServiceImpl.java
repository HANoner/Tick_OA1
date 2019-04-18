package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.processtodoMapper;
import com.qianfeng.entity.check;
import com.qianfeng.entity.processtodo;
import com.qianfeng.service.ProcesstodoService;
import com.qianfeng.vo.VGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */

@Service
public class ProcesstodoServiceImpl implements ProcesstodoService {

    @Autowired
    private processtodoMapper processtodoDao;
    @Override
    public Map<String, Object> findprocesstodoAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<check> list = processtodoDao.findAllprocesstodo();
        Map<String, Object> map = new HashMap<>();
        long count = ((Page)list).getTotal();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;
    }

    @Override
    public void processUpdateById(Integer id) {
        processtodoDao.processUpdateById(id);

    }

    @Override
    public void processUpdateYById(Integer id) {
        processtodoDao.processUpdateYById(id);
    }
}
