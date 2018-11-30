package Java.Crypto;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CryptoTest {





    public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            // Note
            // KerbTicket Encryption Type: AES-256-CTS-HMAC-SHA1-96
            //  AES in CTR (Counter) mode, and append an HMAC.
            // https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html

            // Type instance can be found here:
            // https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            // Other type getInstance
            // bouncycastle library
            // https://bouncycastle.org/
            // Cipher cipher = Cipher.getInstance("AES/CTR/PKCS5Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String key, String initVector, String encrypted) {

        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            final byte[] decode = Base64.getDecoder().decode(encrypted);
            byte[] original = cipher.doFinal(decode);

            return new String(original);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void base64Test() {
        String encode = Base64.getEncoder().encodeToString("Nico".getBytes());
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode,StandardCharsets.UTF_8));

    }

    @Test
    public void testEnc() {

        String key = "welcome1";

        // key lengths: 128, 192 and 256 bits.
        // https://en.wikipedia.org/wiki/Advanced_Encryption_Standard
        final int keyLength = 256;

        final int keyAdd = (keyLength / 8) - key.length();

        String keyTarget = new StringBuilder()
                .append(key)
                .append((new String(new char[keyAdd]).replace("\0", "b")))
                .toString();

        String initVector = "RandomInitVector"; // 16 bytes IV

        final String encrypt = encrypt(keyTarget, initVector, "Hello World");
        System.out.println(encrypt);
        final String decrypt = decrypt(keyTarget, initVector, encrypt);
        System.out.println(decrypt);
    }
}
