package life.runfast.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/26 9:09
 */
public class Auth0Jwt {

    public String getToken() {
        String token = "";
        try {
            RSA256Key instance = RSA256.getInstance();
            Algorithm algorithm = Algorithm.RSA256(instance.getPublicKey(), instance.getPrivateKey());
            token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            System.out.println(token);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            exception.printStackTrace();
        }
        return token;
    }


}
