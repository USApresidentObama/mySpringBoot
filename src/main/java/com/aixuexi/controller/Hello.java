package com.aixuexi.controller;

import com.aixuexi.model.EnumColor;
import com.aixuexi.model.Role;
import com.aixuexi.model.User;
import com.aixuexi.util.annotation.JSON;
import com.aixuexi.util.annotation.JSON2;
import com.aixuexi.util.annotation.JSONS;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuao on 2018/11/19.
 */
@Controller
@RequestMapping("")
public class Hello {


    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setAge(2);
        user.setName("liuao");
        user.setEnumColor(EnumColor.RED);
        return user;
    }

    private void recursiveRemoveStyle(List<Node> nodes) {
        if (nodes != null && nodes.size() > 0) {
            for (Node node : nodes) {
                if (node.childNodes().size() == 1) {
                    String text = node.toString();
                    if (text.contains("[") || text.contains("]") || text.contains("$")) {
                        String style = node.attr("style");
                        if (style.contains("position") || style.contains("top") || style.contains("relative")) {
                            node.removeAttr("style");
                        }
                    }
                }
                recursiveRemoveStyle(node.childNodes());
            }
        }
    }


}























