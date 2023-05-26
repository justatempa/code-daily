package life.runfast.security.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/26 15:58
 */
public class UtilsTest {

    @Test
    public void testJson() throws JsonProcessingException {
        Map<String , Object> json = new HashMap<>();
        //填充json，随机生成一些字段
        json.put("name","justatempa");
        json.put("id", 9999);
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.putAll(json);
        json.put("json", objectObjectHashMap);
        json.put("aaa", null);
        //Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)
        //json.put(null, "aaaa");
//        json.put(null, null);

        System.out.println(JsonUtils.getJson(json));
    }
}
