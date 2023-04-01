package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理相册业务的实现类
 */
@Slf4j
@Service
public class AlbumServiceImpl  implements IAlbumService{
    @Autowired
    AlbumMapper albumMapper;

    public AlbumServiceImpl(){
        System.out.println("创建业务实现类对象：AlbumServiceImpl");
    }

    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO){
        log.debug("开始处理【添加相册】的业务，参数：{}", albumAddNewDTO);
        String name = albumAddNewDTO.getName();
        int count = albumMapper.countByName(name);
        if (count != 0){
            //是：名称已存在，不允许创建，抛出异常
            String message = "添加相册失败，尝试添加的相册名称已被占用！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO,album);
        log.debug("即将插入相册数据：{}", album);
        albumMapper.insert(album);

    }

    @Override
    public void delete(Long id){
        log.debug("开始处理【删除相册】的业务，参数：{}",id);
        AlbumStandardVO queryResult = albumMapper.getStandardById(id);
        if (queryResult == null){
            String message = "删除相册失败，尝试访问数据不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }

        log.debug("即将删除相册数据...");
        albumMapper.deleteById(id);
        log.debug("删除相册完成！");
    }

    @Override
    public List<AlbumListItemVO> list(){
        log.debug("开始处理【查询相册列表】的业务");
        return albumMapper.list();
    }
}
