package com.hcmus.chemistry.repository;

import com.hcmus.chemistry.domain.Banner;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Banner entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BannerRepository extends JpaRepository<Banner, Long>, JpaSpecificationExecutor<Banner> {}
