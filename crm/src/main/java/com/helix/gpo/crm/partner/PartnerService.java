package com.helix.gpo.crm.partner;

import com.helix.gpo.crm.shared.payload.website.partner.WebsitePartnerDto;

interface PartnerService {

    WebsitePartnerDto getPartnerById(Long partnerId);

}
