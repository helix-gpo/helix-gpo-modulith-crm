package com.helix.gpo.crm.project;

import com.helix.gpo.crm.shared.payload.website.project.WebsiteProjectDto;
import org.springframework.modulith.NamedInterface;

import java.util.List;

@NamedInterface(name = "projectServiceApi")
public interface ProjectServiceApi {

    List<WebsiteProjectDto> getAllWebsiteProjects();

    WebsiteProjectDto getProjectByid(Long projectId);

}
