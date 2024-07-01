package com.example.springmail.repository;

import com.example.springmail.entity.TelegramIntegration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramIntegrationRepository extends JpaRepository<TelegramIntegration, Long> {
}
