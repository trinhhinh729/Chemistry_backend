package com.hcmus.chemistry.web.rest;

import com.hcmus.chemistry.config.ChemistryConstant;
import com.hcmus.chemistry.domain.BlogPost;
import com.hcmus.chemistry.domain.dto.BlogPostDTO;
import com.hcmus.chemistry.domain.enumeration.CurrentStatus;
import com.hcmus.chemistry.repository.BlogPostRepository;
import com.hcmus.chemistry.service.BlogPostQueryService;
import com.hcmus.chemistry.service.BlogPostService;
import com.hcmus.chemistry.service.criteria.BlogPostCriteria;
import com.hcmus.chemistry.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.service.filter.ZonedDateTimeFilter;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.hcmus.chemistry.domain.BlogPost}.
 */
@RestController
@RequestMapping("/api")
public class BlogPostResource {

    private final Logger log = LoggerFactory.getLogger(BlogPostResource.class);

    private static final String ENTITY_NAME = "blogPost";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BlogPostService blogPostService;

    private final BlogPostRepository blogPostRepository;

    private final BlogPostQueryService blogPostQueryService;

    public BlogPostResource(
        BlogPostService blogPostService,
        BlogPostRepository blogPostRepository,
        BlogPostQueryService blogPostQueryService
    ) {
        this.blogPostService = blogPostService;
        this.blogPostRepository = blogPostRepository;
        this.blogPostQueryService = blogPostQueryService;
    }

    /**
     * {@code POST  /blog-posts} : Create a new blogPost.
     *
     * @param blogPost the blogPost to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new blogPost, or with status {@code 400 (Bad Request)} if the blogPost has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/blog-posts")
    @PreAuthorize(ChemistryConstant.ALLOW_MODIFIED)
    public ResponseEntity<BlogPost> createBlogPost(@Valid @RequestBody BlogPost blogPost) throws URISyntaxException {
        log.debug("REST request to save BlogPost : {}", blogPost);
        if (blogPost.getId() != null) {
            throw new BadRequestAlertException("A new blogPost cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BlogPost result = blogPostService.save(blogPost);
        return ResponseEntity
            .created(new URI("/api/blog-posts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /blog-posts/:id} : Updates an existing blogPost.
     *
     * @param id the id of the blogPost to save.
     * @param blogPost the blogPost to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated blogPost,
     * or with status {@code 400 (Bad Request)} if the blogPost is not valid,
     * or with status {@code 500 (Internal Server Error)} if the blogPost couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/blog-posts/{id}")
    @PreAuthorize(ChemistryConstant.ALLOW_MODIFIED)
    public ResponseEntity<BlogPost> updateBlogPost(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody BlogPost blogPost
    ) throws URISyntaxException {
        log.debug("REST request to update BlogPost : {}, {}", id, blogPost);
        if (blogPost.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, blogPost.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!blogPostRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        BlogPost result = blogPostService.update(blogPost);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, blogPost.getId().toString()))
            .body(result);
    }

    @PutMapping("/blog-posts/{id}/views")
    public ResponseEntity<BlogPost> updateBlogPostViews(@PathVariable(value = "id", required = true) final Long id) {
        log.debug("REST request to update BlogPost views : {}", id);
        BlogPost result = blogPostService.updateViews(id);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code PATCH  /blog-posts/:id} : Partial updates given fields of an existing blogPost, field will ignore if it is null
     *
     * @param id the id of the blogPost to save.
     * @param blogPost the blogPost to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated blogPost,
     * or with status {@code 400 (Bad Request)} if the blogPost is not valid,
     * or with status {@code 404 (Not Found)} if the blogPost is not found,
     * or with status {@code 500 (Internal Server Error)} if the blogPost couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/blog-posts/{id}", consumes = { "application/json", "application/merge-patch+json" })
    @PreAuthorize(ChemistryConstant.ALLOW_MODIFIED)
    public ResponseEntity<BlogPost> partialUpdateBlogPost(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody BlogPost blogPost
    ) throws URISyntaxException {
        log.debug("REST request to partial update BlogPost partially : {}, {}", id, blogPost);
        if (blogPost.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, blogPost.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!blogPostRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<BlogPost> result = blogPostService.partialUpdate(blogPost);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, blogPost.getId().toString())
        );
    }

    /**
     * {@code GET  /blog-posts} : get all the blogPosts.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of blogPosts in body.
     */
    @GetMapping("/blog-posts")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts(
        BlogPostCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get BlogPosts by criteria: {}", criteria);
        Page<BlogPost> page = blogPostQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/blog-posts/blogpost-carousel")
    public ResponseEntity<List<BlogPostDTO>> getAllBlogPostsCarousel() {
        log.debug("REST request to get all BlogPosts with conditions");
        return ResponseEntity.ok().body(blogPostService.findBlogPostsCarousel());
    }

    /**
     * {@code GET  /blog-posts/count} : count all the blogPosts.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/blog-posts/count")
    public ResponseEntity<Long> countBlogPosts(BlogPostCriteria criteria) {
        log.debug("REST request to count BlogPosts by criteria: {}", criteria);
        return ResponseEntity.ok().body(blogPostQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /blog-posts/:id} : get the "id" blogPost.
     *
     * @param id the id of the blogPost to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the blogPost, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/blog-posts/{id}")
    public ResponseEntity<BlogPost> getBlogPost(@PathVariable Long id) {
        log.debug("REST request to get BlogPost : {}", id);
        Optional<BlogPost> blogPost = blogPostService.findOne(id);
        return ResponseUtil.wrapOrNotFound(blogPost);
    }

    /**
     * {@code DELETE  /blog-posts/:id} : delete the "id" blogPost.
     *
     * @param id the id of the blogPost to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/blog-posts/{id}")
    @PreAuthorize(ChemistryConstant.ALLOW_MODIFIED)
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        log.debug("REST request to delete BlogPost : {}", id);
        blogPostService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    @GetMapping("/blog-posts/search")
    public ResponseEntity<List<BlogPost>> searchBlogPostByBlogPostContentI18n(
        @RequestParam String queryString,
        @RequestParam String language
    ) {
        log.debug("Request to search BlogPost by Query String : {}", queryString);
        List<BlogPost> blogPosts = blogPostRepository.searchBlogPostByBlogPostContentI18n(
            StringUtils.stripAccents(queryString.toLowerCase()),
            language
        );
        return ResponseEntity.ok().body(blogPosts);
    }
}
