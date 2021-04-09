package com.landkay.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author alice
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账号
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 所属机构ID
     */
    private String orgId;

    /**
     * 用户角色
     */
    private Integer roleCode;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime updateTime;

    /**
     * 0: 未删除, 1:已删除
     */
    private Integer isDelete;


}
