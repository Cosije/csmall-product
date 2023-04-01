package cn.tedu.csmall.product.mapper;


import cn.tedu.csmall.product.pojo.entity.CategoryAttributeTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAttributeTemplateMapper {
    int insert(CategoryAttributeTemplate categoryAttributeTemplate);
}
