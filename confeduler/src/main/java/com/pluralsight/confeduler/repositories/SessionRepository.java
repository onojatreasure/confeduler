package com.pluralsight.confeduler.repositories;

import com.pluralsight.confeduler.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SessionRepository extends JpaRepository<Session, Long> {
}
