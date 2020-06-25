package com.pluralsight.confeduler.repositories;

import com.pluralsight.confeduler.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SpeakerRepository extends JpaRepository<Speaker, Long>  {
}
