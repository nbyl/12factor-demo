package de.codecentric.nbyl.twelvefactor.services;

import de.codecentric.nbyl.twelvefactor.config.GithubConfiguration;
import de.codecentric.nbyl.twelvefactor.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private GithubConfiguration configuration;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Repository> getRepositories() {
        String url = configuration.getApiBaseUrl() + "/orgs/" + configuration.getOrganization() + "/repos";

        ResponseEntity<List<Repository>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
                        });
        return response.getBody();
    }
}
