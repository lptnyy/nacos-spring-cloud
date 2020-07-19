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
    * 应用管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-19
 */
@Data
@ApiModel(value = " ProAppVo", description = "应用管理")
@SuppressWarnings("unchecked")
public class ProAppRequest extends RequestPage {

   /**
    * 标示id
    */
    @ApiModelProperty(value = "标示id", name = "id")
    private Integer id;

   /**
    * 应用名称
    */
    @ApiModelProperty(value = "应用名称", name = "name")
    private String name;

   /**
    * AppKey
    */
    @ApiModelProperty(value = "AppKey", name = "appKey")
    private String appKey;

   /**
    * AppSecret
    */
    @ApiModelProperty(value = "AppSecret", name = "appSecret")
    private String appSecret;

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
