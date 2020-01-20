package com.criss.wang.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangqiubao
 * @since 2020-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TB_FENCE_INFO")
public class TbFenceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 加密后的id
     */
    private String fenceId;

    /**
     * 电子围栏名称
     */
    private String name;

    /**
     * 项目id
     */
    private String spId;

    /**
     * 用户id
     */
    private Long usrId;

    /**
     * 用户类型
     */
    private String usrType;

    /**
     * 最大高度
     */
    private Integer minHeight;

    /**
     * 最大高度
     */
    private Integer maxHeight;

    /**
     * 电子围栏坐标，格式：经度，纬度，经度，纬度...
     */
    private String fenceStr;

    /**
     * 是否已删除 1：是；0：否
     */
    private Boolean deleted;

    private LocalDateTime createdate;


}
