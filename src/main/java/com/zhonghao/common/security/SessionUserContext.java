package com.zhonghao.common.security;

public class SessionUserContext {

    private static ThreadLocal<IUser> users = new ThreadLocal<>();

    static void put(IUser user) {
        users.set(user);
    }

    public static IUser get() {
        return users.get();
    }
}
