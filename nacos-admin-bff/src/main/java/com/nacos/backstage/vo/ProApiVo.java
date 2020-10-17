package com.nacos.backstage.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Integer;
import java.lang.String;

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
@ApiModel(value = " ProApiVo", description = "api管理")
@SuppressWarnings("unchecked")
public class ProApiVo {

   /**
    * 标识id
    */
    @ApiModelProperty(value = "标识id", name = "apiId")
    private Integer apiId;

   /**
    * 功能名
    */
    @ApiModelProperty(value = "功能名", name = "name")
    private String name;

   /**
    * 功能别名
    */
    @ApiModelProperty(value = "功能别名", name = "nameAs")
    private String nameAs;

   /**
    * 接口地址
    */
    @ApiModelProperty(value = "接口地址", name = "api")
    private String api;

   /**
    * 状态
    */
    @ApiModelProperty(value = "状态", name = "stat")
    private Integer stat;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", name = "statStr")
    private String statStr;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
