package life.runfast.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import life.runfast.security.utils.JsonUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.security.interfaces.RSAKey;
import java.util.Base64;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/26 9:09
 */
public class Auth0JwtTest {

    @Test
    public void testCreate() {
        new Auth0Jwt().getToken();
    }

    @Test
    public void testVerifier() {
        RSA256Key instance = RSA256.getInstance();

        String token = new Auth0Jwt().getToken();
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.RSA256(instance.getPublicKey(),instance.getPrivateKey());
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer("auth0")
                    // reusable verifier instance
                    .build();

            decodedJWT = verifier.verify(token);

            System.out.println(decodedJWT.getHeader());
            System.out.println(decodedJWT.getPayload());
            System.out.println(decodedJWT.getSignature());

            System.out.println(JsonUtils.getJson(decodedJWT));
        } catch (JWTVerificationException | JsonProcessingException exception){
            // Invalid signature/claims
            exception.printStackTrace();
        }


    }

    @Test
    public void testRAS256() {
        RSA256Key instance = RSA256.getInstance();
        System.out.println(instance.getPublicKeyStr());
        System.out.println(instance.getPrivateKeyStr());
    }

    @Test
    public void base64() {
        String str = "Hello, world!";
        byte[] encodedBytes = Base64.getEncoder().encode(str.getBytes());
        String encodedStr = new String(encodedBytes);
        System.out.println("Base64编码后的字符串：" + encodedStr);

        // 解码
        byte[] decodedBytes = Base64.getDecoder().decode(encodedStr.getBytes());
        String decodedStr = new String(decodedBytes);
        System.out.println("Base64解码后的字符串：" + decodedStr);

        System.out.println("Base64解码后的字符串：" + Base64Util.decodeBase64("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9"));
    }


    @Test
    public void testBase64() {
        String a = Base64Util.encodeBase64("中文");
        Base64Util.decodeBase64(a);
    }
}
