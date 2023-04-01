package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class AttributeTemplateMapperTests {

    @Autowired
    AttributeTemplateMapper mapper;

    @Test
    void testInsert() {
        AttributeTemplate data = new AttributeTemplate();
        data.setName("测试数据001的名称");

        System.out.println("插入数据之前，参数=" + data);
        int rows = mapper.insert(data);
        System.out.println("插入数据完成，受影响的行数=" + rows);
        System.out.println("插入数据之后，参数=" + data);
    }

    @Test
    void testInsertBatch(){
        List<AttributeTemplate> attributeTemplateList = new ArrayList<>();
        for (int i = 1;i <= 10;i++){
            AttributeTemplate attributeTemplate = new AttributeTemplate();
            attributeTemplate.setName("批量插入的测试属性模板名称"+i);
            attributeTemplate.setPinyin("批量插入的测试属性模板拼音"+i);
            attributeTemplate.setKeywords("批量插入的测试属性模板关键字"+i);
            attributeTemplate.setSort(77);
            attributeTemplateList.add(attributeTemplate);
        }
        int rows = mapper.insertBatch(attributeTemplateList);
        System.out.println("批量插入数据完成，受印象的行数="+ rows);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        int rows = mapper.deleteById(id);
        System.out.println("删除数据完成，受影响的行数=" + rows);
    }

    @Test
    void testDeleteByIds(){
        Long[] ids = {3L,5L,7L,9L,11L};
        int rows = mapper.deleteByIds(ids);
        System.out.println("删除数据完成，受印象的行数="+ rows);
    }

    @Test
    void testGetStandardById(){
        Long id = 2L;
        Object result = mapper.getStandardById(id);
        System.out.println("根据id="+id+"查询属性模板信息完成，结果="+result);
    }

    @Test
    void testList(){
        List<?> list = mapper.list();
        System.out.println("查询列表完成，列表中的数据的数量="+list.size());
        for (Object item : list){
            System.out.println(item);
        }
    }

    @Test
    void testCountByName() {
        String name = "批量插入的测试属性模板名称10";
        int count = mapper.countByName(name);
        System.out.println("根据名称【" + name + "】统计数据完成，数量=" + count);
    }



}
