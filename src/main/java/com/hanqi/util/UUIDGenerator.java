package com.hanqi.util;

import java.util.UUID;

public class UUIDGenerator {

    public UUIDGenerator() {
    }

    /**
     * 获得一个UUID
     *
     * @return StringUUID
     */
    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        // 去掉“-”符号
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
                + s.substring(19, 23) + s.substring(24);
    }

    /**
     * 获得一个16位大写UUID
     *
     * @return StringUUID
     */
    public static String getShortUUID() {
        String s = UUID.randomUUID().toString();
        // 去掉“-”符号
        return (s.substring(0, 8) + s.substring(9, 13) + s.substring(19, 23))
                .toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
        System.out.println(getShortUUID());
    }
}
