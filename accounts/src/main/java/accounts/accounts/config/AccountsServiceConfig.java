package accounts.accounts.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "accounts")
@Data
public class AccountsServiceConfig {
    private String msg;
    private String buildVersion;

}
