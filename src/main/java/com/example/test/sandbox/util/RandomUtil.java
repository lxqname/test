package com.example.test.sandbox.util;

import java.util.Random;

/**
 * 指定位数随机数
 *
 * @author 86151
 */
public class RandomUtil {
    public static String getRandom(int length) {

        StringBuilder val = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {

            val.append(random.nextInt(10));

        }
        return val.toString();
    }
}

