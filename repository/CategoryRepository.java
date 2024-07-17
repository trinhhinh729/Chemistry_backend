package com.hcmus.chemistry.repository;

import com.hcmus.chemistry.domain.Category;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Category entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    @Query(
        value = "SELECT * FROM category WHERE category_name in ('Tin tức - sự kiện', 'ĐÀO TẠO ĐH', 'Sinh viên - Cựu SV', 'Nghiên cứu khoa học')",
        nativeQuery = true
    )
    List<Category> getHomePageCategories();

    @Query(value = "select * from category c where c.category_status = 'ENABLED'", nativeQuery = true)
    List<Category> getCategoriesWithConditions();
}
