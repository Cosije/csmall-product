package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.SpuDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpuDetailMapperTests {

    @Autowired
    SpuDetailMapper mapper;

    @Test
    void testInsert() {
        SpuDetail data = new SpuDetail();
        data.setSpuId(1L);

        System.out.println("插入数据之前，参数=" + data);
        int rows = mapper.insert(data);
        System.out.println("插入数据完成，受影响的行数=" + rows);
        System.out.println("插入数据之后，参数=" + data);
    }


}
