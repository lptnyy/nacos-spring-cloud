package com.nacos.product.request;
import lombok.Data;
import java.util.List;
import java.lang.Integer;
import com.nacos.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
    * 产品管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Data
@ApiModel(value = " ProProductVo", description = "产品管理")
@SuppressWarnings("unchecked")
public class ProProductRequest extends RequestPage {

   /**
    * 产品id
    */
    @ApiModelProperty(value = "产品id", name = "productId")
    private Integer productId;

   /**
    * 企业id
    */
    @ApiModelProperty(value = "企业id", name = "enterpriseId")
    private Integer businessId;

   /**
    * 分类id
    */
    @ApiModelProperty(value = "分类id", name = "typeId")
    private Integer typeId;

   /**
    * 标题
    */
    @ApiModelProperty(value = "标题", name = "title")
    private String title;

   /**
    * 子标题
    */
    @ApiModelProperty(value = "子标题", name = "subtitle")
    private String subtitle;

   /**
    * 列表展示图片
    */
    @ApiModelProperty(value = "列表展示图片", name = "image")
    private String image;

    /**
     * 列表展示图片
     */
    @ApiModelProperty(value = "产品图库", name = "images")
    private String images;

   /**
    * 赞数
    */
    @ApiModelProperty(value = "赞数", name = "fabulousNum")
    private Integer fabulousNum;

   /**
    * 评论数
    */
    @ApiModelProperty(value = "评论数", name = "commentNum")
    private Integer commentNum;

   /**
    * 销售数量
    */
    @ApiModelProperty(value = "销售数量", name = "salesNum")
    private Integer salesNum;

   /**
    * 分享数
    */
    @ApiModelProperty(value = "分享数", name = "shareNum")
    private Integer shareNum;

   /**
    * 是否会员打折
    */
    @ApiModelProperty(value = "是否会员打折", name = "discountSts")
    private Integer discountSts;

   /**
    * 是否积分兑换
    */
    @ApiModelProperty(value = "是否积分兑换", name = "integralSts")
    private Integer integralSts;

   /**
    * 产品状态
    */
    @ApiModelProperty(value = "产品状态", name = "state")
    private Integer state;

   /**
    * 运费方式
    */
    @ApiModelProperty(value = "运费方式", name = "freightId")
    private Integer freightId;

   /**
    * 排序
    */
    @ApiModelProperty(value = "排序", name = "sort")
    private Integer sort;

   /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private String updateTime;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

    /**
     * 产品介绍
     */
    @ApiModelProperty(value = "产品介绍", name = "introduce")
    private String introduce;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
