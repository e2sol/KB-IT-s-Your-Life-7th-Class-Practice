package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackages = "org.scoula.mapper")
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = {
        "org.scoula.advice",
        "org.scoula.sample.service",
        "org.scoula.service"
})
public class RootConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();

        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();

        factory.setDataSource(dataSource);

        factory.setConfigLocation(
                new PathMatchingResourcePatternResolver()
                        .getResource("classpath:mybatis-config.xml")
        );

        factory.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mappers/*.xml")
        );

        return factory.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}