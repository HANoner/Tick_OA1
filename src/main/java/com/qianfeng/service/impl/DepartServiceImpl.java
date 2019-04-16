package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.departMapper;
import com.qianfeng.dao.gradeMapper;
import com.qianfeng.entity.depart;
import com.qianfeng.entity.grade;
import com.qianfeng.service.DepartService;
import com.qianfeng.vo.VDepart;
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
public class DepartServiceImpl implements DepartService {

    @Autowired
    private departMapper departMapper;
    @Override
    public Map<String, Object> findDepartAll(Integer page, Integer pageSize) {



        PageHelper.startPage(page,pageSize);
        List<VDepart> list = departMapper.findAllDepart();
        Map<String, Object> map = new HashMap<>();
        long count = ((Page)list).getTotal();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;
    }

    @Override
    public void deleteDepartById(Integer id) {
        departMapper.deleteDepart(id);

    }

    @Override
    public void updateDepart(depart depart) {
        departMapper.updateByPrimaryKeySelective(depart);
    }

    @Override
    public void addDepart(depart depart) {
        departMapper.insert(depart);
    }
}
