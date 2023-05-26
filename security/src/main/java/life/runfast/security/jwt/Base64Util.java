package life.runfast.security.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/26 11:05
 */
public class Base64Util {
    public static String decodeBase64(String str) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(str.getBytes());
        String decodedStr = new String(decodedBytes);
        System.out.println("Base64解码后的字符串：" + str + " --> " + decodedStr);
        return decodedStr;
    }

    public static String encodeBase64(String str) {
        byte[] encodedBytes = java.util.Base64.getEncoder().encode(str.getBytes());
        String encodedStr = new String(encodedBytes);
        System.out.println("Base64编码后的字符串：" + str + " --> " + encodedStr);
        return encodedStr;
    }

    public static String encode(String str) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

}
