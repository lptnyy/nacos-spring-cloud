package com.nacos.product.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.nacos.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
    * 产品分类
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Data
@ApiModel(value = " ProProductTypeVo", description = "产品分类 ")
@SuppressWarnings("unchecked")
public class ProProductTypeRequest extends RequestPage {

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
     * 排序
     */
    @ApiModelProperty(value = "图标", name = "icon")
    private String icon;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
