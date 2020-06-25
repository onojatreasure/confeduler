package com.pluralsight.confeduler.repositories;

import com.pluralsight.confeduler.models.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
}
