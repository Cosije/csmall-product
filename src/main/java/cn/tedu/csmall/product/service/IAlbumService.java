package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;

import java.util.List;

/**
 * 处理相册数据的业务接口
 */
public interface IAlbumService {
    /**
     * 添加相册
     */
    void addNew(AlbumAddNewDTO albumAddNewDto);

    /**
     * 根据id删除相册
     */
    void delete(Long id);

    /**
     * 查询相册列表
     */
    List<AlbumListItemVO> list();

}
