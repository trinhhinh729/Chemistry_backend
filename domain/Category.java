package com.hcmus.chemistry.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hcmus.chemistry.domain.enumeration.CurrentStatus;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_slug")
    private String categorySlug;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_status")
    private CurrentStatus categoryStatus;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private ZonedDateTime createdTime;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "category" }, allowSetters = true)
    private Set<BlogPost> blogPosts = new HashSet<>();

    @OneToMany(mappedBy = "parentCategory", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "blogPosts", "subCategories", "parentCategory" }, allowSetters = true)
    private Set<Category> subCategories = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "blogPosts", "subCategories", "parentCategory" }, allowSetters = true)
    private Category parentCategory;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Category id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Category categoryName(String categoryName) {
        this.setCategoryName(categoryName);
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategorySlug() {
        return this.categorySlug;
    }

    public Category categorySlug(String categorySlug) {
        this.setCategorySlug(categorySlug);
        return this;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public CurrentStatus getCategoryStatus() {
        return this.categoryStatus;
    }

    public Category categoryStatus(CurrentStatus categoryStatus) {
        this.setCategoryStatus(categoryStatus);
        return this;
    }

    public void setCategoryStatus(CurrentStatus categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Category createdBy(String createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTime() {
        return this.createdTime;
    }

    public Category createdTime(ZonedDateTime createdTime) {
        this.setCreatedTime(createdTime);
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Set<BlogPost> getBlogPosts() {
        return this.blogPosts;
    }

    public void setBlogPosts(Set<BlogPost> blogPosts) {
        if (this.blogPosts != null) {
            this.blogPosts.forEach(i -> i.setCategory(null));
        }
        if (blogPosts != null) {
            blogPosts.forEach(i -> i.setCategory(this));
        }
        this.blogPosts = blogPosts;
    }

    public Category blogPosts(Set<BlogPost> blogPosts) {
        this.setBlogPosts(blogPosts);
        return this;
    }

    public Category addBlogPost(BlogPost blogPost) {
        this.blogPosts.add(blogPost);
        blogPost.setCategory(this);
        return this;
    }

    public Category removeBlogPost(BlogPost blogPost) {
        this.blogPosts.remove(blogPost);
        blogPost.setCategory(null);
        return this;
    }

    public Set<Category> getSubCategories() {
        return this.subCategories;
    }

    public void setSubCategories(Set<Category> categories) {
        if (this.subCategories != null) {
            this.subCategories.forEach(i -> i.setParentCategory(null));
        }
        if (categories != null) {
            categories.forEach(i -> i.setParentCategory(this));
        }
        this.subCategories = categories;
    }

    public Category subCategories(Set<Category> categories) {
        this.setSubCategories(categories);
        return this;
    }

    public Category addSubCategory(Category category) {
        this.subCategories.add(category);
        category.setParentCategory(this);
        return this;
    }

    public Category removeSubCategory(Category category) {
        this.subCategories.remove(category);
        category.setParentCategory(null);
        return this;
    }

    public Category getParentCategory() {
        return this.parentCategory;
    }

    public void setParentCategory(Category category) {
        this.parentCategory = category;
    }

    public Category parentCategory(Category category) {
        this.setParentCategory(category);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", categoryName='" + getCategoryName() + "'" +
            ", categorySlug='" + getCategorySlug() + "'" +
            ", categoryStatus='" + getCategoryStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            "}";
    }
}
