package com.aixuexi.util;

import com.aixuexi.model.User;
import com.liepin.b.common.util.BCommonDateUtil;
import com.liepin.cetus.util.base.BigIntegerUtil;
import com.liepin.common.other.DateUtil;
import com.liepin.common.other.MD5Util;
import com.liepin.common.other.StringUtil;
import com.liepin.platform.comp.company.dto.CompDto;
import java.math.BigInteger;
import java.net.URI;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javafx.scene.layout.Priority;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException, ParseException {

        String a = "20[]20[-]12-1";



    }

    public static String addDay(String dateStr, int days, String pattern) {
        if (StringUtil.isBlank(dateStr) || StringUtil.isBlank(pattern)) {
            return "";
        }

        // XXX 待测试对比,替换成下面的实现方式.remark by zhangbw#2019/04/28
        // return DateTime.parse(dateStr,
        // DateTimeFormat.forPattern(pattern)).plusDays(days).toString(pattern);

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);// 不把月份超过12的数据转换成下一年
        try {
            calendar.setTime(dateFormat.parse(dateStr));
        } catch (ParseException e) {
            return "";
        }
        calendar.add(Calendar.DAY_OF_MONTH, days);// 增加天数
        return dateFormat.format(calendar.getTime());
    }








}


