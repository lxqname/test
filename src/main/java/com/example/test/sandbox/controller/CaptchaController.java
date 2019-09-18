package com.example.test.sandbox.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * 登入验证码的接口
 *
 * @author liuxinquan
 */
@RestController
public class CaptchaController {
    /**
     * 随机字符字典
     */
    private static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * 随机数
     */
    private static Random random = new Random();

    /**
     * 获取4位随机数
     *
     * @return
     */
    private static String getRandomString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    /**
     * 前段获取验证码展示
     *
     * @return
     */
    @PostMapping("/getCaptcha")
    public String getCaptcha(HttpSession session) {
        //生成的验证码
        String randomString = getRandomString();
        session.setAttribute("captcha", randomString.toUpperCase());
        return randomString;
    }

    /**
     * 判断填写的验证码与显示的验证码是否相同（不区分大小写）
     * @param captcha
     * @param session
     * @return
     */
    @PostMapping("/checkCaptcha")
    public String checkCaptcha(String captcha, HttpSession session) {
        String a="captcha";
        if (!session.getAttribute(a).equals(captcha.toUpperCase())) {
            return "验证码不正确";
        }
        return "验证码通过";
    }
}
