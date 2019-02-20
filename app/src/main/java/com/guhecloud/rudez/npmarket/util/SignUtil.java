package com.guhecloud.rudez.npmarket.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Chanin on 2017-11-06.
 */

public class SignUtil {


    public static String signParams(Map<String, String[]> maps){
        maps.remove("sign");
        TreeMap<String, String[]> treeMap = new TreeMap<>(maps);
        Iterator<Map.Entry<String, String[]>> iterator = treeMap.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> next = iterator.next();
            String[] value = next.getValue();
            if(value!=null&&value.length>0){
                int length = value.length;
                for (int i = 0; i < length; i++) {
                    sb.append(next.getKey()).append(value[i]);
                }
            }else {
                sb.append(next.getKey()).append(value);
            }
        }
        return md5(sb.toString());


    }

    public static String signParams(HashMap<String, String> maps) {
        maps.remove("sign");
        TreeMap<String, String> treeMap = new TreeMap<>(maps);
        Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sb.append(next.getKey()).append(next.getValue());
        }
        return md5(sb.toString());
    }

    private static String md5(String s) {
        return EncryptUtils.encryptMD5ToString(s);
    }

//NiPVlqzY+mO2esOFocuvWA==

    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("token","");
        map.put("rndo", "1509937286570");
        map.put("stId","");





        String s = signParams(map);
        System.out.println(s);
    }


}
