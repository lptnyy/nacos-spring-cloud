package com.nacos.business.dto;
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
    * 商家信息表
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_business")
@SuppressWarnings("unchecked")
public class ProBusiness implements Serializable {

   /**
    * 商家id
    */
    @TableId(value = "business_id", type = IdType.AUTO)
    private Integer businessId;

   /**
    * 商家名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * 商家简称
    */
    @TableField(value = "abbreviation")
    private String abbreviation;

   /**
    * 商家logo
    */
    @TableField(value = "logo")
    private String logo;

   /**
    * 省份
    */
    @TableField(value = "province")
    private String province;

   /**
    * 城市
    */
    @TableField(value = "city")
    private String city;

   /**
    * 区
    */
    @TableField(value = "area")
    private String area;

   /**
    * 地址
    */
    @TableField(value = "address")
    private String address;

   /**
    * 经度
    */
    @TableField(value = "longitude")
    private String longitude;

   /**
    * 维度
    */
    @TableField(value = "latitude")
    private String latitude;

   /**
    * 介绍
    */
    @TableField(value = "introduce")
    private String introduce;

   /**
    * 类型id
    */
    @TableField(value = "type_id")
    private Integer typeId;

   /**
    * 状态
    */
    @TableField(value = "state")
    private Integer state;

   /**
    * 商家图库
    */
    @TableField(value = "imgs")
    private String imgs;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

   /**
    * 更新时间
    */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "password")
    private String password;

   /**
    * 删除标记
    */
    @TableField(value = "is_del")
    private Integer isDel;

}
