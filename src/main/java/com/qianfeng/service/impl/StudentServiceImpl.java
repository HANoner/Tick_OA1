package com.qianfeng.service.impl;

import com.qianfeng.common.JsonBean;
import com.qianfeng.dao.studentMapper;
import com.qianfeng.dao.userMapper;
import com.qianfeng.entity.student;
import com.qianfeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@Service

public class StudentServiceImpl implements StudentService{
    @Autowired
private studentMapper studentMapper;

    @Override
    public void StudentAdd(student student) {
    studentMapper.insert(student);
    }

}
