package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;

import java.util.List;

public interface IAttributeTemplateService {
    /**
     * 添加属性模板
     */
    void addNew(AttributeTemplateAddNewDTO attributeAddNewDTO);

    /**
     * 根据id删除属性模板
     */
      void delete(Long id);

    /**
     * 显示属性模板列表
     */
    List<AttributeTemplateListItemVO> list();
}
