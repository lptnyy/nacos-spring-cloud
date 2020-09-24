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
@TableName(value = "pro_member")
@SuppressWarnings("unchecked")
public class ProMember implements Serializable {

   /**
    * 会员id
    */
    @TableId(value = "member_id", type = IdType.AUTO)
    private Integer memberId;

   /**
    * 会员号
    */
    @TableField(value = "member_no")
    private String memberNo;

   /**
    * 会员昵称
    */
    @TableField(value = "nick_name")
    private String nickName;

   /**
    * 会员账号
    */
    @TableField(value = "user_name")
    private String userName;

   /**
    * 会员密码
    */
    @TableField(value = "pass_word")
    private String passWord;

   /**
    * 会员头像
    */
    @TableField(value = "head_portrait")
    private String headPortrait;

   /**
    * 会员简介
    */
    @TableField(value = "ntroduction")
    private String ntroduction;

   /**
    * 性别
    */
    @TableField(value = "sex")
    private String sex;

   /**
    * 年龄
    */
    @TableField(value = "age")
    private String age;

   /**
    * 省份
    */
    @TableField(value = "province")
    private String province;

   /**
    * 城市
    */
    @TableField(value = "city")
    private String city;

   /**
    * 区
    */
    @TableField(value = "area")
    private String area;

   /**
    * 学校
    */
    @TableField(value = "school")
    private String school;

   /**
    * 会员等级
    */
    @TableField(value = "level_Id")
    private Integer levelId;

   /**
    * 会员状态
    */
    @TableField(value = "state")
    private String state;

   /**
    * 充值密码
    */
    @TableField(value = "pay_password")
    private String payPassword;

   /**
    * 提现密码
    */
    @TableField(value = "withdrawal_password")
    private String withdrawalPassword;

   /**
    * 创建时间
    */
    @TableField(value = "create_time")
    private Date createTime;

   /**
    * 更新时间
    */
    @TableField(value = "update_time")
    private Date updateTime;

}
