package com.criss.wang.mybatis.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.criss.wang.mybatis.entity.TbDeviceConnection;
import com.criss.wang.mybatis.mapper.TbDeviceConnectionMapper;
import com.criss.wang.mybatis.service.impl.TbDeviceConnectionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-19
 */
@RestController
@RequestMapping("/mybatis/tb-device-connection")
public class TbDeviceConnectionController {

    @Autowired
    private TbDeviceConnectionMapper deviceConnectionMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TbDeviceConnectionServiceImpl deviceConnectionService;

    @GetMapping("query/page1")
    public Object selectPageVo1() throws Exception {
        IPage<TbDeviceConnection> userPage = new Page<>(1, 2);
        userPage = deviceConnectionService.page(userPage);
        List<TbDeviceConnection> list = userPage.getRecords();
        return objectMapper.writeValueAsString(userPage);
    }

}
