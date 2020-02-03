package Java.Crypto;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import static javax.xml.bind.DatatypeConverter.parseHexBinary;
import static javax.xml.bind.DatatypeConverter.printHexBinary;

public class CryptoSymmetricCipherTest {


    public static String encrypt(SecretKeySpec skeySpec, byte[] initVector, String value) {
        try {


            // Padding PKCS7

            // # COMBINE SALT, DIGEST AND DATA
            // hmac = HMAC(b_key2, hashes.SHA256(), CRYPTOGRAPHY_BACKEND)
            // hmac.update(b_ciphertext)
            // b_hmac = hmac.finalize()


            //skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            IvParameterSpec iv = new IvParameterSpec(initVector);


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

    public static String decrypt(SecretKeySpec key, byte[] initVector, String encrypted) {

        try {
            IvParameterSpec iv = new IvParameterSpec(initVector);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);

            final byte[] decode = Base64.getDecoder().decode(encrypted);
            byte[] original = cipher.doFinal(decode);

            return new String(original);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // From https://stackoverflow.com/questions/3208160/how-to-generate-an-hmac-in-java-equivalent-to-a-python-example
    // md5 is the python hmac implementation
    public static String encodeHMAC(String key, String message) throws Exception {

        // Generate a key for the HMAC-MD5 keyed-hashing algorithm; see RFC 2104
        // In practice, you would save this key.
        SecretKey keySpec;
        final String hmacCipher = "HmacMD5"; // could be also HmacSHA1
        if (key == null) {
            KeyGenerator keyGen = KeyGenerator.getInstance(hmacCipher);
            keySpec = keyGen.generateKey();
        } else {
            keySpec = new SecretKeySpec(
                    key.getBytes(),
                    hmacCipher);
        }


        Mac mac = Mac.getInstance(hmacCipher);
        mac.init(keySpec);
        byte[] rawHmac = mac.doFinal(message.getBytes());

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(rawHmac);

    }


    @Test
    public void base64Test() {
        String encode = Base64.getEncoder().encodeToString("Nico".getBytes());
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode, StandardCharsets.UTF_8));

    }

    @Test
    public void encryptionDecryptionTest() throws NoSuchAlgorithmException, InvalidKeySpecException {

        String passphrase = "welcome1";
        final String originalPlaintext = "Hello World";

        // key lengths: 128, 192 and 256 bits.
        // https://en.wikipedia.org/wiki/Advanced_Encryption_Standard
        final int keyLength = 256;

        // random bytes
        byte[] salt = new byte[32]; // Ansible size
        new Random().nextBytes(salt);

        SecretKeySpec keySpec = generateKeyFromPassphrase(passphrase, keyLength, salt);

        // AES is a 128-bit block cipher, so IVs and counter nonces are 16 bytes
        int aes_block_size = 128;
        int iv_length = aes_block_size / 8;
        byte[] initVector = new byte[iv_length];
        new Random().nextBytes(initVector);


        final String cipherText = encrypt(keySpec, initVector, originalPlaintext);
        System.out.println("CipherText : " + cipherText);
        // COMBINE SALT, DIGEST AND DATA
        // hmac
        // b_vaulttext = b'\n'.join([hexlify(b_salt), b_hmac, b_ciphertext])


        keySpec = generateKeyFromPassphrase(passphrase, keyLength, salt);
        final String decryptedPlainText = decrypt(keySpec, initVector, cipherText);
        System.out.println("Decrypted PlainText : " + decryptedPlainText);

        Assert.assertEquals(originalPlaintext, decryptedPlainText);

    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    // hexadecimal representation of the binary data.
    // hexlify
    // https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    private String bitStringToHexaDecimal(byte[] bytes){

        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    @Test
    public void bitStringToHexTest() {
        byte[] originalBitString = new byte[32];
        new Random().nextBytes(originalBitString);
        System.out.println(
                Arrays.asList(originalBitString)
                        .stream()
        );
        String hexStringFunc1 = printHexBinary(originalBitString);
        String hexStringFun1 = bitStringToHexaDecimal(originalBitString);
        Assert.assertEquals("The two function are giving the same hexString",hexStringFunc1, hexStringFun1);
        System.out.println(hexStringFunc1);
        byte[] decryptedBitString1 = parseHexBinary(hexStringFun1);
        byte[] decryptedBitString2 = hexStringToByteArray(hexStringFun1);
        Assert.assertEquals("The two function are giving the same bit string",decryptedBitString1, decryptedBitString2);

    }

    private SecretKeySpec generateKeyFromPassphrase(String passphrase, int keyLength, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Create a secret key from a password
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        final int numberOfIterations = 10000; // same as Ansible
        KeySpec pbeKeySpec = new PBEKeySpec(passphrase.toCharArray(), salt, numberOfIterations, keyLength);
        SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }
}
