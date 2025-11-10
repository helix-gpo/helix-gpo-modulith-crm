@org.springframework.modulith.ApplicationModule(
        displayName = "Partner",
        allowedDependencies = {
                "company :: companyServiceApi",
                "project",
                "testimonial",
                "shared"
        })
package com.helix.gpo.crm.partner;