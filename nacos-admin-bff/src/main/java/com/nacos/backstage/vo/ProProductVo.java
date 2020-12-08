package com.nacos.backstage.vo;
import com.nacos.product.dto.ProProductInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 * <p>
    * 产品管理
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProProductVo", description = "产品管理")
@SuppressWarnings("unchecked")
public class ProProductVo {

   /**
    * 产品id
    */
    @ApiModelProperty(value = "产品id", name = "productId")
    private Integer productId;

   /**
    * 企业id
    */
    @ApiModelProperty(value = "企业id", name = "enterpriseId")
    private Integer enterpriseId;

   /**
    * 分类id
    */
    @ApiModelProperty(value = "分类id", name = "typeId")
    private Integer typeId;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id", name = "typeName")
    private String typeName;

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
     * 是否会员打折
     */
    @ApiModelProperty(value = "是否会员打折", name = "discountStsStr")
    private String discountStsStr;

   /**
    * 是否积分兑换
    */
    @ApiModelProperty(value = "是否积分兑换", name = "integralSts")
    private Integer integralSts;

    /**
     * 是否积分兑换
     */
    @ApiModelProperty(value = "是否积分兑换", name = "integralStsStr")
    private String integralStsStr;

   /**
    * 产品状态
    */
    @ApiModelProperty(value = "产品状态", name = "state")
    private Integer state;

    /**
     * 产品状态
     */
    @ApiModelProperty(value = "产品状态", name = "stateStr")
    private String stateStr;

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
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;

    /**
     * 产品介绍
     */
    private String introduce;

    /**
     * 产品图片库
     */
    private String images;
}
