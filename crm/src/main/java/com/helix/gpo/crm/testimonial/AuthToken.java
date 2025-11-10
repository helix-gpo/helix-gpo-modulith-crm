package com.helix.gpo.crm.testimonial;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "auth_tokens")
class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    @Column(nullable = false)
    private Boolean valid;

    @Column(nullable = false)
    private Boolean used;

    @Column(nullable = false)
    private Long projectId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "testimonial_id", referencedColumnName = "id")
    private Testimonial testimonial;

}
