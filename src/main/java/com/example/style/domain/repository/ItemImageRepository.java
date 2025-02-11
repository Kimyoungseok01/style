package com.example.style.domain.repository;


import com.example.style.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemImageRepository extends JpaRepository<Image, Long> {
}