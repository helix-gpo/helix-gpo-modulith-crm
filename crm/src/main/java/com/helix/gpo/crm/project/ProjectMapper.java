package com.helix.gpo.crm.project;

import com.helix.gpo.crm.shared.payload.website.project.TagDto;
import com.helix.gpo.crm.shared.payload.website.project.WebsiteProjectDto;

import java.util.List;

class ProjectMapper {

    public static WebsiteProjectDto mapToWebsiteProjectDto(Project project, String imageUrl) {
        return WebsiteProjectDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .imageUrl(imageUrl)
                .showOnWebsite(project.getShowOnWebsite())
                .tags(mapProjectTags(project))
                .build();
    }

    private static List<TagDto> mapProjectTags(Project project) {
        return project.getProjectTags().stream().map(ProjectMapper::mapProjectTag).toList();
    }

    private static TagDto mapProjectTag(ProjectTag projectTag) {
        return TagDto.builder()
                .value(projectTag.getValue())
                .color(projectTag.getColor())
                .build();
    }

}
