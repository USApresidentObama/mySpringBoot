package com.aixuexi.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class DesUtil {

    public static final String KEY1 = "KEY11111111";

    public static String encrypt(String str, String key) {
        if (str == null) {
            return null;
        }
        if (key == null || key.length() < 8) {
            return null;
        }
        //密钥
        Key k = new javax.crypto.spec.SecretKeySpec(key.getBytes(), "DES");

        try {
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, k);
            byte[] bs = cipher.doFinal(str.getBytes());
            return new String(bs);
        }catch (Exception e) {

        }
        return null;
    }


}
