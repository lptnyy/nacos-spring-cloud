package com.nacos.product.dto;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
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
@TableName(value = "pro_product")
@SuppressWarnings("unchecked")
public class ProProduct implements Serializable {

   /**
    * 产品id
    */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

   /**
    * 企业id
    */
    @TableField(value = "business_id")
    private Integer businessId;

   /**
    * 分类id
    */
    @TableField(value = "type_id")
    private Integer typeId;

   /**
    * 标题
    */
    @TableField(value = "title")
    private String title;

   /**
    * 子标题
    */
    @TableField(value = "subtitle")
    private String subtitle;

   /**
    * 列表展示图片
    */
    @TableField(value = "image")
    private String image;

   /**
    * 赞数
    */
    @TableField(value = "fabulous_num")
    private Integer fabulousNum;

   /**
    * 评论数
    */
    @TableField(value = "comment_num")
    private Integer commentNum;

   /**
    * 销售数量
    */
    @TableField(value = "sales_num")
    private Integer salesNum;

   /**
    * 分享数
    */
    @TableField(value = "share_num")
    private Integer shareNum;

   /**
    * 是否会员打折
    */
    @TableField(value = "discount_sts")
    private Integer discountSts;

   /**
    * 是否积分兑换
    */
    @TableField(value = "integral_sts")
    private Integer integralSts;

   /**
    * 产品状态
    */
    @TableField(value = "state")
    private Integer state;

   /**
    * 运费方式
    */
    @TableField(value = "freight_id")
    private Integer freightId;

   /**
    * 排序
    */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 来源
     */
    @TableField(value = "source")
    private Integer source;

   /**
    * 更新时间
    */
    @TableField(value = "update_time")
    private Date updateTime;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
