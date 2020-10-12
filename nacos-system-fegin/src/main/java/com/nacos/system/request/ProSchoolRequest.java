package com.nacos.system.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.nacos.common.page.RequestPage;
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
@ApiModel(value = " ProSchoolVo", description = "")
@SuppressWarnings("unchecked")
public class ProSchoolRequest extends RequestPage {

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
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
