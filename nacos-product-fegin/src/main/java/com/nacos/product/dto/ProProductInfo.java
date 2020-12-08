package com.nacos.product.dto;
import java.io.Serializable;
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
    * 产品详情
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_product_info")
@SuppressWarnings("unchecked")
public class ProProductInfo implements Serializable {

   /**
    * 产品id
    */
    @TableId(value = "product_id")
    private Integer productId;

   /**
    * 图库
    */
    @TableField(value = "imgs")
    private String imgs;

   /**
    * 产品介绍
    */
    @TableField(value = "introduce")
    private String introduce;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
