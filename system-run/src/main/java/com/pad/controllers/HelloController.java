package com.pad.controllers;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    @ResponseBody
    public String test1() {
        log.info("MMMMMMMMMMMM");
        return "hello";
    }

    @RequestMapping("/hello2")
    public Object test2() {
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        List<Map<String, Object>> dataSourceStatDataList = DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        for (Map<String, Object> stringObjectMap : dataSourceStatDataList) {
            System.out.println(stringObjectMap.values());
        }
        return "";
    }
}
