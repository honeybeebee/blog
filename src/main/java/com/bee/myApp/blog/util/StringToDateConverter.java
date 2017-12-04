package com.bee.myApp.blog.util;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xlfxu
 * @create 2017-09-30 0:13
 */
public class StringToDateConverter implements Converter<String, Date> {
    private static String[] pattern = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd"};
    @Override
    public Date convert(String source) {
        try {
            for (String pat : pattern) {
                if(pat.length() == source.length()){
                    SimpleDateFormat format = new SimpleDateFormat(pat);
                    return format.parse(source);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
