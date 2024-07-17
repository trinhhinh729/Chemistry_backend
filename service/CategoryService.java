package com.hcmus.chemistry.service;

import com.hcmus.chemistry.domain.BlogPost;
import com.hcmus.chemistry.domain.Category;
import com.hcmus.chemistry.repository.CategoryRepository;
import com.hcmus.chemistry.security.SecurityUtils;
import com.hcmus.chemistry.service.criteria.BlogPostCriteria;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Service Implementation for managing {@link Category}.
 */
@Service
@Transactional
public class CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    private final BlogPostQueryService blogPosQueryService;

    public CategoryService(CategoryRepository categoryRepository, BlogPostQueryService blogPosQueryService) {
        this.categoryRepository = categoryRepository;
        this.blogPosQueryService = blogPosQueryService;
    }

    /**
     * Save a category.
     *
     * @param category the entity to save.
     * @return the persisted entity.
     */
    public Category save(Category category) {
        log.debug("Request to save Category : {}", category);
        if (category.getCreatedBy() == null) {
            category.setCreatedBy(SecurityUtils.getCurrentUserLogin().orElse(null));
        }
        return categoryRepository.save(category);
    }

    /**
     * Update a category.
     *
     * @param category the entity to save.
     * @return the persisted entity.
     */
    public Category update(Category category) {
        log.debug("Request to update Category : {}", category);
        return categoryRepository.save(category);
    }

    /**
     * Partially update a category.
     *
     * @param category the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Category> partialUpdate(Category category) {
        log.debug("Request to partially update Category : {}", category);

        return categoryRepository
            .findById(category.getId())
            .map(existingCategory -> {
                if (category.getCategoryName() != null) {
                    existingCategory.setCategoryName(category.getCategoryName());
                }
                if (category.getCategorySlug() != null) {
                    existingCategory.setCategorySlug(category.getCategorySlug());
                }
                if (category.getCategoryStatus() != null) {
                    existingCategory.setCategoryStatus(category.getCategoryStatus());
                }
                if (category.getCreatedBy() != null) {
                    existingCategory.setCreatedBy(category.getCreatedBy());
                }
                if (category.getCreatedTime() != null) {
                    existingCategory.setCreatedTime(category.getCreatedTime());
                }

                return existingCategory;
            })
            .map(categoryRepository::save);
    }

    /**
     * Get all the categories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Category> findAll(Pageable pageable) {
        log.debug("Request to get all Categories");
        return categoryRepository.findAll(pageable);
    }

    /**
     * Get one category by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Category> findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findById(id);
    }

    /**
     * Delete the category by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Category> getHomePageCategories() {
        log.debug("Request to get Categories for homepage");
        return categoryRepository.getHomePageCategories();
    }

    @Transactional(readOnly = true)
    public List<Category> getCategoriesWithConditions() {
        log.debug("Request to get all Categories with conditions");
        return categoryRepository.getCategoriesWithConditions();
    }
}
