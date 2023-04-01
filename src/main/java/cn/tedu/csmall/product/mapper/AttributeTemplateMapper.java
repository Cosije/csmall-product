package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeTemplateMapper {
    int insert(AttributeTemplate attributeTemplate);

    int deleteById(Long id);

    AttributeTemplateStandardVO getStandardById(Long id);

    /**
     * 批量插入相册数据
     */
    int insertBatch(List<AttributeTemplate> attributeTemplateList);

    /**
     * 根据id批量删除属性模板
     */
    int deleteByIds(Long[] ids);

    /**
     * 根据属性模板名称，统计数据的数量
     */
    int countByName(String name);

    /**
     * 显示属性模板列表
     */
    List<AttributeTemplateListItemVO> list();
}
