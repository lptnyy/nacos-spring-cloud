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
    * 商家类型 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProBusinessTypeVo", description = "商家类型 ")
@SuppressWarnings("unchecked")
public class ProBusinessTypeVo {

   /**
    * 类型id
    */
    @ApiModelProperty(value = "类型id", name = "typeId")
    private Integer typeId;

   /**
    * 类型名称
    */
    @ApiModelProperty(value = "类型名称", name = "name")
    private String name;

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
