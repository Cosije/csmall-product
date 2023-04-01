package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.BrandCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BrandCategoryMapperTests {

    @Autowired
    BrandCategoryMapper mapper;

    @Test
    void testInsert() {
        BrandCategory data = new BrandCategory();

        System.out.println("插入数据之前，参数=" + data);
        int rows = mapper.insert(data);
        System.out.println("插入数据完成，受影响的行数=" + rows);
        System.out.println("插入数据之后，参数=" + data);
    }


}
