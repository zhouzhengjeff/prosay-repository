package com.prosay.oa.web.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class CustomDateConverter implements Converter<String, Date> {

    private String[] patterns;

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }

    @Override
    public Date convert(String s) {
        Date date = null;

        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException("");
        }

        try {
            date = DateUtils.parseDate(s, this.patterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
