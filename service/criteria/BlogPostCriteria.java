package com.hcmus.chemistry.service.criteria;

import com.hcmus.chemistry.domain.enumeration.CurrentStatus;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.hcmus.chemistry.domain.BlogPost} entity. This class is used
 * in {@link com.hcmus.chemistry.web.rest.BlogPostResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /blog-posts?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BlogPostCriteria implements Serializable, Criteria {

    /**
     * Class for filtering CurrentStatus
     */
    public static class CurrentStatusFilter extends Filter<CurrentStatus> {

        public CurrentStatusFilter() {}

        public CurrentStatusFilter(CurrentStatusFilter filter) {
            super(filter);
        }

        @Override
        public CurrentStatusFilter copy() {
            return new CurrentStatusFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter blogPostTitleVi;

    private StringFilter blogPostDescriptionVi;

    private StringFilter blogPostContentVi;

    private StringFilter blogPostTitleEn;

    private StringFilter blogPostDescriptionEn;

    private StringFilter blogPostContentEn;

    private CurrentStatusFilter blogPostStatus;

    private StringFilter blogPostAuthor;

    private StringFilter blogPostSlug;

    private ZonedDateTimeFilter timeToPublish;

    private StringFilter thumbnailLink;

    private ZonedDateTimeFilter createdTime;

    private ZonedDateTimeFilter modifiedTime;

    private StringFilter modifiedBy;

    private StringFilter createdBy;

    private IntegerFilter numberOfViews;

    private LongFilter categoryId;

    private Boolean distinct;

    public BlogPostCriteria() {}

    public BlogPostCriteria(BlogPostCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.blogPostTitleVi = other.blogPostTitleVi == null ? null : other.blogPostTitleVi.copy();
        this.blogPostDescriptionVi = other.blogPostDescriptionVi == null ? null : other.blogPostDescriptionVi.copy();
        this.blogPostContentVi = other.blogPostContentVi == null ? null : other.blogPostContentVi.copy();
        this.blogPostTitleEn = other.blogPostTitleEn == null ? null : other.blogPostTitleEn.copy();
        this.blogPostDescriptionEn = other.blogPostDescriptionEn == null ? null : other.blogPostDescriptionEn.copy();
        this.blogPostContentEn = other.blogPostContentEn == null ? null : other.blogPostContentEn.copy();
        this.blogPostStatus = other.blogPostStatus == null ? null : other.blogPostStatus.copy();
        this.blogPostAuthor = other.blogPostAuthor == null ? null : other.blogPostAuthor.copy();
        this.blogPostSlug = other.blogPostSlug == null ? null : other.blogPostSlug.copy();
        this.timeToPublish = other.timeToPublish == null ? null : other.timeToPublish.copy();
        this.thumbnailLink = other.thumbnailLink == null ? null : other.thumbnailLink.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.numberOfViews = other.numberOfViews == null ? null : other.numberOfViews.copy();
        this.categoryId = other.categoryId == null ? null : other.categoryId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public BlogPostCriteria copy() {
        return new BlogPostCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getBlogPostTitleVi() {
        return blogPostTitleVi;
    }

    public StringFilter blogPostTitleVi() {
        if (blogPostTitleVi == null) {
            blogPostTitleVi = new StringFilter();
        }
        return blogPostTitleVi;
    }

    public void setBlogPostTitleVi(StringFilter blogPostTitleVi) {
        this.blogPostTitleVi = blogPostTitleVi;
    }

    public StringFilter getBlogPostDescriptionVi() {
        return blogPostDescriptionVi;
    }

    public StringFilter blogPostDescriptionVi() {
        if (blogPostDescriptionVi == null) {
            blogPostDescriptionVi = new StringFilter();
        }
        return blogPostDescriptionVi;
    }

    public void setBlogPostDescriptionVi(StringFilter blogPostDescriptionVi) {
        this.blogPostDescriptionVi = blogPostDescriptionVi;
    }

    public StringFilter getBlogPostContentVi() {
        return blogPostContentVi;
    }

    public StringFilter blogPostContentVi() {
        if (blogPostContentVi == null) {
            blogPostContentVi = new StringFilter();
        }
        return blogPostContentVi;
    }

    public void setBlogPostContentVi(StringFilter blogPostContentVi) {
        this.blogPostContentVi = blogPostContentVi;
    }

    public StringFilter getBlogPostTitleEn() {
        return blogPostTitleEn;
    }

    public StringFilter blogPostTitleEn() {
        if (blogPostTitleEn == null) {
            blogPostTitleEn = new StringFilter();
        }
        return blogPostTitleEn;
    }

    public void setBlogPostTitleEn(StringFilter blogPostTitleEn) {
        this.blogPostTitleEn = blogPostTitleEn;
    }

    public StringFilter getBlogPostDescriptionEn() {
        return blogPostDescriptionEn;
    }

    public StringFilter blogPostDescriptionEn() {
        if (blogPostDescriptionEn == null) {
            blogPostDescriptionEn = new StringFilter();
        }
        return blogPostDescriptionEn;
    }

    public void setBlogPostDescriptionEn(StringFilter blogPostDescriptionEn) {
        this.blogPostDescriptionEn = blogPostDescriptionEn;
    }

    public StringFilter getBlogPostContentEn() {
        return blogPostContentEn;
    }

    public StringFilter blogPostContentEn() {
        if (blogPostContentEn == null) {
            blogPostContentEn = new StringFilter();
        }
        return blogPostContentEn;
    }

    public void setBlogPostContentEn(StringFilter blogPostContentEn) {
        this.blogPostContentEn = blogPostContentEn;
    }

    public CurrentStatusFilter getBlogPostStatus() {
        return blogPostStatus;
    }

    public CurrentStatusFilter blogPostStatus() {
        if (blogPostStatus == null) {
            blogPostStatus = new CurrentStatusFilter();
        }
        return blogPostStatus;
    }

    public void setBlogPostStatus(CurrentStatusFilter blogPostStatus) {
        this.blogPostStatus = blogPostStatus;
    }

    public StringFilter getBlogPostAuthor() {
        return blogPostAuthor;
    }

    public StringFilter blogPostAuthor() {
        if (blogPostAuthor == null) {
            blogPostAuthor = new StringFilter();
        }
        return blogPostAuthor;
    }

    public void setBlogPostAuthor(StringFilter blogPostAuthor) {
        this.blogPostAuthor = blogPostAuthor;
    }

    public StringFilter getBlogPostSlug() {
        return blogPostSlug;
    }

    public StringFilter blogPostSlug() {
        if (blogPostSlug == null) {
            blogPostSlug = new StringFilter();
        }
        return blogPostSlug;
    }

    public void setBlogPostSlug(StringFilter blogPostSlug) {
        this.blogPostSlug = blogPostSlug;
    }

    public ZonedDateTimeFilter getTimeToPublish() {
        return timeToPublish;
    }

    public ZonedDateTimeFilter timeToPublish() {
        if (timeToPublish == null) {
            timeToPublish = new ZonedDateTimeFilter();
        }
        return timeToPublish;
    }

    public void setTimeToPublish(ZonedDateTimeFilter timeToPublish) {
        this.timeToPublish = timeToPublish;
    }

    public StringFilter getThumbnailLink() {
        return thumbnailLink;
    }

    public StringFilter thumbnailLink() {
        if (thumbnailLink == null) {
            thumbnailLink = new StringFilter();
        }
        return thumbnailLink;
    }

    public void setThumbnailLink(StringFilter thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public ZonedDateTimeFilter getCreatedTime() {
        return createdTime;
    }

    public ZonedDateTimeFilter createdTime() {
        if (createdTime == null) {
            createdTime = new ZonedDateTimeFilter();
        }
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTimeFilter createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTimeFilter getModifiedTime() {
        return modifiedTime;
    }

    public ZonedDateTimeFilter modifiedTime() {
        if (modifiedTime == null) {
            modifiedTime = new ZonedDateTimeFilter();
        }
        return modifiedTime;
    }

    public void setModifiedTime(ZonedDateTimeFilter modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public StringFilter getModifiedBy() {
        return modifiedBy;
    }

    public StringFilter modifiedBy() {
        if (modifiedBy == null) {
            modifiedBy = new StringFilter();
        }
        return modifiedBy;
    }

    public void setModifiedBy(StringFilter modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public StringFilter getCreatedBy() {
        return createdBy;
    }

    public StringFilter createdBy() {
        if (createdBy == null) {
            createdBy = new StringFilter();
        }
        return createdBy;
    }

    public void setCreatedBy(StringFilter createdBy) {
        this.createdBy = createdBy;
    }

    public IntegerFilter getNumberOfViews() {
        return numberOfViews;
    }

    public IntegerFilter numberOfViews() {
        if (numberOfViews == null) {
            numberOfViews = new IntegerFilter();
        }
        return numberOfViews;
    }

    public void setNumberOfViews(IntegerFilter numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public LongFilter getCategoryId() {
        return categoryId;
    }

    public LongFilter categoryId() {
        if (categoryId == null) {
            categoryId = new LongFilter();
        }
        return categoryId;
    }

    public void setCategoryId(LongFilter categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BlogPostCriteria that = (BlogPostCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(blogPostTitleVi, that.blogPostTitleVi) &&
            Objects.equals(blogPostDescriptionVi, that.blogPostDescriptionVi) &&
            Objects.equals(blogPostContentVi, that.blogPostContentVi) &&
            Objects.equals(blogPostTitleEn, that.blogPostTitleEn) &&
            Objects.equals(blogPostDescriptionEn, that.blogPostDescriptionEn) &&
            Objects.equals(blogPostContentEn, that.blogPostContentEn) &&
            Objects.equals(blogPostStatus, that.blogPostStatus) &&
            Objects.equals(blogPostAuthor, that.blogPostAuthor) &&
            Objects.equals(blogPostSlug, that.blogPostSlug) &&
            Objects.equals(timeToPublish, that.timeToPublish) &&
            Objects.equals(thumbnailLink, that.thumbnailLink) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(numberOfViews, that.numberOfViews) &&
            Objects.equals(categoryId, that.categoryId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            blogPostTitleVi,
            blogPostDescriptionVi,
            blogPostContentVi,
            blogPostTitleEn,
            blogPostDescriptionEn,
            blogPostContentEn,
            blogPostStatus,
            blogPostAuthor,
            blogPostSlug,
            timeToPublish,
            thumbnailLink,
            createdTime,
            modifiedTime,
            modifiedBy,
            createdBy,
            numberOfViews,
            categoryId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BlogPostCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (blogPostTitleVi != null ? "blogPostTitleVi=" + blogPostTitleVi + ", " : "") +
            (blogPostDescriptionVi != null ? "blogPostDescriptionVi=" + blogPostDescriptionVi + ", " : "") +
            (blogPostContentVi != null ? "blogPostContentVi=" + blogPostContentVi + ", " : "") +
            (blogPostTitleEn != null ? "blogPostTitleEn=" + blogPostTitleEn + ", " : "") +
            (blogPostDescriptionEn != null ? "blogPostDescriptionEn=" + blogPostDescriptionEn + ", " : "") +
            (blogPostContentEn != null ? "blogPostContentEn=" + blogPostContentEn + ", " : "") +
            (blogPostStatus != null ? "blogPostStatus=" + blogPostStatus + ", " : "") +
            (blogPostAuthor != null ? "blogPostAuthor=" + blogPostAuthor + ", " : "") +
            (blogPostSlug != null ? "blogPostSlug=" + blogPostSlug + ", " : "") +
            (timeToPublish != null ? "timeToPublish=" + timeToPublish + ", " : "") +
            (thumbnailLink != null ? "thumbnailLink=" + thumbnailLink + ", " : "") +
            (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
            (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
            (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (numberOfViews != null ? "numberOfViews=" + numberOfViews + ", " : "") +
            (categoryId != null ? "categoryId=" + categoryId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
