package com.hx5847.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@EnableTransactionManagement
@MapperScan("com.hx5847.dao")
@PropertySource("classpath:db.properties")
@Configuration
@ComponentScan(value = "com.hx5847",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class ConfigIOC {
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${driver}")
    private String driver;
    @Value("${password}")
    private String password;

//    配置c3p0数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setPassword(password);
//        DruidDataSource  dataSource=new DruidDataSource();
//        dataSource.setUsername(user);
//        dataSource.setUrl(url);
//        dataSource.setDriverClassName(driver);
//        dataSource.setPassword(password);
        return comboPooledDataSource;
    }
//整合mybatis
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws PropertyVetoException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }

//    配置事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager() throws PropertyVetoException {

        return new DataSourceTransactionManager(dataSource());
    }

//配置字符编码过滤
//    @Bean
//    public CharacterEncodingFilter characterEncodingFilter(){
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("utf-8");
//        characterEncodingFilter.setForceRequestEncoding(true);
//        characterEncodingFilter.setForceResponseEncoding(true);
//        return characterEncodingFilter;
//    }
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();

        return commonsMultipartResolver;
    }
    @Bean
    public Object testBean(){

        return new Object();
    }
}
