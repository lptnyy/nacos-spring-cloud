package com.nacos.system.dto;
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

/**
 * <p>
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "pro_school")
@SuppressWarnings("unchecked")
public class ProSchool implements Serializable {

   /**
    * 
    */
    @TableId(value = "school_id", type = IdType.AUTO)
    private Integer schoolId;

   /**
    * 
    */
    @TableField(value = "school_name")
    private String schoolName;

   /**
    * 
    */
    @TableField(value = "school_type")
    private Integer schoolType;

   /**
    * 
    */
    @TableField(value = "area_id")
    private String areaId;

   /**
    * 
    */
    @TableField(value = "area_name")
    private String areaName;

   /**
    * 
    */
    @TableField(value = "display_order")
    private Integer displayOrder;

}
