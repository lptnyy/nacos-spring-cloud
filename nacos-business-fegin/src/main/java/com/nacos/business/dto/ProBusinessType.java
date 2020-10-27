package com.nacos.business.dto;
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
    * 商家类型
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_business_type")
@SuppressWarnings("unchecked")
public class ProBusinessType implements Serializable {

   /**
    * 类型id
    */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

   /**
    * 类型名称
    */
    @TableField(value = "name")
    private String name;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 删除标记
     */
    @TableField(value = "is_del")
    private Integer isDel;
}
