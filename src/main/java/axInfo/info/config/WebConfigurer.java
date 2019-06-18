package axInfo.info.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import axInfo.info.Interceptor.LoginInterceptor;

@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter{
	
		// TODO Auto-generated method stub
		
	 // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
		  
		  registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/register").excludePathPatterns("/user/userSave").excludePathPatterns("/user/Login").excludePathPatterns("/test");
	    // addPathPatterns("/**") 表示拦截所有的请求，
	    // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
	  //  registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/register");
	    
	    super.addInterceptors(registry);
	  }

}
