package com.criss.wang.mybatis.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.criss.wang.mybatis.entity.MpUser;
import com.criss.wang.mybatis.mapper.MpUserMapper;
import com.criss.wang.mybatis.service.impl.MpUserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-16
 */
@RestController
@RequestMapping("/user/mp-user")
public class MpUserController {

    @Autowired
    private MpUserServiceImpl mpUserService;

    @Autowired
    private MpUserMapper mpUserMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("add")
    public Object add() {
        MpUser user = new MpUser();
        user.setId(1l);
        user.setAddress("qingdaobaoshan");
        user.setUsername("wang");
        user.setOpenid("wang");
        mpUserService.save(user);
        return "add";
    }

    @GetMapping("query")
    public Object query(@RequestParam(name = "id", required = false) int id) throws Exception {
        MpUser user = mpUserService.getById(id);
        return objectMapper.writeValueAsString(user);
    }

    @PostMapping("batch")
    public Object saveBatch(@RequestBody List<MpUser> users) {
        mpUserService.saveBatch(users);
        return "batch";
    }

    @PostMapping("save")
    public Object saveOrUpdate(@RequestBody MpUser user) {
        mpUserService.saveOrUpdate(user);
        return "saveOrUpdate";
    }

    @GetMapping("query/optional")
    public Object listByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "liming");
        Collection<MpUser> users = mpUserService.listByMap(map);
        return objectMapper.writeValueAsString(users);
    }

    // TODO YOUWENTI
    @GetMapping("query/page")
    public Object selectPageVo(@RequestParam(name = "currPage", required = false) int currPage, @RequestParam(name = "pageSize", required = false) int pageSize) throws Exception {
        currPage = currPage == 0 ? 1 : currPage;
        pageSize = pageSize == 5 ? 3 : pageSize;
        Page<MpUser> page = new Page<>(currPage, pageSize);
        IPage<MpUser> users = mpUserService.selectUserPage(page, 0);
        return objectMapper.writeValueAsString(users);
    }

    @GetMapping("query/page1")
    public Object selectPageVo1() throws Exception {
        IPage<MpUser> userPage = new Page<>(2, 2);
        userPage = mpUserService.page(userPage);
        List<MpUser> list = userPage.getRecords();
        return objectMapper.writeValueAsString(userPage);
    }

    @GetMapping("query/custom")
    public Object selectList() throws Exception {
        QueryWrapper<MpUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "wang");
        List<MpUser> list = mpUserMapper.selectList(wrapper);
        return objectMapper.writeValueAsString(list);
    }

    @GetMapping("query/map/params")
    public Object selectMapParam() throws Exception {
        QueryWrapper<MpUser> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("username", "wang");
        map.put("id", 3);
        wrapper.allEq(map);
        List<MpUser> list = mpUserMapper.selectList(wrapper);
        return objectMapper.writeValueAsString(list);
    }

    @GetMapping("query/columns")
    public Object queryColumn() throws Exception {
        QueryWrapper<MpUser> wrapper = new QueryWrapper<>();
        wrapper.select("id, username, address");
        wrapper.eq("username", "你好");
        List<MpUser> list = mpUserMapper.selectList(wrapper);
        return objectMapper.writeValueAsString(list);
    }

    @PutMapping("update/columns")
    public Object updateWrapper() {
        UpdateWrapper<MpUser> wrapper = new UpdateWrapper<>();
        // 法一：
        wrapper.eq("id", 2);
        MpUser user = new MpUser();
        user.setUsername("大家好啊");
        // 法二：
        wrapper.eq("openid", "wang").eq("id", 2).set("address", "北京");
        return mpUserMapper.update(user, wrapper);
    }

    @GetMapping("query/ordinary")
    public Object ordinaryQuery() throws Exception {
        List<MpUser> users = mpUserService.selectUser();
        return objectMapper.writeValueAsString(users);
    }

    @PutMapping("update/version")
    public Object updateWithVersion(@RequestParam(name = "openid") String openid){
        MpUser user = new MpUser();
        user.setId(2l);
        user.setOpenid(openid);
        user.setUsername("criss");
        if(mpUserService.updateById(user)){
            System.out.println("update successfully");
        }else{
            System.out.println("update failed due to modified by others");
        }
        return 1;
    }


}
