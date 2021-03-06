package com.nacos.backstage.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
    * 角色菜单关系表
    * </p>
 *
 * @author 王振宇
 * @since 2020-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProRoleMenuVo", description = "角色菜单关系表")
public class ProRoleMenuVo {

   /**
    * 标示id
    */
    @ApiModelProperty(value = "标示id", name = "rmId")
    private Integer rmId;

   /**
    * 角色id
    */
    @ApiModelProperty(value = "角色id", name = "roleId")
    private Integer roleId;

   /**
    * 菜单id
    */
    @ApiModelProperty(value = "菜单id", name = "menuId")
    private Integer menuId;

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
