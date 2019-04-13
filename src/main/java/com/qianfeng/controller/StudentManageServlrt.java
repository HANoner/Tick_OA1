package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈学生管理〉<br>
 * 〈和学生管理相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
public class StudentManageServlrt {

@RequestMapping("/studentadd.do")
    public JsonBean StudentAdd(){




        return   JsonUtils.createJsonBean(1, null);
    }

}
