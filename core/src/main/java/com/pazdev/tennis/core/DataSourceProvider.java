package com.pazdev.tennis.core;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * Class DataSourceProvider in order to get connection to database
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 05/11/2021
 */

public class DataSourceProvider {

    private static BasicDataSource singleDataSource;

    public static DataSource getSingleDataSourceInstance(){
        if(singleDataSource == null){
            singleDataSource = new BasicDataSource();
//            singleDataSource.setInitialSize(10);
            singleDataSource.setUrl("jdbc:mysql://bs4ckht6nxggx2mbd15p-mysql.services.clever-cloud.com:3306/bs4ckht6nxggx2mbd15p");
            singleDataSource.setUsername("uvupcwy9cupjwtwa");
            singleDataSource.setPassword("y9UogOKlcncjy9f8gRn6");
        }
        return singleDataSource;
    }
}
