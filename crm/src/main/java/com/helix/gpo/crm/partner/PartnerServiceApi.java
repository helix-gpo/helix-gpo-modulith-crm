package com.helix.gpo.crm.partner;

import com.helix.gpo.crm.shared.payload.website.partner.WebsitePartnerDto;
import org.springframework.modulith.NamedInterface;

@NamedInterface(name = "partnerServiceApi")
public interface PartnerServiceApi {

    WebsitePartnerDto getPartnerById(Long partnerId);

}
