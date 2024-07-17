package com.hcmus.chemistry.service;

import com.hcmus.chemistry.domain.*; // for static metamodels
import com.hcmus.chemistry.domain.Banner;
import com.hcmus.chemistry.repository.BannerRepository;
import com.hcmus.chemistry.service.criteria.BannerCriteria;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Banner} entities in the database.
 * The main input is a {@link BannerCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Banner} or a {@link Page} of {@link Banner} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BannerQueryService extends QueryService<Banner> {

    private final Logger log = LoggerFactory.getLogger(BannerQueryService.class);

    private final BannerRepository bannerRepository;

    public BannerQueryService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    /**
     * Return a {@link List} of {@link Banner} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Banner> findByCriteria(BannerCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Banner> specification = createSpecification(criteria);
        return bannerRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Banner} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Banner> findByCriteria(BannerCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Banner> specification = createSpecification(criteria);
        return bannerRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BannerCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Banner> specification = createSpecification(criteria);
        return bannerRepository.count(specification);
    }

    /**
     * Function to convert {@link BannerCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Banner> createSpecification(BannerCriteria criteria) {
        Specification<Banner> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Banner_.id));
            }
            if (criteria.getBannerLink() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBannerLink(), Banner_.bannerLink));
            }
            if (criteria.getBannerStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getBannerStatus(), Banner_.bannerStatus));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Banner_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), Banner_.createdTime));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), Banner_.modifiedTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getModifiedBy(), Banner_.modifiedBy));
            }
        }
        return specification;
    }
}
