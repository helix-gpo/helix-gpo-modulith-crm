package com.helix.gpo.crm.company;

import com.helix.gpo.crm.shared.exception.types.ResourceNotFoundException;
import com.helix.gpo.crm.shared.payload.website.company.WebsiteCompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CompanyServiceImpl implements CompanyServiceApi, CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public WebsiteCompanyDto getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(
                () -> new ResourceNotFoundException("Company", "ID", companyId.toString())
        );
        return CompanyMapper.mapToWebsiteCompanyDto(company);
    }

}
