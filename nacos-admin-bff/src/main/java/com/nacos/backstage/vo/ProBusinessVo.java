package com.nacos.backstage.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = " ProBusinessVo", description = "商家信息表 ")
@SuppressWarnings("unchecked")
public class ProBusinessVo {

   /**
    * 商家id
    */
    @ApiModelProperty(value = "商家id", name = "businessId")
    private Integer businessId;

   /**
    * 商家名称
    */
    @ApiModelProperty(value = "商家名称", name = "name")
    private String name;

   /**
    * 商家简称
    */
    @ApiModelProperty(value = "商家简称", name = "abbreviation")
    private String abbreviation;

   /**
    * 商家logo
    */
    @ApiModelProperty(value = "商家logo", name = "logo")
    private String logo;

   /**
    * 省份
    */
    @ApiModelProperty(value = "省份", name = "province")
    private String province;
    private String provinceName;

   /**
    * 城市
    */
    @ApiModelProperty(value = "城市", name = "city")
    private String city;
    private String cityName;

   /**
    * 区
    */
    @ApiModelProperty(value = "区", name = "area")
    private String area;
    private String areaName;

   /**
    * 地址
    */
    @ApiModelProperty(value = "地址", name = "address")
    private String address;

   /**
    * 经度
    */
    @ApiModelProperty(value = "经度", name = "longitude")
    private String longitude;

   /**
    * 维度
    */
    @ApiModelProperty(value = "维度", name = "latitude")
    private String latitude;

   /**
    * 介绍
    */
    @ApiModelProperty(value = "介绍", name = "introduce")
    private String introduce;

   /**
    * 类型id
    */
    @ApiModelProperty(value = "类型id", name = "typeId")
    private Integer typeId;
    private String typeName;

   /**
    * 状态
    */
    @ApiModelProperty(value = "状态", name = "state")
    private Integer state;
    private String stateName;

   /**
    * 商家图库
    */
    @ApiModelProperty(value = "商家图库", name = "imgs")
    private String imgs;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

   /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private String updateTime;

   /**
    * 删除标记
    */
    @ApiModelProperty(value = "删除标记", name = "isDel")
    private Integer isDel;

    @ApiModelProperty(value = "用户", name = "userName")
    private String userName;

    @ApiModelProperty(value = "密码", name = "password")
    private String password;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
