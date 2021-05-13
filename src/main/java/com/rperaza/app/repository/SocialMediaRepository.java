package com.rperaza.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rperaza.app.model.SocialMedia;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {

	List<SocialMedia> findAll();

	Optional<SocialMedia> findById(Long id);

	public void deleteById(Long id);

}
