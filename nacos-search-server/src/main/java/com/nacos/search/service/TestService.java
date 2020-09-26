package com.nacos.search.service;
import com.nacos.common.method.ProParameter;
import com.nacos.common.util.ServiceResponse;
import com.nacos.search.ITestService;
import com.nacos.search.dto.DocBean;
import com.nacos.search.mapper.ElasticRepository;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService implements ITestService {

  @Autowired
  ElasticsearchRestTemplate elasticsearchTemplate;
  @Autowired
  ElasticRepository elasticRepository;
  Pageable pageable = PageRequest.of(0,10);

  @Override
  public ServiceResponse<Boolean> createIndex(String index) {
    return new ServiceResponse<Boolean>()
        .run(serviceResponse -> {
            elasticsearchTemplate.createIndex(DocBean.class);
            return true;
        }).exec();
  }

  @Override
  public ServiceResponse<Boolean> deleteIndex(String index) {
    return new ServiceResponse<Boolean>()
        .run(serviceResponse -> {
          elasticsearchTemplate.deleteIndex(index);
          return true;
        }).exec();
  }

  @Override
  public ServiceResponse<Boolean> save(ProParameter<DocBean> proParameter) {
    return new ServiceResponse<Boolean>()
        .run(serviceResponse -> {
          elasticRepository.save(proParameter.getObj());
          return true;
        }).exec();
  }

  @Override
  public ServiceResponse<Boolean> saveAll(ProParameter<List<DocBean>> proParameter) {
    return new ServiceResponse<Boolean>()
        .run(serviceResponse -> {
          elasticRepository.saveAll(proParameter.getObj());
          return true;
        }).exec();
  }

  @Override
  public ServiceResponse<Iterator<DocBean>> findAll() {
    return new ServiceResponse<Iterator<DocBean>>()
        .run(serviceResponse -> {
          return elasticRepository.findAll().iterator();
        }).exec();
  }

  @Override
  public ServiceResponse<Page<DocBean>> findByContent(String content) {
    return new ServiceResponse<Page<DocBean>>()
        .run(serviceResponse -> {
          return elasticRepository.findByContent(content,pageable);
        }).exec();
  }

  @Override
  public ServiceResponse<Page<DocBean>> findByFirstCode(String firstCode) {
    return new ServiceResponse<Page<DocBean>>()
        .run(serviceResponse -> {
          return elasticRepository.findByFirstCode(firstCode,pageable);
        }).exec();
  }

  @Override
  public ServiceResponse<Page<DocBean>> findBySecordCode(String secordCode) {
    return new ServiceResponse<Page<DocBean>>()
        .run(serviceResponse -> {
          return elasticRepository.findBySecordCode(secordCode,pageable);
        }).exec();
  }

  @Override
  public ServiceResponse<Page<DocBean>> query(String key) {
    return new ServiceResponse<Page<DocBean>>()
        .run(serviceResponse -> {
          return elasticRepository.findByContent(key,pageable);
        }).exec();
  }
}
