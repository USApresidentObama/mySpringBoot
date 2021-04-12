package com.aixuexi;


import com.liepin.common.other.DateUtil;
import com.liepin.common.other.MD5Util;
import com.liepin.common.other.StringUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tets {

    private static final String MOBILE_REGEX = "(?<!\\d)(?:(?:1[345678]\\d{9}))(?!\\d)";
    private static final Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGEX);
    public static final char SHELTER = '*';

    public static void main(String[] args) throws InterruptedException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("usereId.txt");
        //解析文件获取企业id
        BufferedReader bufferedReader = null;
        List<Long> ecompIdList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) {
                if (StringUtil.isNotBlank(temp)) {
                    ecompIdList.add(Long.valueOf(temp));
                }
            }
//            String[] ecompIdsArr = ecompIdsBuilder.toString().split(",");
//            for (String ecompIdStr : ecompIdsArr) {
//                if(StringUtil.isNotBlank(ecompIdStr)) {
//                    usereIdSet.add(Long.valueOf(ecompIdStr));
//                }
//            }
        }catch (Exception e) {
            System.out.printf("失败"+e);
        }
        System.out.println(ecompIdList);
    }

    public static final int[] hash(String objectId) {
        String md5Encode = MD5Util.MD5Encode(objectId);
        String m = md5Encode.substring(0, 4);
        int b = Integer.parseInt(m.substring(0, 3), 16);
        int t = Integer.parseInt(m.substring(3, 4), 16);
        return new int[]{b, t};
    }

    private static void mobileEscape(String text, final StringBuilder builder) {
        try {
            Matcher matcher = MOBILE_PATTERN.matcher(text);
            while (matcher.find()) {
                int pos = matcher.start();
                for (int i = pos + 3; i < pos + 7; i++) {
                    builder.setCharAt(i, SHELTER);
                }
            }
        } catch (Exception e) {
            // ignore
        }
    }

    private static String getMailSendtime() {
        // 比较时间
        String currentDatetime = DateUtil.getCurrentDateTime();
        final String time = "100000";
        String sendTime = DateUtil.getCurrentDate() + time;
        // 第二天早十点
        if (currentDatetime.compareTo(sendTime) > 0) {
            return DateUtil.getDate(1) + time;
        }
        return sendTime;
    }

    public static long daysBetween(String startdate, String enddate) {
        if (startdate == null || "".equals(startdate)) {
            return 0;
        }
        if (enddate == null || "".equals(enddate)) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date starttime = null;
        Date endtime = null;
        try {
            starttime = sdf.parse(startdate);
            endtime = sdf.parse(enddate);
        } catch (Exception e) {
            return 0;
        }

        cal.setTime(starttime);
        long l1 = cal.getTimeInMillis();

        cal.setTime(endtime);
        long l2 = cal.getTimeInMillis();

        return (l2 - l1) / (1000 * 60 * 60 * 24);
    }


    public static void sort(int[] a) {
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j <a.length-i-1 ; j++) {
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
