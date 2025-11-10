@org.springframework.modulith.ApplicationModule(
        displayName = "Project",
        allowedDependencies = {
                "partner :: partnerServiceApi",
                "aws :: awsServiceApi",
                "testimonial",
                "shared"
        })
package com.helix.gpo.crm.project;