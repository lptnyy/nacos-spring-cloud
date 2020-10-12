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
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProProvinceVo", description = "")
@SuppressWarnings("unchecked")
public class ProProvinceVo {

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "id")
    private Integer id;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "provinceId")
    private String provinceId;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "name")
    private String name;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
