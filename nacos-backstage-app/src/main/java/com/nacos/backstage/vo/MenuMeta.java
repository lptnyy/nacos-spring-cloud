package com.nacos.backstage.vo;

import lombok.Data;

@Data
public class MenuMeta {
    String icon;
    String title;
    String href;
    Boolean hideInMenu = false;
    Boolean hideInBread = true;
}
