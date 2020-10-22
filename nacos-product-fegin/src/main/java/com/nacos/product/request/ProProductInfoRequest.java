package com.nacos.product.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.nacos.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.String;

/**
 * <p>
    * 产品详情
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Data
@ApiModel(value = " ProProductInfoVo", description = "产品详情 ")
@SuppressWarnings("unchecked")
public class ProProductInfoRequest extends RequestPage {

   /**
    * 产品id
    */
    @ApiModelProperty(value = "产品id", name = "productId")
    private Integer productId;

   /**
    * 图库
    */
    @ApiModelProperty(value = "图库", name = "imgs")
    private String imgs;

   /**
    * 产品介绍
    */
    @ApiModelProperty(value = "产品介绍", name = "introduce")
    private String introduce;

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
