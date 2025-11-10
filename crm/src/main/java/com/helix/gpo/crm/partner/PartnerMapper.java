package com.helix.gpo.crm.partner;

import com.helix.gpo.crm.shared.payload.website.partner.WebsitePartnerDto;

class PartnerMapper {

    public static WebsitePartnerDto mapToWebsitePartnerDto(Partner partner) {
        return WebsitePartnerDto.builder()
                .id(partner.getId())
                .name(partner.getName())
                .job(partner.getJob())
                .build();
    }

}
