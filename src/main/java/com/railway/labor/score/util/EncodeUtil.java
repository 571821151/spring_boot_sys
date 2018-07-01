package com.railway.labor.score.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/**
 * 
 * @author zhuanglinxiang
 *
 */
public final class EncodeUtil {

    private static final String DEFAULT_URL_ENCODING = "UTF-8";
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    
    private EncodeUtil() {
    	
    }

    /**
     * Hex编码.
     */
    public static String encodeHex(byte[] input) {
        return new String(Hex.encodeHex(input));
    }

    /**
     * Hex解码.
     */
    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw new RuntimeException("解码出错",e);
        }
    }

    /**
     * Base64编码.
     */
    public static String encodeBase64(byte[] input) {
        return new String(Base64.encodeBase64(input));
    }

    /**
     * Base64编码.
     */
    public static String encodeBase64(String input) {
        try {
            return new String(Base64.encodeBase64(input.getBytes(DEFAULT_URL_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * Base64解码.
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input.getBytes());
    }

    /**
     * Base64解码.
     */
    public static String decodeBase64String(String input) {
        try {
            return new String(Base64.decodeBase64(input.getBytes()), DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /**
     * Base62编码。
     */
    public static String encodeBase62(byte[] input) {
        char[] chars = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
        }
        return new String(chars);
    }


    /**
     * URL 解码, Encode默认为UTF-8.
     */
    public static String urlDecode(String part) {

        try {
            return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
        	throw new RuntimeException("解码出错",e);
        }
    }
}
