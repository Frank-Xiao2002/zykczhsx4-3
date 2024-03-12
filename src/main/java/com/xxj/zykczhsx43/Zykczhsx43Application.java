package com.xxj.zykczhsx43;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = {"com.xxj.zykczhsx43.dao"})
public class Zykczhsx43Application {
    public static void main(String[] args) {
        SpringApplication.run(Zykczhsx43Application.class, args);
    }

    @Bean
    public DataSource configDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://frankdb.mysql.database.azure" +
                ".com:3306/zykczhsx4?serverTimezone=UTC&useSSL=true&requireSSL=false");
        dataSourceBuilder.username("frank");
        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl("https://frankserver1.vault.azure.net")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
        dataSourceBuilder.password(secretClient.getSecret("dbpassword").getValue());
        return dataSourceBuilder.build();
    }
}

