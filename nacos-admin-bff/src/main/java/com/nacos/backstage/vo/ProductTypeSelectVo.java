package com.nacos.backstage.vo;
import java.util.List;
import lombok.Data;

@Data
public class ProductTypeSelectVo {
  String label;
  Boolean expand;
  Integer id;
  List<ProductTypeSelectVo> children;
}
