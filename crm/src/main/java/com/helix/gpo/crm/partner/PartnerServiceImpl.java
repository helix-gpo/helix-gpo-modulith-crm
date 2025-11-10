package com.helix.gpo.crm.partner;

import com.helix.gpo.crm.company.CompanyServiceApi;
import com.helix.gpo.crm.shared.exception.types.ResourceNotFoundException;
import com.helix.gpo.crm.shared.payload.website.company.WebsiteCompanyDto;
import com.helix.gpo.crm.shared.payload.website.partner.WebsitePartnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PartnerServiceImpl implements PartnerServiceApi, PartnerService {

    private final PartnerRepository partnerRepository;
    private final CompanyServiceApi companyServiceApi;

    @Override
    public WebsitePartnerDto getPartnerById(Long partnerId) {
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(
                () -> new ResourceNotFoundException("Partner", "ID", partnerId.toString())
        );

        WebsitePartnerDto websitePartnerDto = PartnerMapper.mapToWebsitePartnerDto(partner);
        websitePartnerDto.setWebsiteCompanyDto(companyServiceApi.getCompanyById(partner.getCompanyId()));

        return websitePartnerDto;
    }

}
