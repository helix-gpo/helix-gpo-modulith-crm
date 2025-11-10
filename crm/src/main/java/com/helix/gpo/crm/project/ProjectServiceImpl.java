package com.helix.gpo.crm.project;

import com.helix.gpo.crm.aws.AwsServiceApi;
import com.helix.gpo.crm.partner.PartnerServiceApi;
import com.helix.gpo.crm.shared.exception.types.ResourceNotFoundException;
import com.helix.gpo.crm.shared.payload.website.project.WebsiteProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProjectServiceImpl implements ProjectServiceApi, ProjectService {

    private final ProjectRepository projectRepository;
    private final PartnerServiceApi partnerServiceApi;
    private final AwsServiceApi awsServiceApi;

    @Value("${aws.bucket.projects}")
    private String awsBucket;

    @Override
    public List<WebsiteProjectDto> getAllWebsiteProjects() {
        List<Project> projects = projectRepository.findAllByShowOnWebsiteOrderByStartDateDesc(true);
        return projects.stream()
                .map(this::prepareWebsiteProjectDto)
                .toList();
    }

    @Override
    public WebsiteProjectDto getProjectByid(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new ResourceNotFoundException("Project", "ID", projectId.toString())
        );
        return prepareWebsiteProjectDto(project);
    }

    private WebsiteProjectDto prepareWebsiteProjectDto(Project project) {
        String imageUrl = getImageUrl(project);
        WebsiteProjectDto websiteProjectDto = ProjectMapper.mapToWebsiteProjectDto(project, imageUrl);
        websiteProjectDto.setWebsitePartnerDto(partnerServiceApi.getPartnerById(project.getPartnerId()));
        return websiteProjectDto;
    }

    private String getImageUrl(Project project) {
        return project.getImageUrl().isEmpty()
                ? project.getImageUrl()
                : awsServiceApi.generatePresignedUrl(awsBucket, project.getImageUrl(), project.getContentType());
    }

}
