package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Spu;
import org.springframework.stereotype.Repository;


/**
 * 处理SPU数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Repository
public interface SpuMapper {

    /**
     * 插入SPU数据
     *
     * @param spu SPU数据
     * @return 受影响的行数
     */
    int insert(Spu spu);


}
