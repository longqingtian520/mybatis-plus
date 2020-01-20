package com.criss.wang.mybatis.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MpUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @TableId中可以决定主键的类型,不写会采取默认值,默认值可以在yml中配置
     * AUTO: 数据库ID自增
     * INPUT: 用户输入ID
     * ID_WORKER: 全局唯一ID，Long类型的主键
     * ID_WORKER_STR: 字符串全局唯一ID
     * UUID: 全局唯一ID，UUID类型的主键
     * NONE: 该类型为未设置主键类型
     * ASSIGN_ID: 自定义ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String username;

    private String address;

    @Version
    private String openid;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer deleted;
}
