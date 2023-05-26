package life.runfast.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/26 10:14
 */
@Data
@AllArgsConstructor
public class RSA256Key {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    public String getPublicKeyStr() {
        return Base64.getEncoder().encodeToString(publicKey != null ? publicKey.getEncoded() : "".getBytes());
    }

    public String getPrivateKeyStr() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded() != null ? privateKey.getEncoded() : "".getBytes());
    }
}
