package com.hcmus.chemistry.repository;

import com.hcmus.chemistry.domain.BlogPost;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the BlogPost entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long>, JpaSpecificationExecutor<BlogPost> {
    @Query(
        value = "SELECT * " +
        "FROM blog_post " +
        "WHERE (lower(unaccent(regexp_replace(" +
        "CASE WHEN ?2 = 'en' THEN blog_post_content_en ELSE blog_post_content_vi END, '<[^>]*>', '', 'g'))) " +
        "LIKE %?1%) or (lower(CASE WHEN ?2 = 'en' THEN blog_post_title_en ELSE blog_post_title_vi END) LIKE %?1%)",
        nativeQuery = true
    )
    List<BlogPost> searchBlogPostByBlogPostContentI18n(String queryString, String language);

    @Query(
        value = "SELECT bp.id, bp.blog_post_title_vi AS blogPostTitleVi, bp.blog_post_title_en AS blogPostTitleEn, " +
        "bp.blog_post_slug AS blogPostSlug, bp.thumbnail_link AS thumbnailLink, bp.created_time AS createdTime " +
        "FROM blog_post bp " +
        "WHERE bp.blog_post_status = 'ENABLED' AND bp.time_to_publish <= now() " +
        "ORDER BY bp.modified_time DESC LIMIT 6",
        nativeQuery = true
    )
    List<Object[]> findBlogPostsCarousel();
}
