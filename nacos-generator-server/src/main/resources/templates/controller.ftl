package ${genpkg};
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nacos.common.annotation.Authority;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.common.annotation.Log;
import ${serviceClassPath};
import ${dtoClassPath};
import ${requestClassPath};
import ${voClassPath};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.seata.spring.annotation.GlobalTransactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
    * ${tableComment}
    * </p>
 *
 * @author 王振宇
 * @since ${generatorDate}
 */
@RestController
@RequestMapping(value = "${smClassName}")
@Api(value = "${className}Controller", description = "${tableComment}")
@SuppressWarnings("unchecked")
public class ${className}Controller {

    @Autowired
    I${className}Service ${smClassName}Service;

    @PostMapping(value = "/getPageList")
    @ApiOperation(value = "分页查询列表")
    @Log(name = "${tableComment}", value = "分页查询列表", source = "${logSourceName}")
    <#if queryVali != "">
    @Authority(values = {"${queryVali}"})
    </#if>
    @SentinelResource(value = "${smClassName}/getPageList")
    public ServiceResponse<List<${className}Vo>> getPageList(@RequestBody ${className}Request request) {
      return new ServiceResponse<List<${className}Vo>>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              List<${className}> resultList = ${smClassName}Service.getPageList(new ProParameter<>(request)
                  .setRequestPage(request))
                  .checkState()
                  .copyPage(serviceResponse);

              // 组装vo 返回数据 也可以不组装直接返回原始数据
              List<${className}Vo> returnList = resultList.stream()
                .map(${smClassName} -> {
                    ${className}Vo ${smClassName}vo = new ${className}Vo();
                    BeanUtils.copyProperties(${smClassName},${smClassName}vo);
                    // vo.set 格式化一些特定的字段比如时间类型 自定义多种返回类型 应对视图层的需要
                    return ${smClassName}vo;
                })
                .collect(Collectors.toList());
              return returnList;
          })
          .exec();
    }

    @PostMapping(value = "/get")
    @ApiOperation(value = "获取单条信息")
    @Log(name = "${tableComment}", value = "获取单条信息", source = "${logSourceName}")
    <#if queryVali != "">
    @Authority(values = {"${queryVali}"})
    </#if>
    @SentinelResource(value = "${smClassName}/get")
    public ServiceResponse<${className}Vo> get(@RequestBody ${className}Request request) {
      return new ServiceResponse<${className}Vo>()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              ${className} ${smClassName} = ${smClassName}Service
                  .get(new ProParameter<>(request))
                  .checkState()
                  .response.getObj();

              // 组装返回的vo
              ${className}Vo ${smClassName}Vo = new ${className}Vo();
              BeanUtils.copyProperties(${smClassName},${smClassName}Vo);
              return ${smClassName}Vo;
          })
          .exec();
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存")
    @GlobalTransactional
    @Log(name = "${tableComment}", value = "保存", source = "${logSourceName}")
    <#if createVali != "">
    @Authority(values = {"${createVali}"})
    </#if>
    @SentinelResource(value = "${smClassName}/save")
    public ServiceResponse<${className}Vo> save(@RequestBody ${className}Request request) {
      return new ServiceResponse<${className}Vo>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 保存数据 开启事务标记 验证服务是否执行成功 失败回滚分布式事务
              ${className} ${smClassName} = ${smClassName}Service
                  .save(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();

              // 获取返回数据
              ${className}Vo ${smClassName}Vo = new ${className}Vo();
              BeanUtils.copyProperties(${smClassName},${smClassName}Vo);
              return ${smClassName}Vo;
          })
          .exec();
    }

    @PostMapping(value = "/idsDelete")
    @ApiOperation(value = "批量删除")
    @Log(name = "${tableComment}", value = "批量删除", source = "${logSourceName}")
    <#if delVali != "">
    @Authority(values = {"${delVali}"})
    </#if>
    @SentinelResource(value = "${smClassName}/idsDelete")
    @GlobalTransactional
    public ServiceResponse<Integer> idsDelete(@RequestBody ${className}Request request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 标记通过enumid删除
              request.set${pri}(1);

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return ${smClassName}Service
                  .idsDelete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除")
    @Log(name = "${tableComment}", value = "删除", source = "${logSourceName}")
    <#if delVali != "">
    @Authority(values = {"${delVali}"})
    </#if>
    @SentinelResource(value = "${smClassName}/delete")
    @GlobalTransactional
    public ServiceResponse<Integer> delete(@RequestBody ${className}Request request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {
              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return ${smClassName}Service
                  .delete(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改")
    @Log(name = "${tableComment}", value = "修改", source = "${logSourceName}")
    <#if editVali != "">
    @Authority(values = {"${editVali}"})
    </#if>
    @SentinelResource(value = "${smClassName}/update")
    @GlobalTransactional
    public ServiceResponse<Integer> update(@RequestBody ${className}Request request) {
      return new ServiceResponse<Integer>()
          .beginTransaction()
          .run(serviceResponse -> {

              // 获取调用服务返回结果 通过返回结果 进行业务判断 以及 手动控制 分布式事务回滚
              return ${smClassName}Service
                  .update(new ProParameter<>(request))
                  .beginTransaction()
                  .checkState()
                  .getObj();
          })
          .exec();
    }
}
