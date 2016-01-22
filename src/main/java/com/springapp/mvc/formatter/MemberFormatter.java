package com.springapp.mvc.formatter;

import com.springapp.mvc.modal.Member;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by rdemarla on 28-Oct-15.
 **/
public class MemberFormatter implements Formatter<Member>
{

    @Override
    public Member parse(String s, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Member member, Locale locale) {
        return null;
    }
}
