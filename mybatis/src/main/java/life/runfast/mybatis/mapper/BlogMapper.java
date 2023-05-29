package life.runfast.mybatis.mapper;

import life.runfast.mybatis.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/29 13:51
 */
@Mapper
@Repository
public interface BlogMapper {

    Blog getById(Long id);
}
