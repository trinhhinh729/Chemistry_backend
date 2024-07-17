package com.hcmus.chemistry.domain;

import com.hcmus.chemistry.domain.enumeration.CurrentStatus;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Banner.
 */
@Entity
@Table(name = "banner")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "banner_link", nullable = false)
    private String bannerLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "banner_status")
    private CurrentStatus bannerStatus;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private ZonedDateTime createdTime;

    @Column(name = "modified_time")
    private ZonedDateTime modifiedTime;

    @Column(name = "modified_by")
    private String modifiedBy;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Banner id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerLink() {
        return this.bannerLink;
    }

    public Banner bannerLink(String bannerLink) {
        this.setBannerLink(bannerLink);
        return this;
    }

    public void setBannerLink(String bannerLink) {
        this.bannerLink = bannerLink;
    }

    public CurrentStatus getBannerStatus() {
        return this.bannerStatus;
    }

    public Banner bannerStatus(CurrentStatus bannerStatus) {
        this.setBannerStatus(bannerStatus);
        return this;
    }

    public void setBannerStatus(CurrentStatus bannerStatus) {
        this.bannerStatus = bannerStatus;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Banner createdBy(String createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTime() {
        return this.createdTime;
    }

    public Banner createdTime(ZonedDateTime createdTime) {
        this.setCreatedTime(createdTime);
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime getModifiedTime() {
        return this.modifiedTime;
    }

    public Banner modifiedTime(ZonedDateTime modifiedTime) {
        this.setModifiedTime(modifiedTime);
        return this;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public Banner modifiedBy(String modifiedBy) {
        this.setModifiedBy(modifiedBy);
        return this;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Banner)) {
            return false;
        }
        return id != null && id.equals(((Banner) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Banner{" +
            "id=" + getId() +
            ", bannerLink='" + getBannerLink() + "'" +
            ", bannerStatus='" + getBannerStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", modifiedBy='" + getModifiedBy() + "'" +
            "}";
    }
}
