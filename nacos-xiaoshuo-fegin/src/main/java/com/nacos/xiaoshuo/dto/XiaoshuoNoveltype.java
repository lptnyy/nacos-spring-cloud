package com.nacos.xiaoshuo.dto;
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
    * 
    * </p>
 *
 * @author 王振宇
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "xiaoshuo_noveltype")
@SuppressWarnings("unchecked")
public class XiaoshuoNoveltype implements Serializable {

   /**
    * 
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

   /**
    * 
    */
    @TableField(value = "name")
    private String name;

   /**
    * 
    */
    @TableField(value = "sort")
    private Integer sort;

   /**
    * 
    */
    @TableField(value = "create_time")
    private Date createTime;

}
