package com.nacos.member.dto;
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
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
    * 会员等级 会员等级
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_level")
@SuppressWarnings("unchecked")
public class ProLevel implements Serializable {

   /**
    * 等级id
    */
    @TableId(value = "level_id", type = IdType.AUTO)
    private Integer levelId;

   /**
    * 等级名称
    */
    @TableField(value = "level_name")
    private String levelName;

   /**
    * 展示图片
    */
    @TableField(value = "image")
    private String image;

   /**
    * 等级积分
    */
    @TableField(value = "integral")
    private Integer integral;

   /**
    * 等级价格
    */
    @TableField(value = "price")
    private BigDecimal price;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

}
