package com.helix.gpo.crm.company;

import com.helix.gpo.crm.shared.payload.website.company.WebsiteCompanyDto;

interface CompanyService {

    WebsiteCompanyDto getCompanyById(Long companyId);

}
