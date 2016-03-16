package de.codecentric.nbyl.twelvefactor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubConfiguration {

    @Value("${github.apiBaseUrl}")
    private String apiBaseUrl;

    @Value("${github.organization}")
    private String organization;

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public String getOrganization() {
        return organization;
    }
}
