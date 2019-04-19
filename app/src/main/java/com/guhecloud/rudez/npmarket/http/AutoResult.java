package com.guhecloud.rudez.npmarket.http;

/**
 * Created by homework on 2019/4/16.
 */

public class AutoResult<T> {
    public final static int SUCCESS=200;
    public int code;
    public String msg;
    public T data;
}
