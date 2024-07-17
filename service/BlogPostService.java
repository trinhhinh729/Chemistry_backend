package com.hcmus.chemistry.service;

import com.hcmus.chemistry.domain.BlogPost;
import com.hcmus.chemistry.domain.dto.BlogPostDTO;
import com.hcmus.chemistry.repository.BlogPostRepository;
import com.hcmus.chemistry.security.SecurityUtils;
import com.hcmus.chemistry.web.rest.errors.BadRequestAlertException;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link BlogPost}.
 */
@Service
@Transactional
public class BlogPostService {

    private final Logger log = LoggerFactory.getLogger(BlogPostService.class);

    private final BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    /**
     * Save a blogPost.
     *
     * @param blogPost the entity to save.
     * @return the persisted entity.
     */
    public BlogPost save(BlogPost blogPost) {
        log.debug("Request to save BlogPost : {}", blogPost);
        if (blogPost.getBlogPostAuthor() == null) {
            blogPost.setBlogPostAuthor(SecurityUtils.getCurrentUserLogin().orElse(null));
        }
        if (blogPost.getCreatedBy() == null) {
            blogPost.setCreatedBy(SecurityUtils.getCurrentUserLogin().orElse(null));
        }
        return blogPostRepository.save(blogPost);
    }

    /**
     * Update a blogPost.
     *
     * @param blogPost the entity to save.
     * @return the persisted entity.
     */
    public BlogPost update(BlogPost blogPost) {
        log.debug("Request to update BlogPost : {}", blogPost);
        return blogPostRepository.save(blogPost);
    }

    /**
     * Partially update a blogPost.
     *
     * @param blogPost the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<BlogPost> partialUpdate(BlogPost blogPost) {
        log.debug("Request to partially update BlogPost : {}", blogPost);

        return blogPostRepository
            .findById(blogPost.getId())
            .map(existingBlogPost -> {
                if (blogPost.getBlogPostTitleVi() != null) {
                    existingBlogPost.setBlogPostTitleVi(blogPost.getBlogPostTitleVi());
                }
                if (blogPost.getBlogPostDescriptionVi() != null) {
                    existingBlogPost.setBlogPostDescriptionVi(blogPost.getBlogPostDescriptionVi());
                }
                if (blogPost.getBlogPostContentVi() != null) {
                    existingBlogPost.setBlogPostContentVi(blogPost.getBlogPostContentVi());
                }
                if (blogPost.getBlogPostTitleEn() != null) {
                    existingBlogPost.setBlogPostTitleEn(blogPost.getBlogPostTitleEn());
                }
                if (blogPost.getBlogPostDescriptionEn() != null) {
                    existingBlogPost.setBlogPostDescriptionEn(blogPost.getBlogPostDescriptionEn());
                }
                if (blogPost.getBlogPostContentEn() != null) {
                    existingBlogPost.setBlogPostContentEn(blogPost.getBlogPostContentEn());
                }
                if (blogPost.getBlogPostStatus() != null) {
                    existingBlogPost.setBlogPostStatus(blogPost.getBlogPostStatus());
                }
                if (blogPost.getBlogPostAuthor() != null) {
                    existingBlogPost.setBlogPostAuthor(blogPost.getBlogPostAuthor());
                }
                if (blogPost.getBlogPostSlug() != null) {
                    existingBlogPost.setBlogPostSlug(blogPost.getBlogPostSlug());
                }
                if (blogPost.getTimeToPublish() != null) {
                    existingBlogPost.setTimeToPublish(blogPost.getTimeToPublish());
                }
                if (blogPost.getThumbnailLink() != null) {
                    existingBlogPost.setThumbnailLink(blogPost.getThumbnailLink());
                }
                if (blogPost.getCreatedTime() != null) {
                    existingBlogPost.setCreatedTime(blogPost.getCreatedTime());
                }
                if (blogPost.getModifiedTime() != null) {
                    existingBlogPost.setModifiedTime(blogPost.getModifiedTime());
                }
                if (blogPost.getModifiedBy() != null) {
                    existingBlogPost.setModifiedBy(blogPost.getModifiedBy());
                }
                if (blogPost.getCreatedBy() != null) {
                    existingBlogPost.setCreatedBy(blogPost.getCreatedBy());
                }
                if (blogPost.getNumberOfViews() != null) {
                    existingBlogPost.setNumberOfViews(blogPost.getNumberOfViews());
                }

                return existingBlogPost;
            })
            .map(blogPostRepository::save);
    }

    /**
     * Get all the blogPosts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<BlogPost> findAll(Pageable pageable) {
        log.debug("Request to get all BlogPosts");
        return blogPostRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<BlogPostDTO> findBlogPostsCarousel() {
        log.debug("Request to get all BlogPosts with conditions");
        List<Object[]> blogPosts = blogPostRepository.findBlogPostsCarousel();
        List<BlogPostDTO> result = new ArrayList<>();

        for (Object[] blogPost : blogPosts) {
            BlogPostDTO blogPostDTO = new BlogPostDTO();
            blogPostDTO.setId(((BigInteger) blogPost[0]).longValue());
            blogPostDTO.setBlogPostTitleVi((String) blogPost[1]);
            blogPostDTO.setBlogPostTitleEn((String) blogPost[2]);
            blogPostDTO.setBlogPostSlug((String) blogPost[3]);
            blogPostDTO.setThumbnailLink((String) blogPost[4]);
            blogPostDTO.setCreatedTime(
                ZonedDateTime.ofInstant(((java.sql.Timestamp) blogPost[5]).toInstant(), java.time.ZoneId.systemDefault())
            );
            result.add(blogPostDTO);
        }
        return result;
    }

    /**
     * Get one blogPost by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BlogPost> findOne(Long id) {
        log.debug("Request to get BlogPost : {}", id);
        return blogPostRepository.findById(id);
    }

    /**
     * Delete the blogPost by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BlogPost : {}", id);
        blogPostRepository.deleteById(id);
    }

    public BlogPost updateViews(Long id) {
        log.debug("Request to update BlogPost views : {}", id);
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        if (blogPost.isPresent()) {
            blogPost.get().setNumberOfViews(blogPost.get().getNumberOfViews() != null ? blogPost.get().getNumberOfViews() + 1 : 1);
            BlogPost updatedBlogPost = blogPostRepository.save(blogPost.get());
            return updatedBlogPost;
        } else {
            throw new BadRequestAlertException("Invalid id", "blogPost", "idnull");
        }
    }
}
