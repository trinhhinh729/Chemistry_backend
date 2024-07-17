package com.hcmus.chemistry.service;

import com.hcmus.chemistry.domain.Banner;
import com.hcmus.chemistry.repository.BannerRepository;
import com.hcmus.chemistry.security.SecurityUtils;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Banner}.
 */
@Service
@Transactional
public class BannerService {

    private final Logger log = LoggerFactory.getLogger(BannerService.class);

    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    /**
     * Save a banner.
     *
     * @param banner the entity to save.
     * @return the persisted entity.
     */
    public Banner save(Banner banner) {
        log.debug("Request to save Banner : {}", banner);
        if (banner.getCreatedBy() == null) {
            banner.setCreatedBy(SecurityUtils.getCurrentUserLogin().orElse(null));
        }
        return bannerRepository.save(banner);
    }

    /**
     * Update a banner.
     *
     * @param banner the entity to save.
     * @return the persisted entity.
     */
    public Banner update(Banner banner) {
        log.debug("Request to update Banner : {}", banner);
        if (banner.getModifiedBy() == null) {
            banner.setModifiedBy(SecurityUtils.getCurrentUserLogin().orElse(null));
        }
        return bannerRepository.save(banner);
    }

    /**
     * Partially update a banner.
     *
     * @param banner the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Banner> partialUpdate(Banner banner) {
        log.debug("Request to partially update Banner : {}", banner);

        return bannerRepository
            .findById(banner.getId())
            .map(existingBanner -> {
                if (banner.getBannerLink() != null) {
                    existingBanner.setBannerLink(banner.getBannerLink());
                }
                if (banner.getBannerStatus() != null) {
                    existingBanner.setBannerStatus(banner.getBannerStatus());
                }
                if (banner.getCreatedBy() != null) {
                    existingBanner.setCreatedBy(banner.getCreatedBy());
                }
                if (banner.getCreatedTime() != null) {
                    existingBanner.setCreatedTime(banner.getCreatedTime());
                }
                if (banner.getModifiedTime() != null) {
                    existingBanner.setModifiedTime(banner.getModifiedTime());
                }
                if (banner.getModifiedBy() != null) {
                    existingBanner.setModifiedBy(banner.getModifiedBy());
                }

                return existingBanner;
            })
            .map(bannerRepository::save);
    }

    /**
     * Get all the banners.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Banner> findAll(Pageable pageable) {
        log.debug("Request to get all Banners");
        return bannerRepository.findAll(pageable);
    }

    /**
     * Get one banner by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Banner> findOne(Long id) {
        log.debug("Request to get Banner : {}", id);
        return bannerRepository.findById(id);
    }

    /**
     * Delete the banner by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Banner : {}", id);
        bannerRepository.deleteById(id);
    }
}
