package com.fchcc.carwashadmin.configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;




@EnableWebMvc
@Configuration
@ComponentScan({"com.fchcc.carwashadmin"})
@Import({SecurityConfig.class})
public class WebConfig extends WebMvcConfigurationSupport {

	
	@Autowired
	 DataSource dataSource;
	 
	 @Bean
	 public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
	  return new NamedParameterJdbcTemplate(dataSource);
	 }
	 
	 @Bean
	 public DataSource getDataSource() throws NamingException{
	  
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  
	  dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  dataSource.setUrl("jdbc:sqlserver://FCCC:1433;databaseName=carwashadmin");
	  dataSource.setPassword("root");
	  dataSource.setUsername("dB");
	  return dataSource;
	 }
	 

	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry){
	  registry.addResourceHandler("/source/**").addResourceLocations("/source/");
	  registry.addResourceHandler("/img/**").addResourceLocations("/img/");
	 }
	 
	 
	 @Bean
	 public InternalResourceViewResolver viewResolver(){
	  InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
	  internalResourceViewResolver.setViewClass(JstlView.class);
	  internalResourceViewResolver.setPrefix("/WEB-INF/");
	  internalResourceViewResolver.setSuffix(".jsp");
	  internalResourceViewResolver.setOrder(2);
	  return internalResourceViewResolver;
	 }
	 
	 @Bean  
	    public ResourceBundleViewResolver resourceBundleViewResolver() {  
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("views");
		resolver.setOrder(1);
	        return resolver;  
	    }

}

