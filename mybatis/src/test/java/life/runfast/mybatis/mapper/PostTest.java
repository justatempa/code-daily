package life.runfast.mybatis.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public void findPostByRowBounds() {
        RowBounds rowBounds = new RowBounds(0, 2);

        List<Post> postByPage = postMapper.findPostByRowBounds(rowBounds);

        System.out.println(postByPage.toString());
    }
    @Test
    public void findPostByPage() {
        PageHelper.startPage(1,3);
        Page<Post> postByPage = postMapper.findPostByPage();

        System.out.println(postByPage.toString());
    }
}
