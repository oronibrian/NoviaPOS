 package ke.novia.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
 import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
 @Configuration
 @ComponentScan(basePackages =  { "ke.novia.controller", "ke.novia.service" })//
 //
 
 
 /*
 @ComponentScan(basePackages = "com.concretepage",
     includeFilters = @Filter(type = FilterType.REGEX, pattern="com.concretepage.*.*Util"),
     excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = IUserService.class))
 */
/*
@ComponentScan(basePackages = "ke.novia",
     includeFilters = @Filter(type = FilterType.REGEX, pattern="ke.novia.service.*"),
     excludeFilters = @Filter(type = FilterType.REGEX, pattern = "ke.novia.controller.*,ke.novia.model.*,ke.novia.dao.*")
 )
 */
 public class SystemConfig {}

