package cn.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.xml.validation.Validator;

/**
 * ValidationConfiguration的配置类
 */
@Slf4j
@Configuration
public class ValidationConfiguration {

    public ValidationConfiguration() {
        log.debug("创建配置类：ValidationConfiguration");
    }

    @Bean
    public javax.validation.Validator validator(){
        return Validation.byProvider(HibernateValidator.class)
                .configure()//开始配置Validator
                .failFast(true) //快速失败，即检查请求参数发现错误时直接视为失败，并不向后继续检查
                .buildValidatorFactory()
                .getValidator();

    }

}
