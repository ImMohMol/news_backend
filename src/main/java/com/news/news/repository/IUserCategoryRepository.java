package com.news.news.repository;

import com.news.news.model.UserSelectedCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserCategoryRepository extends JpaRepository<UserSelectedCategories, Long> {
}
