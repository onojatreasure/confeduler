package com.pluralsight.confeduler.repositories;

import com.pluralsight.confeduler.models.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
