package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.service.impl.AlbumServiceImpl;
import cn.tedu.csmall.product.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTests {
    @Autowired
    CategoryServiceImpl service;

    @Test
    void contextLoads(){
        System.out.println(service);
    }

    @Test
    void testAddNew(){
        CategoryAddNewDTO categoryAddNewDTO = new CategoryAddNewDTO();
        categoryAddNewDTO.setName("测试类别名称002");
        categoryAddNewDTO.setSort(22);

        try{
            service.addNew(categoryAddNewDTO);
            System.out.println("添加类别成功!");
        }catch (RuntimeException e){
            System.out.println("添加类别失败，类别名称已被占用！");
        }
    }

    @Test
    void testDelete(){
        Long id = 75L;
        try{
            service.delete(id);
            System.out.println("删除类别成功！");
        }catch (ServiceException e){
            System.out.println(e.getMessage());
        }
    }
}
