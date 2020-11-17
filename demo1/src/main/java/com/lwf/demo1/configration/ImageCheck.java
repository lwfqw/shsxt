package com.lwf.demo1.configration;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author lwf
 * @title: ImageCheck
 * @projectName demo1
 * @description: 图片验证码
 * @date 2020/11/1515:37
 */
@Configuration
public class ImageCheck {
    @Bean
    public DefaultKaptcha captchaProducer() {
        DefaultKaptcha captchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "100");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "30");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "22");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "6");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "LIGHT_GRAY");
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "WHITE");
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789");
        properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY, "checkCode");
        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        return captchaProducer;
    }

}
