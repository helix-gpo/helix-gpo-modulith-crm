package com.helix.gpo.crm.company;

import com.helix.gpo.crm.shared.payload.website.company.WebsiteCompanyDto;
import org.springframework.modulith.NamedInterface;

@NamedInterface(name = "companyServiceApi")
public interface CompanyServiceApi {

    WebsiteCompanyDto getCompanyById(Long companyId);

}
