package com.business.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.entity.TSysCode;
import com.business.service.ITSysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LUJIAWEI931
 * @since 2019-05-24
 */
@RestController
public class TSysCodeController {

    @Autowired
    ITSysCodeService tSysCodeService;

    @GetMapping("/test")
    public IPage<TSysCode> test() {
        return tSysCodeService.page(new Page<TSysCode>(0, 12), null);
    }
}
