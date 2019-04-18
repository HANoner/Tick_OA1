package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.DepartService;
import com.qianfeng.service.ProcesstodoService;
import com.qianfeng.service.checkService;
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
 * @create 修改时间:2019/4/16
 * @since 1.0.0
 */
@RequiresPermissions("fa-bell-o")
@Controller
@ResponseBody
public class ProcesstodoServlet {

    @Autowired
    private ProcesstodoService processtodoService;

    @Autowired
    private checkService checkService;

    @RequestMapping("/Processtodo/list.do")
    public Map<String, Object> findProcesstodoAll(Integer page, Integer limit){
        Integer pageSize = limit;
        if(pageSize ==null){
            pageSize=10;
        }
        Map<String, Object> map = processtodoService.findprocesstodoAll(page, pageSize);

        return map;
    }

    @RequestMapping("/Processtodo/processupdate.do")
    public JsonBean processUpdateById(Integer id ,Integer filg){

        processtodoService.processUpdateById(id);
        return JsonUtils.createJsonBean(1000,null);
    }
    @RequestMapping("/Processtodo/processupdateY.do")
    public JsonBean processUpdateYById(Integer id ,Integer filg){

        processtodoService.processUpdateYById(id);
        return JsonUtils.createJsonBean(1000,null);
    }


}
