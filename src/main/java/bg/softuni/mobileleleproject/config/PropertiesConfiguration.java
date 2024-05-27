package bg.softuni.mobileleleproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("mobilelele.env")
public class PropertiesConfiguration {

    private String rememberMeKey;

    public String getRememberMeKey() {
        return rememberMeKey;
    }

    public PropertiesConfiguration setRememberMeKey(String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
        return this;
    }
}