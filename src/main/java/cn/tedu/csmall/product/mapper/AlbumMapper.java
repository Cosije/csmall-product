package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理相册数据的Mapper接口
 * @author csj
 * @version 0.0.1
 */
@Repository
public interface AlbumMapper {

    /**
     * 插入相册数据
     * @param album
     * @return 受影响的行数
     */
    int insert(Album album);

    /**
     * 批量插入相册数据
     */
        int insertBatch(List<Album> albumList);

    /**
     * 删除相册数据
     * @param album
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据id批量删除相册信息
     */
    int deleteByIds(Long[] ids);

    /**
     * 查询相册数据
     */
    int count();

    /**
     * 根据id查询相册标准信息
     */
    AlbumStandardVO getStandardById(Long id);

    /**
     * 根据id查询相册列表信息 倒序
     */
    List<AlbumListItemVO> list();

    /**
     * 更新相册数据
     */
    int updateById(Album album);

    /**
     * 根据相册名称，统计数据的数量
     */
    int countByName(String name);

}
