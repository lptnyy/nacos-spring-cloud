package com.nacos.generator.controller.request;

import java.util.List;
import lombok.Data;

@Data
public class TableInfo {
    String mysql;
    String mysqlDev;
    String apiPkg;
    String controllerPkg;
    String voPkg;
    String servicePkg;
    String serviceImplPkg;
    String mapperPkg;
    String dtoPgk;
    String mysqlUser;
    String mysqlPass;
    String tableName;
    String feignClientService;
    String gateWayPath;
    String logSourceName;
    String createVali;
    String queryVali;
    String delVali;
    String editVali;
    List<TableGenInfo> tableGenInfos;
}
