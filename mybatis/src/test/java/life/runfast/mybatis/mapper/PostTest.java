package life.runfast.mybatis.mapper;

import life.runfast.mybatis.model.Post;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author justatempa
 * @description
 * @datetime 2023/7/2 17:17
 */
@SpringBootTest
public class PostTest {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void findPostByPage() {
        RowBounds rowBounds = new RowBounds(0, 2);

        List<Post> postByPage = postMapper.findPostByPage(rowBounds);

        System.out.println(postByPage.toString());
    }

}
