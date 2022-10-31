package com.example.springdemo.general.sign;

import com.mysql.cj.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.util.Arrays;
import java.util.Map;

/**
 * SignUtil
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/28 20:20
 */
public class SignUtil {

    private static final String DEFAULT_SECRET = "privatekey";

    public static String sign(String body, Map<String, String[]> params, String[] paths) {
        StringBuilder sb = new StringBuilder();
        if (!body.isBlank()) {
            sb.append(body).append('#');
        }

        if (!CollectionUtils.isEmpty(params)) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(paramEntry -> {
                        String paramValue = String.join(",", Arrays.stream(paramEntry.getValue()).sorted().toArray(String[]::new));
                        sb.append(paramEntry.getKey()).append("=").append(paramValue).append('#');
                    });
        }

        if (paths != null) {
            String pathValues = String.join(",", Arrays.stream(paths).sorted().toArray(String[]::new));
            sb.append(pathValues);
        }
        System.out.println(String.join("#", DEFAULT_SECRET, sb.toString()));
        String data = String.join("#", DEFAULT_SECRET, sb.toString());
        return getSHA256StrJava(data);
    }

    public static String getSHA256StrJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}