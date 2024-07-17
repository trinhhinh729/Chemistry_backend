package com.hcmus.chemistry.domain.dto;

import com.hcmus.chemistry.domain.BlogPost;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class BlogPostDTO {

    private Long id;

    private String blogPostTitleVi;

    private String blogPostTitleEn;

    private String blogPostSlug;

    private String thumbnailLink;

    private ZonedDateTime createdTime;

    private Integer numberOfViews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogPostTitleVi() {
        return blogPostTitleVi;
    }

    public void setBlogPostTitleVi(String blogPostTitleVi) {
        this.blogPostTitleVi = blogPostTitleVi;
    }

    public String getBlogPostTitleEn() {
        return blogPostTitleEn;
    }

    public void setBlogPostTitleEn(String blogPostTitleEn) {
        this.blogPostTitleEn = blogPostTitleEn;
    }

    public String getBlogPostSlug() {
        return blogPostSlug;
    }

    public void setBlogPostSlug(String blogPostSlug) {
        this.blogPostSlug = blogPostSlug;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(Integer numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public static BlogPostDTO convertBlogPostToBlogPostDTO(BlogPost blogPost) {
        BlogPostDTO blogPostDTO = new BlogPostDTO();
        blogPostDTO.setId(blogPost.getId());
        blogPostDTO.setBlogPostTitleVi(blogPost.getBlogPostTitleVi());
        blogPostDTO.setBlogPostTitleEn(blogPost.getBlogPostTitleEn());
        blogPostDTO.setBlogPostSlug(blogPost.getBlogPostSlug());
        blogPostDTO.setThumbnailLink(blogPost.getThumbnailLink());
        blogPostDTO.setCreatedTime(blogPost.getCreatedTime());
        blogPostDTO.setNumberOfViews(blogPost.getNumberOfViews());
        return blogPostDTO;
    }

    public static List<BlogPostDTO> convertBlogPostListToBlogPostDTOList(List<BlogPost> blogPostList) {
        List<BlogPostDTO> blogPostDTOList = new ArrayList<>();
        for (BlogPost blogPost : blogPostList) {
            BlogPostDTO blogPostDTO = convertBlogPostToBlogPostDTO(blogPost);
            blogPostDTOList.add(blogPostDTO);
        }
        return blogPostDTOList;
    }
}
