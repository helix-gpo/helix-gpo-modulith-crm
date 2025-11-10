@org.springframework.modulith.ApplicationModule(
        displayName = "Testimonial",
        allowedDependencies = {
                "aws :: awsServiceApi",
                "project :: projectServiceApi",
                "shared"
        })
package com.helix.gpo.crm.testimonial;