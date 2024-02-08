package org.kamar.hanjamauthserver.global_configuration;

import org.kamar.hanjamauthserver.global_configuration_properties.DatabaseProperties;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseInitializationConfiguration {


    @Bean
    public SqlDataSourceScriptDatabaseInitializer databaseInitializer(
            DatabaseProperties databaseProperties,
            SqlInitializationProperties sqlProperties
    ){

        /*create the datasource*/
        DataSource dataSource = DataSourceBuilder
                .create()
                .type(SimpleDriverDataSource.class)
                .url(databaseProperties.url())
                .username(databaseProperties.user())
                .password(databaseProperties.password())
                .build();

        return new SqlDataSourceScriptDatabaseInitializer(dataSource, sqlProperties);

    }
}
