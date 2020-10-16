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
@ApiModel(value = " ProSchoolVo", description = "")
@SuppressWarnings("unchecked")
public class ProSchoolVo {

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "schoolId")
    private Integer schoolId;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "schoolName")
    private String schoolName;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "schoolType")
    private Integer schoolType;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "areaId")
    private String areaId;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "areaName")
    private String areaName;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "displayOrder")
    private Integer displayOrder;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
