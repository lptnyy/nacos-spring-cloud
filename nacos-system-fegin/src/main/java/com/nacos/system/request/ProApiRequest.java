package com.nacos.system.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.nacos.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 * <p>
    * api管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@Data
@ApiModel(value = " ProApiVo", description = "api管理")
@SuppressWarnings("unchecked")
public class ProApiRequest extends RequestPage {

   /**
    * 标识id
    */
    @ApiModelProperty(value = "标识id", name = "apiId")
    private Integer apiId;

   /**
    * 功能名
    */
    @ApiModelProperty(value = "功能名", name = "name")
    private String name;

   /**
    * 功能别名
    */
    @ApiModelProperty(value = "功能别名", name = "nameAs")
    private String nameAs;

   /**
    * 接口地址
    */
    @ApiModelProperty(value = "接口地址", name = "api")
    private String api;

   /**
    * 状态
    */
    @ApiModelProperty(value = "状态", name = "stat")
    private Integer stat;

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
