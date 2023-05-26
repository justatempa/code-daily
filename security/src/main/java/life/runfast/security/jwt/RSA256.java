package life.runfast.security.jwt;


import com.sun.istack.internal.Nullable;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSA256 {
    @Nullable
    public RSA256Key genKeyPair() {
        try {
            // 创建一个RSA密钥对生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // 初始化密钥对生成器，指定密钥长度和随机数生成器
            keyPairGenerator.initialize(2048, new SecureRandom());
            // 生成RSA密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            // 获取公钥和私钥
//            byte[] publicKey = keyPair.getPublic().getEncoded();
//            byte[] privateKey = keyPair.getPrivate().getEncoded();
//            String publicKeyStr = Base64.getEncoder().encodeToString(publicKey);
//            String privateKeyStr = Base64.getEncoder().encodeToString(privateKey);
//            System.out.println("公钥：" + publicKeyStr);
//            System.out.println("私钥：" + privateKeyStr);
            return new RSA256Key((RSAPublicKey) keyPair.getPublic(), (RSAPrivateKey) keyPair.getPrivate());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static RSA256Key INSTANCE;

    public static RSA256Key getInstance() {
        if (INSTANCE == null) {
            synchronized (RSA256Key.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RSA256().genKeyPair();
                }
            }
        }
        return INSTANCE;
    }
}