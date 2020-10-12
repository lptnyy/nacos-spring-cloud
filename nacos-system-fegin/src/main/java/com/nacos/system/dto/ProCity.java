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
@TableName(value = "pro_city")
@SuppressWarnings("unchecked")
public class ProCity implements Serializable {

   /**
    * 
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

   /**
    * 
    */
    @TableField(value = "city_id")
    private String cityId;

   /**
    * 
    */
    @TableField(value = "name")
    private String name;

   /**
    * 
    */
    @TableField(value = "province")
    private String province;

}
