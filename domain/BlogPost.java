package com.hcmus.chemistry.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hcmus.chemistry.domain.enumeration.CurrentStatus;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A BlogPost.
 */
@Entity
@Table(name = "blog_post")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BlogPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "blog_post_title_vi", nullable = false)
    private String blogPostTitleVi;

    @Column(name = "blog_post_description_vi", columnDefinition = "TEXT")
    private String blogPostDescriptionVi;

    @Column(name = "blog_post_content_vi", columnDefinition = "TEXT")
    private String blogPostContentVi;

    @Column(name = "blog_post_title_en")
    private String blogPostTitleEn;

    @Column(name = "blog_post_description_en", columnDefinition = "TEXT")
    private String blogPostDescriptionEn;

    @Column(name = "blog_post_content_en", columnDefinition = "TEXT")
    private String blogPostContentEn;

    @Enumerated(EnumType.STRING)
    @Column(name = "blog_post_status")
    private CurrentStatus blogPostStatus;

    @Column(name = "blog_post_author")
    private String blogPostAuthor;

    @Column(name = "blog_post_slug")
    private String blogPostSlug;

    @Column(name = "time_to_publish")
    private ZonedDateTime timeToPublish;

    @Column(name = "thumbnail_link")
    private String thumbnailLink;

    @Column(name = "created_time")
    private ZonedDateTime createdTime;

    @Column(name = "modified_time")
    private ZonedDateTime modifiedTime;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_by")
    private String createdBy;

    @Min(value = 1)
    @Column(name = "number_of_views")
    private Integer numberOfViews;

    @ManyToOne
    @JsonIgnoreProperties(value = { "blogPosts", "subCategories", "parentCategory" }, allowSetters = true)
    private Category category;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public BlogPost id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogPostTitleVi() {
        return this.blogPostTitleVi;
    }

    public BlogPost blogPostTitleVi(String blogPostTitleVi) {
        this.setBlogPostTitleVi(blogPostTitleVi);
        return this;
    }

    public void setBlogPostTitleVi(String blogPostTitleVi) {
        this.blogPostTitleVi = blogPostTitleVi;
    }

    public String getBlogPostDescriptionVi() {
        return this.blogPostDescriptionVi;
    }

    public BlogPost blogPostDescriptionVi(String blogPostDescriptionVi) {
        this.setBlogPostDescriptionVi(blogPostDescriptionVi);
        return this;
    }

    public void setBlogPostDescriptionVi(String blogPostDescriptionVi) {
        this.blogPostDescriptionVi = blogPostDescriptionVi;
    }

    public String getBlogPostContentVi() {
        return this.blogPostContentVi;
    }

    public BlogPost blogPostContentVi(String blogPostContentVi) {
        this.setBlogPostContentVi(blogPostContentVi);
        return this;
    }

    public void setBlogPostContentVi(String blogPostContentVi) {
        this.blogPostContentVi = blogPostContentVi;
    }

    public String getBlogPostTitleEn() {
        return this.blogPostTitleEn;
    }

    public BlogPost blogPostTitleEn(String blogPostTitleEn) {
        this.setBlogPostTitleEn(blogPostTitleEn);
        return this;
    }

    public void setBlogPostTitleEn(String blogPostTitleEn) {
        this.blogPostTitleEn = blogPostTitleEn;
    }

    public String getBlogPostDescriptionEn() {
        return this.blogPostDescriptionEn;
    }

    public BlogPost blogPostDescriptionEn(String blogPostDescriptionEn) {
        this.setBlogPostDescriptionEn(blogPostDescriptionEn);
        return this;
    }

    public void setBlogPostDescriptionEn(String blogPostDescriptionEn) {
        this.blogPostDescriptionEn = blogPostDescriptionEn;
    }

    public String getBlogPostContentEn() {
        return this.blogPostContentEn;
    }

    public BlogPost blogPostContentEn(String blogPostContentEn) {
        this.setBlogPostContentEn(blogPostContentEn);
        return this;
    }

    public void setBlogPostContentEn(String blogPostContentEn) {
        this.blogPostContentEn = blogPostContentEn;
    }

    public CurrentStatus getBlogPostStatus() {
        return this.blogPostStatus;
    }

    public BlogPost blogPostStatus(CurrentStatus blogPostStatus) {
        this.setBlogPostStatus(blogPostStatus);
        return this;
    }

    public void setBlogPostStatus(CurrentStatus blogPostStatus) {
        this.blogPostStatus = blogPostStatus;
    }

    public String getBlogPostAuthor() {
        return this.blogPostAuthor;
    }

    public BlogPost blogPostAuthor(String blogPostAuthor) {
        this.setBlogPostAuthor(blogPostAuthor);
        return this;
    }

    public void setBlogPostAuthor(String blogPostAuthor) {
        this.blogPostAuthor = blogPostAuthor;
    }

    public String getBlogPostSlug() {
        return this.blogPostSlug;
    }

    public BlogPost blogPostSlug(String blogPostSlug) {
        this.setBlogPostSlug(blogPostSlug);
        return this;
    }

    public void setBlogPostSlug(String blogPostSlug) {
        this.blogPostSlug = blogPostSlug;
    }

    public ZonedDateTime getTimeToPublish() {
        return this.timeToPublish;
    }

    public BlogPost timeToPublish(ZonedDateTime timeToPublish) {
        this.setTimeToPublish(timeToPublish);
        return this;
    }

    public void setTimeToPublish(ZonedDateTime timeToPublish) {
        this.timeToPublish = timeToPublish;
    }

    public String getThumbnailLink() {
        return this.thumbnailLink;
    }

    public BlogPost thumbnailLink(String thumbnailLink) {
        this.setThumbnailLink(thumbnailLink);
        return this;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public ZonedDateTime getCreatedTime() {
        return this.createdTime;
    }

    public BlogPost createdTime(ZonedDateTime createdTime) {
        this.setCreatedTime(createdTime);
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime getModifiedTime() {
        return this.modifiedTime;
    }

    public BlogPost modifiedTime(ZonedDateTime modifiedTime) {
        this.setModifiedTime(modifiedTime);
        return this;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public BlogPost modifiedBy(String modifiedBy) {
        this.setModifiedBy(modifiedBy);
        return this;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public BlogPost createdBy(String createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getNumberOfViews() {
        return this.numberOfViews;
    }

    public BlogPost numberOfViews(Integer numberOfViews) {
        this.setNumberOfViews(numberOfViews);
        return this;
    }

    public void setNumberOfViews(Integer numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BlogPost category(Category category) {
        this.setCategory(category);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlogPost)) {
            return false;
        }
        return id != null && id.equals(((BlogPost) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BlogPost{" +
            "id=" + getId() +
            ", blogPostTitleVi='" + getBlogPostTitleVi() + "'" +
            ", blogPostDescriptionVi='" + getBlogPostDescriptionVi() + "'" +
            ", blogPostContentVi='" + getBlogPostContentVi() + "'" +
            ", blogPostTitleEn='" + getBlogPostTitleEn() + "'" +
            ", blogPostDescriptionEn='" + getBlogPostDescriptionEn() + "'" +
            ", blogPostContentEn='" + getBlogPostContentEn() + "'" +
            ", blogPostStatus='" + getBlogPostStatus() + "'" +
            ", blogPostAuthor='" + getBlogPostAuthor() + "'" +
            ", blogPostSlug='" + getBlogPostSlug() + "'" +
            ", timeToPublish='" + getTimeToPublish() + "'" +
            ", thumbnailLink='" + getThumbnailLink() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", modifiedBy='" + getModifiedBy() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", numberOfViews=" + getNumberOfViews() +
            "}";
    }
}
