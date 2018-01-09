package com.bestcode.study.shiro.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;
import java.io.IOException;

/**
 * @author xch
 * @create 2018-01-10 0:01
 **/
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet());
        //白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        // 黑名单（存在共同时，deny优先于allow：如果满足deny的即提示：Sorry, you are not permission）
        servletRegistrationBean.addInitParameter("deny","192.168.1.100");
        // 登录查看账号信息的账号密码
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","11111111");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.icon");
        return bean;
    }

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean(name="dataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:/mappers/*.xml"));
        return bean;
    }
}
