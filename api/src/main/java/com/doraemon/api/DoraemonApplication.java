package com.doraemon.api;

import com.doraemon.api.config.shiro.RestUserFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.AbstractShiroWebFilterConfiguration;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.Map;

/**
 * @author wl
 */
@SpringBootApplication(scanBasePackages = "com.doraemon")
public class DoraemonApplication extends AbstractShiroWebFilterConfiguration {
  public static void main(String[] args) {
    SpringApplication.run(DoraemonApplication.class, args);
  }

  /**
   * shiro 默认配置为 /** = authc (FormAuthenticationFilter)
   */
  @Bean
  public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    final DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
    chainDefinition.addPathDefinition("/session", "anon");
    return chainDefinition;
  }

  @Override
  @Bean
  protected ShiroFilterFactoryBean shiroFilterFactoryBean() {
    final ShiroFilterFactoryBean shiroFilterFactoryBean = super.shiroFilterFactoryBean();
    final Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
    filters.put("rest-user", new RestUserFilter());

    return shiroFilterFactoryBean;
  }
}
