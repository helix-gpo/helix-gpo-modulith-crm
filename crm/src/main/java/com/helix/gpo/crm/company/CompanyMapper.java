package com.helix.gpo.crm.company;

import com.helix.gpo.crm.shared.payload.website.company.WebsiteCompanyDto;

class CompanyMapper {

    public static WebsiteCompanyDto mapToWebsiteCompanyDto(Company company) {
        return WebsiteCompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

}
