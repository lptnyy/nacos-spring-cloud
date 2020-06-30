package com.nacos.generator.util;

import com.nacos.generator.controller.request.TableInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class SqlUtil {

    /**
     * 获取数据库链接
     * @param tableInfo
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection getConnection(TableInfo tableInfo) throws SQLException, ClassNotFoundException {
        // 注册 JDBC 驱动
        Class.forName(tableInfo.getMysqlDev());
        Connection connection = DriverManager.getConnection(tableInfo.getMysql(),tableInfo.getMysqlUser(),tableInfo.getMysqlPass());
        return connection;
    }
}
