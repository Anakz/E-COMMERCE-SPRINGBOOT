package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
