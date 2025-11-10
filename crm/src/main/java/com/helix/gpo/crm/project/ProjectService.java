package com.helix.gpo.crm.project;

import com.helix.gpo.crm.shared.payload.website.project.WebsiteProjectDto;

import java.util.List;

interface ProjectService {

    List<WebsiteProjectDto> getAllWebsiteProjects();

    WebsiteProjectDto getProjectByid(Long projectId);

}
