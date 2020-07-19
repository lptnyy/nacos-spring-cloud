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
    * 应用管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_app")
@SuppressWarnings("unchecked")
public class ProApp implements Serializable {

   /**
    * 标示id
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

   /**
    * 应用名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * AppKey
    */
    @TableField(value = "app_key")
    private String appKey;

   /**
    * AppSecret
    */
    @TableField(value = "app_secret")
    private String appSecret;

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
