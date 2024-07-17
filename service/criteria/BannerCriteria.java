package com.hcmus.chemistry.service.criteria;

import com.hcmus.chemistry.domain.enumeration.CurrentStatus;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.hcmus.chemistry.domain.Banner} entity. This class is used
 * in {@link com.hcmus.chemistry.web.rest.BannerResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /banners?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BannerCriteria implements Serializable, Criteria {

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

    private StringFilter bannerLink;

    private CurrentStatusFilter bannerStatus;

    private StringFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private ZonedDateTimeFilter modifiedTime;

    private StringFilter modifiedBy;

    private Boolean distinct;

    public BannerCriteria() {}

    public BannerCriteria(BannerCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.bannerLink = other.bannerLink == null ? null : other.bannerLink.copy();
        this.bannerStatus = other.bannerStatus == null ? null : other.bannerStatus.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.distinct = other.distinct;
    }

    @Override
    public BannerCriteria copy() {
        return new BannerCriteria(this);
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

    public StringFilter getBannerLink() {
        return bannerLink;
    }

    public StringFilter bannerLink() {
        if (bannerLink == null) {
            bannerLink = new StringFilter();
        }
        return bannerLink;
    }

    public void setBannerLink(StringFilter bannerLink) {
        this.bannerLink = bannerLink;
    }

    public CurrentStatusFilter getBannerStatus() {
        return bannerStatus;
    }

    public CurrentStatusFilter bannerStatus() {
        if (bannerStatus == null) {
            bannerStatus = new CurrentStatusFilter();
        }
        return bannerStatus;
    }

    public void setBannerStatus(CurrentStatusFilter bannerStatus) {
        this.bannerStatus = bannerStatus;
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
        final BannerCriteria that = (BannerCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(bannerLink, that.bannerLink) &&
            Objects.equals(bannerStatus, that.bannerStatus) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bannerLink, bannerStatus, createdBy, createdTime, modifiedTime, modifiedBy, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BannerCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (bannerLink != null ? "bannerLink=" + bannerLink + ", " : "") +
            (bannerStatus != null ? "bannerStatus=" + bannerStatus + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
            (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
            (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
