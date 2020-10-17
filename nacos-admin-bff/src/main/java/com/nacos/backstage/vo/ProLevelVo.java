package com.nacos.backstage.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = " ProLevelVo", description = "会员等级 会员等级")
@SuppressWarnings("unchecked")
public class ProLevelVo {

   /**
    * 等级id
    */
    @ApiModelProperty(value = "等级id", name = "levelId")
    private Integer levelId;

   /**
    * 等级名称
    */
    @ApiModelProperty(value = "等级名称", name = "levelName")
    private String levelName;

   /**
    * 展示图片
    */
    @ApiModelProperty(value = "展示图片", name = "image")
    private String image;

   /**
    * 等级积分
    */
    @ApiModelProperty(value = "等级积分", name = "integral")
    private Integer integral;

   /**
    * 等级价格
    */
    @ApiModelProperty(value = "等级价格", name = "price")
    private BigDecimal price;

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
}
