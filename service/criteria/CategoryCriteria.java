package com.hcmus.chemistry.service.criteria;

import com.hcmus.chemistry.domain.enumeration.CurrentStatus;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.hcmus.chemistry.domain.Category} entity. This class is used
 * in {@link com.hcmus.chemistry.web.rest.CategoryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /categories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CategoryCriteria implements Serializable, Criteria {

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

    private StringFilter categoryName;

    private StringFilter categorySlug;

    private CurrentStatusFilter categoryStatus;

    private StringFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private LongFilter blogPostId;

    private LongFilter subCategoryId;

    private LongFilter parentCategoryId;

    private Boolean distinct;

    public CategoryCriteria() {}

    public CategoryCriteria(CategoryCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.categoryName = other.categoryName == null ? null : other.categoryName.copy();
        this.categorySlug = other.categorySlug == null ? null : other.categorySlug.copy();
        this.categoryStatus = other.categoryStatus == null ? null : other.categoryStatus.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.blogPostId = other.blogPostId == null ? null : other.blogPostId.copy();
        this.subCategoryId = other.subCategoryId == null ? null : other.subCategoryId.copy();
        this.parentCategoryId = other.parentCategoryId == null ? null : other.parentCategoryId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public CategoryCriteria copy() {
        return new CategoryCriteria(this);
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

    public StringFilter getCategoryName() {
        return categoryName;
    }

    public StringFilter categoryName() {
        if (categoryName == null) {
            categoryName = new StringFilter();
        }
        return categoryName;
    }

    public void setCategoryName(StringFilter categoryName) {
        this.categoryName = categoryName;
    }

    public StringFilter getCategorySlug() {
        return categorySlug;
    }

    public StringFilter categorySlug() {
        if (categorySlug == null) {
            categorySlug = new StringFilter();
        }
        return categorySlug;
    }

    public void setCategorySlug(StringFilter categorySlug) {
        this.categorySlug = categorySlug;
    }

    public CurrentStatusFilter getCategoryStatus() {
        return categoryStatus;
    }

    public CurrentStatusFilter categoryStatus() {
        if (categoryStatus == null) {
            categoryStatus = new CurrentStatusFilter();
        }
        return categoryStatus;
    }

    public void setCategoryStatus(CurrentStatusFilter categoryStatus) {
        this.categoryStatus = categoryStatus;
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

    public LongFilter getBlogPostId() {
        return blogPostId;
    }

    public LongFilter blogPostId() {
        if (blogPostId == null) {
            blogPostId = new LongFilter();
        }
        return blogPostId;
    }

    public void setBlogPostId(LongFilter blogPostId) {
        this.blogPostId = blogPostId;
    }

    public LongFilter getSubCategoryId() {
        return subCategoryId;
    }

    public LongFilter subCategoryId() {
        if (subCategoryId == null) {
            subCategoryId = new LongFilter();
        }
        return subCategoryId;
    }

    public void setSubCategoryId(LongFilter subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public LongFilter getParentCategoryId() {
        return parentCategoryId;
    }

    public LongFilter parentCategoryId() {
        if (parentCategoryId == null) {
            parentCategoryId = new LongFilter();
        }
        return parentCategoryId;
    }

    public void setParentCategoryId(LongFilter parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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
        final CategoryCriteria that = (CategoryCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(categoryName, that.categoryName) &&
            Objects.equals(categorySlug, that.categorySlug) &&
            Objects.equals(categoryStatus, that.categoryStatus) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(blogPostId, that.blogPostId) &&
            Objects.equals(subCategoryId, that.subCategoryId) &&
            Objects.equals(parentCategoryId, that.parentCategoryId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            categoryName,
            categorySlug,
            categoryStatus,
            createdBy,
            createdTime,
            blogPostId,
            subCategoryId,
            parentCategoryId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CategoryCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (categoryName != null ? "categoryName=" + categoryName + ", " : "") +
            (categorySlug != null ? "categorySlug=" + categorySlug + ", " : "") +
            (categoryStatus != null ? "categoryStatus=" + categoryStatus + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
            (blogPostId != null ? "blogPostId=" + blogPostId + ", " : "") +
            (subCategoryId != null ? "subCategoryId=" + subCategoryId + ", " : "") +
            (parentCategoryId != null ? "parentCategoryId=" + parentCategoryId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
