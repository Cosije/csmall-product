package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.service.impl.AlbumServiceImpl;
import cn.tedu.csmall.product.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BrandServiceTests {
    @Autowired
    BrandServiceImpl service;

    @Test
    void contextLoads(){
        System.out.println(service);
    }

    @Test
    void testAddNew(){
        BrandAddNewDTO brandAddNewDTO = new BrandAddNewDTO();
        brandAddNewDTO.setName("测试品牌名称001");
        brandAddNewDTO.setSort(11);

        try{
            service.addNew(brandAddNewDTO);
            System.out.println("添加品牌成功!");
        }catch (RuntimeException e){
            System.out.println("添加品牌失败，品牌名称已被占用！");
        }
    }

    @Test
    void testDelete(){
        Long id = 30L;
        try{
            service.delete(id);
            System.out.println("删除品牌成功！");
        }catch (ServiceException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testList(){
        List<?> list = service.list();
        System.out.println("查询列表完成，列表中的数据的数量=" + list.size());
        for (Object item : list){
            System.out.println(item);
        }
    }
}
