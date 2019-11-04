package com.aixuexi.controller;

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
        String html = "<div class=\"axx_piece\">\n" +
                "      <p>\n" +
                "        <span lang=\"zh-CN\" style=\"\">如图，</span>\n" +
                "        <span style=\"\">\\[\\angle 1=\\]</span>\n" +
                "        <span style=\"\">50</span>\n" +
                "        <span lang=\"zh-CN\" style=\"\">°，</span>\n" +
                "        <span style=\"\">\\[\\angle 2=\\]</span>\n" +
                "        <span style=\"\">60</span>\n" +
                "        <span lang=\"zh-CN\" style=\"\">°，</span>\n" +
                "        <span style=\"position:relative;top:3pt;\">\\[\\angle 3=\\]</span>\n" +
                "        <span style=\"\">30</span>\n" +
                "        <span lang=\"zh-CN\" style=\"\">°，</span>\n" +
                "        <span style=\"\">\\[\\angle 4=\\]</span>\n" +
                "        <span style=\"\">60</span>\n" +
                "        <span lang=\"zh-CN\" style=\"\">°，那么，</span>\n" +
                "        <span style=\"\">\\[\\angle 5\\]</span>\n" +
                "        <span lang=\"zh-CN\" style=\"\">等于</span>\n" +
                "        <span style=\"\">________</span>\n" +
                "        <span lang=\"zh-CN\" style=\"\">度．</span>\n" +
                "        <span style=\"\">\n" +
                "          </span>\n" +
                "        <span style=\"\">\n" +
                "          <img class=\"axx_inlineimage\" src=\"http://tiku-static.aixuexi.com//IMP20170810/88ea621e7baf4f3eb379dc84902c36b7/content/content.files/image1.png?i=636379987406456981\" style=\"width: 111.15pt; height: 81.25pt\" alt=\"aixuexiimg6,\" />\n" +
                "        </span>\n" +
                "      </p>\n" +
                "    </div>";
        Document doc = Jsoup.parseBodyFragment(html);
        List<Node> list = doc.body().getAllElements().get(0).childNodes();
        recursiveRemoveStyle(list);

        String retHtml = doc.body().html();
//        retHtml = retHtml.replaceAll("<html>\n","");
//        retHtml = retHtml.replaceAll("\n</html>","");
//        retHtml = retHtml.replaceAll("<head>","");
//        retHtml = retHtml.replaceAll("</head>\n","");
//        retHtml = retHtml.replaceAll("<body>\n","");
//        retHtml = retHtml.replaceAll("\n</body>","");
        System.out.println(retHtml);
        return new User();
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























