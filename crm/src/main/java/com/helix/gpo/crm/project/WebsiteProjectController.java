package com.helix.gpo.crm.project;

import com.helix.gpo.crm.shared.payload.website.project.WebsiteProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/website/projects")
@RequiredArgsConstructor
class WebsiteProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<WebsiteProjectDto>> getAllWebsiteProjects() {
        return new ResponseEntity<>(projectService.getAllWebsiteProjects(), HttpStatus.OK);
    }

    @GetMapping(value = "/{projectId}")
    public ResponseEntity<WebsiteProjectDto> getWebsiteProject(@PathVariable(name = "projectId") Long projectId) {
        return new ResponseEntity<>(projectService.getWebsiteProjectById(projectId), HttpStatus.OK);
    }

}
