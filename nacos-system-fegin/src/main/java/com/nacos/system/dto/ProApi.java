package com.nacos.system.dto;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 * <p>
    * api管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_api")
@SuppressWarnings("unchecked")
public class ProApi implements Serializable {

   /**
    * 标识id
    */
    @TableId(value = "api_id", type = IdType.AUTO)
    private Integer apiId;

   /**
    * 功能名
    */
    @TableField(value = "name")
    private String name;

   /**
    * 功能别名
    */
    @TableField(value = "name_as")
    private String nameAs;

   /**
    * 接口地址
    */
    @TableField(value = "api")
    private String api;

   /**
    * 状态
    */
    @TableField(value = "stat")
    private Integer stat;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
