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
    * 产品分类
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProProductTypeVo", description = "产品分类 ")
@SuppressWarnings("unchecked")
public class ProProductTypeVo {

   /**
    * 分类id
    */
    @ApiModelProperty(value = "分类id", name = "typeId")
    private Integer typeId;

   /**
    * 分类名称
    */
    @ApiModelProperty(value = "分类名称", name = "name")
    private String name;

   /**
    * 排序
    */
    @ApiModelProperty(value = "排序", name = "sort")
    private Integer sort;

   /**
    * 父级id
    */
    @ApiModelProperty(value = "父级id", name = "parentId")
    private Integer parentId;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级名称", name = "parentName")
    private String parentName;

    /**
     * 图标
     */
    @ApiModelProperty(value = "父级名称", name = "parentName")
    private String icon;

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
