package com.helix.gpo.crm.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByShowOnWebsiteOrderByStartDateDesc(Boolean showOnWebsite);

}
