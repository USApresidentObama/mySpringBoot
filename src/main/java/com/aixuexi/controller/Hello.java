package com.aixuexi.controller;

import com.aixuexi.annotation.ControllerSecureVisit;
import com.aixuexi.common.enums.ExceptionEnum;
import com.aixuexi.liuaotest.exception.LiuaoException;
import com.aixuexi.model.EnumColor;
import com.aixuexi.model.Role;
import com.aixuexi.model.User;
import com.aixuexi.service.LiuaoService;
import com.aixuexi.util.Test;
import com.aixuexi.util.UtilTest;
import com.aixuexi.util.annotation.JSON;
import com.aixuexi.util.annotation.JSON2;
import com.aixuexi.util.annotation.JSONS;
import java.util.Map;
import javax.rmi.CORBA.Util;

import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by liuao on 2018/11/19.
 */
@Controller
@RequestMapping("")
public class Hello {

    @Autowired
    private UtilTest utilTest;
    @Autowired
    private LiuaoService liuaoService;
    @Value("${service.name}")
    public String serviceName;

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public List<User> getUser(Integer id, String name) {
        User user = new User();
//        throw new LiuaoException(ExceptionEnum.PARAMS_ERROR);
        return Lists.newArrayList(user);
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(MultipartFile[] uploadFile) throws IOException {
        for (int i = 0; i < uploadFile.length; i++) {
            InputStream inputStream = uploadFile[i].getInputStream();
            InputStreamReader inputreader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputreader);
            StringBuffer sb = new StringBuffer("");
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
            System.out.println(sb);
            reader.close();
            inputreader.close();
            inputStream.close();
        }

    }




}























