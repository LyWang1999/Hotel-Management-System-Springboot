package cn.zjut.hotel.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kuluo
 * @description druid控制台
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
public class DruidConfig {

    /**
     * 配置数据源连接
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置管理后台的Servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> map = new HashMap<>(4);
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        /*
          不写或者为null默认允许所有
         */
        map.put("allow", "127.0.0.1");
        bean.setInitParameters(map);
        return bean;
    }

    /**
     * 配置监控的Filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean initParam = new FilterRegistrationBean();
        initParam.setFilter(new WebStatFilter());

        Map<String, String> map = new HashMap<>(1);
        /*
          初始化不拦截请求的参数
         */
        map.put("exclusions", "/druid/*");
        initParam.setInitParameters(map);
        return initParam;
    }
}
