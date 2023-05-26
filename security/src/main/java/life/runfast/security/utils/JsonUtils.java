package life.runfast.security.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/26 15:55
 */
public class JsonUtils {

    private static final ObjectMapper mapper;
    private static final SimpleModule module = new SimpleModule();

    static {
        //mapper = new ObjectMapper();
        mapper = ((JsonMapper) ((com.fasterxml.jackson.databind.json.JsonMapper.Builder) JsonMapper.builder().configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)).build()).registerModule(module);
    }

    public static String getJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
