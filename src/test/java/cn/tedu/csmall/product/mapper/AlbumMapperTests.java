package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AlbumMapperTests {

    @Autowired
    AlbumMapper mapper;

    @Test
    void testInsert(){
        Album album = new Album();
        album.setName("测试相册001");
        album.setDescription("测试简介001");
        album.setSort(99);

        System.out.println("插入数据之前，参数=" + album);
        int rows = mapper.insert(album);
        System.out.println("插入数据完成，受印象的行数="+ rows);
        System.out.println("插入数据之后，参数=" + album);
    }

    @Test
    void testInsertBatch(){
        List<Album> albumList = new ArrayList<>();
        for (int i = 1;i <= 10;i++){
            Album album = new Album();
            album.setName("批量插入的测试相册名称"+i);
            album.setDescription("批量插入的测试相册简介"+i);
            album.setSort(66);
            albumList.add(album);
        }
        int rows = mapper.insertBatch(albumList);
        System.out.println("批量插入数据完成，受印象的行数="+ rows);
    }

    @Test
    void testDeleteById(){
        Long id = 1L;
        int rows = mapper.deleteById(id);
        System.out.println("删除数据完成，受印象的行数="+ rows);
    }

    @Test
    void testDeleteByIds(){
        Long[] ids = {4L,5L};
        int rows = mapper.deleteByIds(ids);
        System.out.println("删除数据完成，受印象的行数="+ rows);
    }

    @Test
    void testCount(){
        int count = mapper.count();
        System.out.println("统计数据完成，数量="+count);
    }

    @Test
    void testGetStandardById(){
        Long id = 3L;
        Object result = mapper.getStandardById(id);
        System.out.println("根据id="+id+"查询标准信息完成，结果="+result);
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
    void testUpdateById(){
        Album album = new Album();
        album.setId(2L);
        album.setName("新的相册名称");
        album.setDescription("新的相册简介");
        album.setSort(166);

        int rows = mapper.updateById(album);
        System.out.println("插入数据完成，受印象的行数="+ rows);
    }

    @Test
    void testCountByName() {
        String name = "测试相册001";
        int count = mapper.countByName(name);
        System.out.println("根据名称【" + name + "】统计数据完成，数量=" + count);
    }

}
