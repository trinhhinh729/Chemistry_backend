package com.hcmus.chemistry.service;

import com.hcmus.chemistry.domain.*; // for static metamodels
import com.hcmus.chemistry.domain.BlogPost;
import com.hcmus.chemistry.repository.BlogPostRepository;
import com.hcmus.chemistry.service.criteria.BlogPostCriteria;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link BlogPost} entities in the database.
 * The main input is a {@link BlogPostCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BlogPost} or a {@link Page} of {@link BlogPost} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BlogPostQueryService extends QueryService<BlogPost> {

    private final Logger log = LoggerFactory.getLogger(BlogPostQueryService.class);

    private final BlogPostRepository blogPostRepository;

    public BlogPostQueryService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    /**
     * Return a {@link List} of {@link BlogPost} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BlogPost> findByCriteria(BlogPostCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<BlogPost> specification = createSpecification(criteria);
        return blogPostRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link BlogPost} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BlogPost> findByCriteria(BlogPostCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BlogPost> specification = createSpecification(criteria);
        Page<BlogPost> blogPosts = blogPostRepository.findAll(specification, page);

        // to avoid calling the content of blog post, it takes a lot of time
        blogPosts.forEach(blogPost -> {
            blogPost.setBlogPostContentEn(null);
            blogPost.setBlogPostContentVi(null);
        });

        return blogPosts;
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BlogPostCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<BlogPost> specification = createSpecification(criteria);
        return blogPostRepository.count(specification);
    }

    /**
     * Function to convert {@link BlogPostCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<BlogPost> createSpecification(BlogPostCriteria criteria) {
        Specification<BlogPost> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), BlogPost_.id));
            }
            if (criteria.getBlogPostTitleVi() != null) {
                specification =
                    specification.and((root, query, builder) -> {
                        String queryString = wrapLikeQuery(StringUtils.stripAccents(criteria.getBlogPostTitleVi().getContains()));
                        Expression<String> unaccentedTitle = builder.function(
                            "UNACCENT",
                            String.class,
                            builder.upper(root.get(BlogPost_.BLOG_POST_TITLE_VI))
                        );
                        return builder.like(unaccentedTitle, queryString);
                    });
            }
            if (criteria.getBlogPostDescriptionVi() != null) {
                specification =
                    specification.and(buildStringSpecification(criteria.getBlogPostDescriptionVi(), BlogPost_.blogPostDescriptionVi));
            }
            if (criteria.getBlogPostContentVi() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBlogPostContentVi(), BlogPost_.blogPostContentVi));
            }
            if (criteria.getBlogPostTitleEn() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBlogPostTitleEn(), BlogPost_.blogPostTitleEn));
            }
            if (criteria.getBlogPostDescriptionEn() != null) {
                specification =
                    specification.and(buildStringSpecification(criteria.getBlogPostDescriptionEn(), BlogPost_.blogPostDescriptionEn));
            }
            if (criteria.getBlogPostContentEn() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBlogPostContentEn(), BlogPost_.blogPostContentEn));
            }
            if (criteria.getBlogPostStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getBlogPostStatus(), BlogPost_.blogPostStatus));
            }
            if (criteria.getBlogPostAuthor() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBlogPostAuthor(), BlogPost_.blogPostAuthor));
            }
            if (criteria.getBlogPostSlug() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBlogPostSlug(), BlogPost_.blogPostSlug));
            }
            if (criteria.getTimeToPublish() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTimeToPublish(), BlogPost_.timeToPublish));
            }
            if (criteria.getThumbnailLink() != null) {
                specification = specification.and(buildStringSpecification(criteria.getThumbnailLink(), BlogPost_.thumbnailLink));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), BlogPost_.createdTime));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), BlogPost_.modifiedTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getModifiedBy(), BlogPost_.modifiedBy));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), BlogPost_.createdBy));
            }
            if (criteria.getNumberOfViews() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNumberOfViews(), BlogPost_.numberOfViews));
            }
            if (criteria.getCategoryId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCategoryId(), root -> root.join(BlogPost_.category, JoinType.LEFT).get(Category_.id))
                    );
            }
        }
        return specification;
    }
}
