package com.nacos.backstage.vo;

import java.util.List;
import lombok.Data;

@Data
public class Menu {
    String path;
    String name;
    MenuMeta meta;
    String type;
    List<Menu> children;
}
