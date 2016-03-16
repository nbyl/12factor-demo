package de.codecentric.nbyl.twelvefactor.web;

import de.codecentric.nbyl.twelvefactor.model.Repository;
import de.codecentric.nbyl.twelvefactor.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/repositories")
    public
    @ResponseBody
    List<Repository> getRepositories() {
        return organizationService.getRepositories();
    }
}
