package com.nacos.system.request;
import com.nacos.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * <p>
    * 菜单表
    * </p>
 *
 * @author 王振宇
 * @since 2020-04-12
 */
@Data
@ApiModel(value = " ProMenuVo", description = "菜单表 ")
public class ProMenuRequest extends RequestPage {

   /**
    * 标示id
    */
    @ApiModelProperty(value = "标示id", name = "menuId")
    private Integer menuId;

   /**
    *
    */
    @ApiModelProperty(value = "", name = "title")
    private String title;

   /**
    * 名称
    */
    @ApiModelProperty(value = "名称", name = "name")
    private String name;

   /**
    * 物理地址
    */
    @ApiModelProperty(value = "物理地址", name = "path")
    private String path;

   /**
    * 图标
    */
    @ApiModelProperty(value = "图标", name = "icon")
    private String icon;

   /**
    * 父级id
    */
    @ApiModelProperty(value = "父级id", name = "parentId")
    private Integer parentId;

   /**
    * 类型
    */
    @ApiModelProperty(value = "类型", name = "type")
    private String type;

   /**
    * 创建事件
    */
    @ApiModelProperty(value = "创建事件", name = "createTime")
    private String createTime;

   /**
    *
    */
    @ApiModelProperty(value = "", name = "jurisdiction")
    private String jurisdiction;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
