package com.nacos.xiaoshuo.request;
import com.nacos.common.page.RequestPage;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.String;

/**
 * <p>
    *
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-15
 */
@Data
@ApiModel(value = " XiaoshuoNoveltypeVo", description = "")
@SuppressWarnings("unchecked")
public class XiaoshuoNoveltypeRequest extends RequestPage {

   /**
    *
    */
    @ApiModelProperty(value = "", name = "id")
    private Integer id;

   /**
    *
    */
    @ApiModelProperty(value = "", name = "name")
    private String name;

   /**
    *
    */
    @ApiModelProperty(value = "", name = "sort")
    private Integer sort;

   /**
    *
    */
    @ApiModelProperty(value = "", name = "createTime")
    private String createTime;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
