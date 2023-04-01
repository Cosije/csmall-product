package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.SpuDetail;
import org.springframework.stereotype.Repository;


/**
 * 处理SPU详情数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
public interface SpuDetailMapper {

    /**
     * 插入SPU详情数据
     *
     * @param spuDetail SPU详情数据
     * @return 受影响的行数
     */
    int insert(SpuDetail spuDetail);


}
