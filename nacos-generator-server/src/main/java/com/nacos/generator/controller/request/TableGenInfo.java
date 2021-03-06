package com.nacos.generator.controller.request;

import lombok.Data;

@Data
public class TableGenInfo {
    String dataType;
    String columnComment;
    String columnKey;
    String columnName;
    String backSelectType;
    String webSelectType;
    String sort;
}
