package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AttributeTemplateServiceTests {
    @Autowired
    IAttributeTemplateService service;

    @Test
    void contextLoads(){
        System.out.println(service);
    }

    @Test
    void testAddNew(){
        AttributeTemplateAddNewDTO attributeTemplateAddNewDTO = new AttributeTemplateAddNewDTO();
        attributeTemplateAddNewDTO.setName("测试客户端插入属性模板名字1");
        attributeTemplateAddNewDTO.setPinyin("测试客户端插入属性模板拼音1");
        attributeTemplateAddNewDTO.setKeywords("测试客户端插入属性模板关键字1");
        attributeTemplateAddNewDTO.setSort(11);

        try{
            service.addNew(attributeTemplateAddNewDTO);
            System.out.println("添加属性模板成功!");
        }catch (RuntimeException e){
            System.out.println("添加属性模板失败，属性模板名字已被占用！");
        }
    }

    @Test
    void testDelete(){
        Long id = 12L;

        try{
            service.delete(id);
            System.out.println("删除属性模板成功！");
        }catch (ServiceException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testList(){
        List<?> list = service.list();
        System.out.println("查询列表完成，列表中的数据的数量="+list.size());
        for (Object item : list){
            System.out.println(item);
        }
    }
}
