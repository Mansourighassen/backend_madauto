package com.madauto.madautobackend.dao;

import com.madauto.madautobackend.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
  Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
