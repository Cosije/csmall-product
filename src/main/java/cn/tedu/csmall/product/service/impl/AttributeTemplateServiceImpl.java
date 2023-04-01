package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AttributeTemplateMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AttributeTemplateServiceImpl implements IAttributeTemplateService {
    @Autowired
    AttributeTemplateMapper attributeTemplateMapper;

    public AttributeTemplateServiceImpl(){
        System.out.println("创建业务实现类对象：AttributeTemplateServiceImpl");
    }


    @Override
    public void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO){
        log.debug("开始处理【添加属性模板】的业务，参数：{}", attributeTemplateAddNewDTO);
        String name = attributeTemplateAddNewDTO.getName();
        int count = attributeTemplateMapper.countByName(name);
        if (count != 0){
            String message = "添加属性模板失败，尝试添加的属性模板名称已被占用！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        AttributeTemplate attributeTemplate = new AttributeTemplate();
        BeanUtils.copyProperties(attributeTemplateAddNewDTO,attributeTemplate);
        log.debug("即将插入属性模板数据：{}", attributeTemplate);
        attributeTemplateMapper.insert(attributeTemplate);
    }

    @Override
    public void delete(Long id){
        log.debug("开始处理【删除属性模板】的业务，参数：{}", id);
        AttributeTemplateStandardVO queryResult = attributeTemplateMapper.getStandardById(id);
        if (queryResult == null){
            String message = "删除属性模板失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        log.debug("即将删除属性模板数据...");
        attributeTemplateMapper.deleteById(id);
        log.debug("删除属性模板，完成！");
    }

    @Override
    public List<AttributeTemplateListItemVO> list(){
        log.debug("开始处理【查询属性模板列表】的业务");
        return attributeTemplateMapper.list();
    }
}
