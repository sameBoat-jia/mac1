package cn.edu.tjut.stud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport
{
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
    }

//    @Override
//    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2HttpMessageConverter messageConverter=new MappingJackson2HttpMessageConverter();
//        messageConverter.setObjectMapper(new JacksonObjectMapper());
//        converters.add(0,messageConverter);
//
//    }
}
