package com.nacos.search;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.search.dto.DocBean;
import com.nacos.search.hystrix.TestServiceHystrix;
import java.util.Iterator;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "search-service", configuration = FeignRequestInterceptor.class, fallback = TestServiceHystrix.class)
public interface ITestService {

  @RequestMapping(path = "/test/createIndex", method = RequestMethod.POST)
  ServiceResponse<Boolean> createIndex(@RequestParam(value = "index") String index);

  @RequestMapping(path = "/test/deleteIndex", method = RequestMethod.POST)
  ServiceResponse<Boolean> deleteIndex(@RequestParam(value = "index") String index);

  @RequestMapping(path = "/test/save", method = RequestMethod.POST)
  ServiceResponse<Boolean> save(@RequestBody ProParameter<DocBean> proParameter);

  @RequestMapping(path = "/test/saveAll", method = RequestMethod.POST)
  ServiceResponse<Boolean> saveAll(@RequestBody ProParameter<List<DocBean>> proParameter);

  @RequestMapping(path = "/test/findAll", method = RequestMethod.POST)
  ServiceResponse<Iterator<DocBean>> findAll();

  @RequestMapping(path = "/test/findByContent", method = RequestMethod.POST)
  ServiceResponse<Page<DocBean>> findByContent(@RequestParam(value = "content") String content);

  @RequestMapping(path = "/test/findByFirstCode", method = RequestMethod.POST)
  ServiceResponse<Page<DocBean>> findByFirstCode(@RequestParam(value = "content") String firstCode);

  @RequestMapping(path = "/test/findBySecordCode", method = RequestMethod.POST)
  ServiceResponse<Page<DocBean>> findBySecordCode(@RequestParam(value = "secordCode") String secordCode);

  @RequestMapping(path = "/test/query", method = RequestMethod.POST)
  ServiceResponse<Page<DocBean>> query(@RequestParam(value = "key") String key);
}
