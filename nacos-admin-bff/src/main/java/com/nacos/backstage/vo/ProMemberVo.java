package com.nacos.backstage.vo;
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
    * 会员表 会员
    * </p>
 *
 * @author 王振宇
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = " ProMemberVo", description = "会员表 会员")
@SuppressWarnings("unchecked")
public class ProMemberVo {

   /**
    * 会员id
    */
    @ApiModelProperty(value = "会员id", name = "memberId")
    private Integer memberId;

   /**
    * 会员号
    */
    @ApiModelProperty(value = "会员号", name = "memberNo")
    private String memberNo;

   /**
    * 会员昵称
    */
    @ApiModelProperty(value = "会员昵称", name = "nickName")
    private String nickName;

   /**
    * 会员账号
    */
    @ApiModelProperty(value = "会员账号", name = "userName")
    private String userName;

   /**
    * 会员密码
    */
    @ApiModelProperty(value = "会员密码", name = "passWord")
    private String passWord;

   /**
    * 会员头像
    */
    @ApiModelProperty(value = "会员头像", name = "headPortrait")
    private String headPortrait;

   /**
    * 会员简介
    */
    @ApiModelProperty(value = "会员简介", name = "ntroduction")
    private String ntroduction;

   /**
    * 性别
    */
    @ApiModelProperty(value = "性别", name = "sex")
    private String sex;

    /**
     * 性别字符串
     */
    private String sexStr;

   /**
    * 年龄
    */
    @ApiModelProperty(value = "年龄", name = "age")
    private String age;

   /**
    * 省份
    */
    @ApiModelProperty(value = "省份", name = "province")
    private String province;
    @ApiModelProperty(value = "省份字符", name = "province")
    private String provinceStr;

   /**
    * 城市
    */
    @ApiModelProperty(value = "城市", name = "city")
    private String city;
    private String cityStr;

   /**
    * 区
    */
    @ApiModelProperty(value = "区", name = "area")
    private String area;
    private String areaStr;
   /**
    * 学校
    */
    @ApiModelProperty(value = "学校", name = "school")
    private String school;

   /**
    * 会员等级
    */
    @ApiModelProperty(value = "会员等级", name = "levelId")
    private Integer levelId;

   /**
    * 会员状态
    */
    @ApiModelProperty(value = "会员状态", name = "state")
    private String state;

    /**
     * 会员状态
     */
    @ApiModelProperty(value = "会员状态(字符串)", name = "stateStr")
    private String stateStr;

   /**
    * 充值密码
    */
    @ApiModelProperty(value = "充值密码", name = "payPassword")
    private String payPassword;

   /**
    * 提现密码
    */
    @ApiModelProperty(value = "提现密码", name = "withdrawalPassword")
    private String withdrawalPassword;

   /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

   /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private String updateTime;

   /**
    * in 查询操作 批量删除
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
