package com.helix.gpo.crm.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum ProjectTag {

    PROCESS ("Prozessoptimierung", "#03dbff"),
    SOFTWARE ("Software", "#0d1424"),
    MONITORING ("Monitoring", "#7f6fea"),
    STRATEGY ("Strategie", "#fc03d5"),
    ;

    private final String value;
    private final String color;

}
