package com.aixuexi.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class SignUtil {

    private final String CIPHER_ALGORITHM = "DES";

    private Cipher cipher;

    private SignUtil(String secureKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(secureKey.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(CIPHER_ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(desKey);
        cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, random);
    }

    public static SignUtil getInstance(Long protocolNumber) {
        try {
            //通过协议码获取加密key，补码的十六进制表示
            String key = Long.toHexString(~protocolNumber);
            return new SignUtil(key);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException e) {
            return null;
        }
    }

    /**
     * 对字段进行签名（不可逆签名）
     *
     * 只支持对基本数据类型以及字符串进行签名，可以传入多个，需要约定顺序（加密与解密时传入参数顺序需要一致。）
     *
     * @return
     */
    public String sign(Object... objs) throws UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        StringBuilder preEncode = new StringBuilder("");
        //参数拼接
        for (Object obj : objs) {
            if (obj == null) {
                obj = "null";
            }
//            boolean isBaseType = TypeUtil.isBaseTypeOrString(obj);
//            if (!isBaseType) {
//                throw new IllegalArgumentException("params is not base type. class:" + obj.getClass().getName());
//            }
            preEncode.append(String.valueOf(obj));
            preEncode.append("&amp;");
        }
        preEncode.append(objs.length);
        //对参数进行Base64
        byte[] bytes = cipher.doFinal(preEncode.toString().getBytes("UTF-8"));
        return new String(bytes);
    }

    public boolean checkSign(String key, Object... objs) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        if (key == null) {
            return false;
        }
        String secretKey = sign(objs);
        return key.equals(secretKey);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        String secretKey = SignUtil.getInstance(1l).sign(12324l,12334l,1);
    }
}
