package com.TestSpring2.dao;

import com.TestSpring2.model.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OAuthDao extends JpaRepository<UserEntity, UUID> {
}
