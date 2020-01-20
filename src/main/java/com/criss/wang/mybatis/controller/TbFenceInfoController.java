package com.criss.wang.mybatis.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.criss.wang.mybatis.entity.TbFenceInfo;
import com.criss.wang.mybatis.mapper.TbFenceInfoMapper;
import com.criss.wang.mybatis.service.impl.TbFenceInfoServiceImpl;
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
 * @since 2020-01-20
 */
@RestController
@RequestMapping("/mybatis/tb-fence-info")
public class TbFenceInfoController {

    @Autowired
    private TbFenceInfoMapper fenceInfoMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TbFenceInfoServiceImpl fenceInfoService;

    @GetMapping("query/page1")
    public Object selectPageVo1() throws Exception {
        IPage<TbFenceInfo> userPage = new Page<>(1, 2);
        userPage = fenceInfoService.page(userPage);
        List<TbFenceInfo> list = userPage.getRecords();
        return objectMapper.writeValueAsString(userPage);
    }
}
