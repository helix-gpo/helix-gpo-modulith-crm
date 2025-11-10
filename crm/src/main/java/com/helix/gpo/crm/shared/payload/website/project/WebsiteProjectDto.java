package com.helix.gpo.crm.shared.payload.website.project;

import com.helix.gpo.crm.shared.payload.website.partner.WebsitePartnerDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteProjectDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String imageUrl;
    private Boolean showOnWebsite;
    private WebsitePartnerDto websitePartnerDto;
    private List<TagDto> tags;

}
