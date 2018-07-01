package com.railway.labor.score.util;
/**
 * 
 * @author zhuanglinxiang
 *
 */
public class EncryptUtil {
	public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    
    public static String entrypt(String plainText) {
        byte[] salt = DigestUtil.generateSalt(SALT_SIZE);
        byte[] hashText = DigestUtil.sha1(plainText.getBytes(), salt, HASH_INTERATIONS);
        return EncodeUtil.encodeHex(salt) + EncodeUtil.encodeHex(hashText);
    }
	
	public static boolean validate(String plainText, String entryptText) {
        byte[] salt = EncodeUtil.decodeHex(entryptText.substring(0, 16));
        byte[] hashText = DigestUtil.sha1(plainText.getBytes(), salt, HASH_INTERATIONS);
        return entryptText.equals(EncodeUtil.encodeHex(salt) + EncodeUtil.encodeHex(hashText));
    }
}
