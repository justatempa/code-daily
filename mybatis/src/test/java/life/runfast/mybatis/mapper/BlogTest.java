package life.runfast.mybatis.mapper;

import life.runfast.mybatis.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/29 13:57
 */
@SpringBootTest
public class BlogTest {
    @Autowired
    private BlogMapper blogMapper;
    @Test
    public void getById() {
        Blog byId = blogMapper.getById(1L);
        System.out.println(byId);
    }
}
