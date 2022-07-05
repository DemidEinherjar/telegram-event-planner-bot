package com.github.DemidEinherjar.tepb.repository;

import com.github.DemidEinherjar.tepb.repository.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@link TelegramUserRepository} for handling with {@link TelegramUser} entity.
  */
@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, String> {
    List<TelegramUser> findAllByActiveTrue();
}
