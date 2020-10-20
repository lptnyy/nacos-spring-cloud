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
    * 产品分类
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_product_type")
@SuppressWarnings("unchecked")
public class ProProductType implements Serializable {

   /**
    * 分类id
    */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

   /**
    * 分类名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * 排序
    */
    @TableField(value = "sort")
    private Integer sort;

   /**
    * 父级id
    */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 图标地址
     */
    @TableField(value = "icon")
    private String icon;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
