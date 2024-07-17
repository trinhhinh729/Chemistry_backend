package com.hcmus.chemistry.service;

// for static metamodels
import com.hcmus.chemistry.domain.BlogPost;
import com.hcmus.chemistry.domain.BlogPost_;
import com.hcmus.chemistry.domain.Category;
import com.hcmus.chemistry.domain.Category_;
import com.hcmus.chemistry.repository.CategoryRepository;
import com.hcmus.chemistry.service.criteria.BlogPostCriteria;
import com.hcmus.chemistry.service.criteria.CategoryCriteria;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;
import tech.jhipster.service.filter.LongFilter;

/**
 * Service for executing complex queries for {@link Category} entities in the database.
 * The main input is a {@link CategoryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Category} or a {@link Page} of {@link Category} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CategoryQueryService extends QueryService<Category> {

    private final Logger log = LoggerFactory.getLogger(CategoryQueryService.class);

    private final CategoryRepository categoryRepository;

    private final BlogPostQueryService blogPosQueryService;

    public CategoryQueryService(CategoryRepository categoryRepository, BlogPostQueryService blogPosQueryService) {
        this.categoryRepository = categoryRepository;
        this.blogPosQueryService = blogPosQueryService;
    }

    /**
     * Return a {@link List} of {@link Category} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Category> findByCriteria(CategoryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Category> specification = createSpecification(criteria);
        return categoryRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Category} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Category> findByCriteria(CategoryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Category> specification = createSpecification(criteria);
        return categoryRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CategoryCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Category> specification = createSpecification(criteria);
        return categoryRepository.count(specification);
    }

    /**
     * Function to convert {@link CategoryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Category> createSpecification(CategoryCriteria criteria) {
        Specification<Category> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Category_.id));
            }
            if (criteria.getCategoryName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategoryName(), Category_.categoryName));
            }
            if (criteria.getCategorySlug() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategorySlug(), Category_.categorySlug));
            }
            if (criteria.getCategoryStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getCategoryStatus(), Category_.categoryStatus));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Category_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), Category_.createdTime));
            }
            if (criteria.getBlogPostId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getBlogPostId(),
                            root -> root.join(Category_.blogPosts, JoinType.LEFT).get(BlogPost_.id)
                        )
                    );
            }
            if (criteria.getSubCategoryId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getSubCategoryId(),
                            root -> root.join(Category_.subCategories, JoinType.LEFT).get(Category_.id)
                        )
                    );
            }
            if (criteria.getParentCategoryId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getParentCategoryId(),
                            root -> root.join(Category_.parentCategory, JoinType.LEFT).get(Category_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
