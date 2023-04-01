package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.BrandCategory;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandCategoryMapper {

    int insert(BrandCategory brandCategory);


}
