package com.helix.gpo.crm.shared.payload.website.partner;

import com.helix.gpo.crm.shared.payload.website.company.WebsiteCompanyDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsitePartnerDto {

    private Long id;
    private String name;
    private String job;
    private WebsiteCompanyDto websiteCompanyDto;

}
