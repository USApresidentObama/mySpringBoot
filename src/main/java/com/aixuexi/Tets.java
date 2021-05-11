package com.aixuexi;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

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
                if (StringUtils.isNotBlank(temp)) {
                    ecompIdList.add(Long.valueOf(temp));
                }
            }
        }catch (Exception e) {
            System.out.printf("失败"+e);
        }
        System.out.println(ecompIdList);
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
