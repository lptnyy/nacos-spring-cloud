package com.nacos.system.request;
import com.nacos.common.page.RequestPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * <p>
    * 枚举表
    * </p>
 *
 * @author 王振宇
 * @since 2020-05-02
 */
@Data
@ApiModel(value = " ProEnumVo", description = "枚举表 ")
public class ProEnumRequest extends RequestPage {

   /**
    * 枚举id
    */
    @ApiModelProperty(value = "枚举id", name = "enumId")
    private Integer enumId;

   /**
    * key
    */
    @ApiModelProperty(value = "key", name = "keystr")
    private String keystr;

   /**
    * value
    */
    @ApiModelProperty(value = "value", name = "valuestr")
    private String valuestr;

   /**
    * type
    */
    @ApiModelProperty(value = "type", name = "type")
    private String type;

   /**
    * create_time
    */
    @ApiModelProperty(value = "create_time", name = "createTime")
    private String createTime;

   /**
    * in 查询操作
    */
    @ApiModelProperty(value = "in 查询操作 批量删除", name = "ids")
    private List<Integer> ids;
}
