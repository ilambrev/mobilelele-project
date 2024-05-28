package bg.softuni.mobileleleproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mobilelele.auth")
public class AuthPropertiesConfiguration {

    private String rememberMeKey;

    public String getRememberMeKey() {
        return rememberMeKey;
    }

    public AuthPropertiesConfiguration setRememberMeKey(String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
        return this;
    }
}