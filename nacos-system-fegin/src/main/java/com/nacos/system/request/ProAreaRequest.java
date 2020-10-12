package com.nacos.system.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.nacos.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = " ProAreaVo", description = "")
@SuppressWarnings("unchecked")
public class ProAreaRequest extends RequestPage {

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "id")
    private Integer id;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "areaId")
    private String areaId;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "name")
    private String name;

   /**
    * 
    */
    @ApiModelProperty(value = "", name = "cityId")
    private String cityId;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
