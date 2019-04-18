package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.depart;
import com.qianfeng.service.DepartService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/12
 * @since 1.0.0
 */

@Controller
@ResponseBody
public class DepartServlet {
    @Autowired
    private DepartService departService;
    @RequiresPermissions("fa-sitemap")

    @RequestMapping("/depart/list.do")
    public Map<String, Object> findByDepartAll(Integer page, Integer limit){
        Integer pageSize = limit;
        if(pageSize ==null){
            pageSize=10;
        }
        Map<String, Object> map = departService.findDepartAll(page, pageSize);

        return map;
    }
    @RequestMapping("/depart/delete.do")
    public JsonBean deleteDepartById(Integer id){

        try {
            departService.deleteDepartById(id);
            return JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,e.getMessage());
        }
    }

    @RequestMapping("/depart/update.do")
    public JsonBean updateDepart(depart depart){
        departService.updateDepart(depart);
        return JsonUtils.createJsonBean(1,null);
    }
    @RequestMapping("/depart/add.do")
    public JsonBean addDepart(depart depart){

        depart.setFlag(1);
        departService.addDepart(depart);
        return JsonUtils.createJsonBean(1,null);
    }
}
