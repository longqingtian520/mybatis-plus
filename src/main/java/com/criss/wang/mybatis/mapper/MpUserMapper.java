package com.criss.wang.mybatis.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.criss.wang.mybatis.entity.MpUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-16
 */
public interface MpUserMapper extends BaseMapper<MpUser> {
    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param state 状态
     * @return 分页对象
     */
    IPage<MpUser> selectPageVo(Page<MpUser> page, Integer state);

    /*
     * @Author wangqiubao
     * @Date 2020/1/19 15:48
     * @Param []
     * @return java.util.List<com.criss.wang.mybatis.entity.MpUser>
     * @Description 
     */
    @Select("select id, username, address from mp_user")
    List<MpUser> selectUser();
}
