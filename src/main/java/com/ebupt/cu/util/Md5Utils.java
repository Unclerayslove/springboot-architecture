package com.ebupt.cu.util;

import com.ebupt.cu.config.exception.ApiException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName Md5Utils
 * @Description
 * @Author Leipei
 * @Date 2020/11/25 15:50
 * @Version V1.0
 **/
public class Md5Utils {

    /**
     * 获取密码通过MD5加密后的后16位
     *
     * @param password
     * @return
     */
    public static String get16MD5PD(String password) {
        return md5Message(password).substring(16);
    }

    /**
     * MD5加密
     *
     * @param message
     * @return
     */
    public static String md5Message(String message) {
        String temp;
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] encodingMd5Digest = md5Digest.digest(message.getBytes());
            temp = convertBytesToHexString(encodingMd5Digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ApiException("9999", "加密失败");
        }
        return temp;
    }


    /**
     * 将byte数组转换为16进制输出
     *
     * @param bytes
     * @return
     */
    private static String convertBytesToHexString(byte[] bytes) {
        String result = "";
        for (int i = 0; i < bytes.length; i++) {
            int temp = bytes[i] & 0xff;
            String tempHex = Integer.toHexString(temp);
            result += (tempHex.length() < 2) ? ("0" + tempHex) : tempHex;
        }
        return result;
    }

}
