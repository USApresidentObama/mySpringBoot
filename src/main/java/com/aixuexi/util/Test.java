package com.aixuexi.util;

import com.aixuexi.model.PositionInfoDto;
import com.aixuexi.model.Role;
import com.aixuexi.model.User;
import org.apache.commons.collections.CollectionUtils;

import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    protected static char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final ExecutorService threadPool = Executors.newFixedThreadPool(8);





    public static void main(String[] args) throws UnsupportedEncodingException {
        int[] nums = {2, 1, 2, 4, 5,7};
        System.out.println(longestConsecutive(nums));

    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception var3) {
            }
        }

    }

    public static int longestConsecutive(int[] nums) {
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            int temLength = 1;
            int a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                a++;
                if (isExist(nums, a)) {
                    temLength++;
                    if (temLength == nums.length) {
                        return temLength;
                    }
                }else {
                    break;
                }
            }

            if (temLength > maxLength) {
                maxLength = temLength;
            }
        }
        return maxLength;
    }

    public static boolean isExist(int[] nums, int a) {
        for (int i = 0; i < nums.length; i++) {
            if (a == nums[i]) {
                return true;
            }
        }
        return false;
    }


    public static String getSign(Map<String, Object> params, String signKey) throws UnsupportedEncodingException {
        if (params == null || params.size() == 0) {
            return "";
        }
        params.put("sign_key", signKey);
        String paramsStr = toSortParamsStr(params);
        //LoggerUtils.consoleInfo("paramsStr："+paramsStr);
        //String md5Str  = MD5FileUtil.getMD5String(paramsStr);
        String md5Str = str2Md5(paramsStr);
        //LoggerUtils.consoleInfo("md5Str："+md5Str);
        params.remove("sign_key");
        return md5Str.toLowerCase();
    }

    public static String str2Md5(String inStr) {
        try {
            byte[] strTemp = inStr.getBytes("UTF-8");
            return getMD5String(strTemp);
			/*MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			return toHexString(md);*/
        } catch (Exception e) {
            return null;
        }
    }

    public static String getMD5String(byte[] bytes) {
        MessageDigest digest = null;

        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var3) {
        }

        if (digest == null) {
            return null;
        } else {
            digest.update(bytes);
            return bufferToHex(digest.digest());
        }
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;

        for (int l = m; l < k; ++l) {
            appendHexPair(bytes[l], stringbuffer);
        }

        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 240) >> 4];
        char c1 = hexDigits[bt & 15];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    public static String toSortParamsStr(Map<String, Object> params) {
        if (params == null || params.size() == 0) {
            return "";
        }
        int i = 0;
        String[] strArray = new String[params.size()];
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            strArray[i] = entry.getKey();
            i++;
        }

        Arrays.sort(strArray);

        String paramsStr = "";
        for (String key : strArray) {
            paramsStr += (key + "=" + params.get(key) + "&");
        }
        paramsStr = paramsStr.substring(0, paramsStr.length() - 1);
        //LoggerUtils.consoleInfo(paramsStr);
        return paramsStr;
    }

    public static void dd(PositionInfoDto positionInfoDto, List<Integer> list) {
        list.add(positionInfoDto.getId());
        if (CollectionUtils.isEmpty(positionInfoDto.getSubPositionInfoDtoList())) {
            return;
        }
        for (PositionInfoDto subPositionInfoDto : positionInfoDto.getSubPositionInfoDtoList()) {
            dd(subPositionInfoDto, list);
        }
    }

    public static LocalDateTime getLocalDateTime(long time) {
        Instant instant = Instant.ofEpochMilli(time);
        ZoneId zone = ZoneOffset.of("+8");
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static <T> T cast(Class<T> clazz) {
        System.out.println(clazz == Object.class && 1 == 1);
        return null;
    }

    public static User getUser(Integer id) {
        User user = new User();
        user.setId(id.longValue());
        Role role = new Role();
        role.setId(id);
        user.setRoles(role);
        return user;
    }

    public static String getUniqueId(String pwd) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        long longtime = new Date().getTime();
        return "" + longtime + MD5(pwd + uuid);
    }

    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int intervalDay(Date d1, Date d2) {
        long intervalMillSecond = setToDayStartTime(d1).getTime() - setToDayStartTime(d2).getTime();
        // 相差的天数 = 相差的毫秒数 / 每天的毫秒数 (小数位采用去尾制)
        return (int) (intervalMillSecond / (24 * 60 * 60 * 1000));
    }

    public static Date getDate(String date, String format) {
        Date d;
        try {
            d = new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            d = null;
        }
        return d;
    }

    public static Date setToDayStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(date.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static void bublle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int binaryWithDiGui(int low, int high, int[] arr, int target) {
        if (target < arr[low] || target > arr[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (target < arr[mid]) {
            return binaryWithDiGui(low, mid - 1, arr, target);
        }
        if (arr[mid] < target) {
            return binaryWithDiGui(mid + 1, high, arr, target);
        }
        return mid;
    }

    public static int binaryWithOutDiGui(int low, int high, int[] arr, int target) {
        if (target < arr[low] || target > arr[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        swap(mid, left, arr);
        int index = arr[left];
        int low = left;
        int high = right;

        while (low < high) {
            while (low < high && index <= arr[high]) {
                high--;
            }
            swap(low, high, arr);
            while (low < high && index >= arr[low]) {
                low++;
            }
            swap(low, high, arr);
        }
        if (left < low) {
            quickSort(arr, left, low - 1);
        }
        if (right > low) {
            quickSort(arr, low + 1, right);
        }
    }

    public static void quickSortWithStack(int[] arr, int left, int right) {
        Stack<Map<String, Integer>> stack = new Stack<>();

        Map<String, Integer> map = new HashMap<>();
        map.put("low", left);
        map.put("high", right);
        stack.push(map);

        while (!stack.isEmpty()) {
            Map<String, Integer> tempMap = stack.pop();
            int low = tempMap.get("low");
            int high = tempMap.get("high");
            int tempLow = low;
            int tempHigh = high;

            int index = arr[low];
            while (low < high) {
                while (low < high && index <= arr[high]) {
                    high--;
                }
                swap(low, high, arr);
                while (low < high && index >= arr[low]) {
                    low++;
                }
                swap(low, high, arr);
            }
            if (tempLow < low) {
                Map<String, Integer> map1 = new HashMap<>();
                map1.put("low", left);
                map1.put("high", low - 1);
                stack.push(map1);
            }
            if (tempHigh > low) {
                Map<String, Integer> map2 = new HashMap<>();
                map2.put("low", low + 1);
                map2.put("high", right);
                stack.push(map2);
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}


