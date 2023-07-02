package life.runfast.mybatis.mapper;

import com.github.pagehelper.Page;
import life.runfast.mybatis.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author justatempa
 * @description
 * @datetime 2023/7/2 17:13
 */
@Mapper
@Repository
public interface PostMapper {

    List<Post> findPostByRowBounds(RowBounds rowBounds);

    Page<Post> findPostByPage();
}
