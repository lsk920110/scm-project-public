package com.gamsung.scmproject.productCategory.repository;

import com.gamsung.scmproject.productCategory.model.ProductCategoryEntity;
import com.gamsung.scmproject.productCategory.vo.ProductCategoryVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity,Long> {
}
