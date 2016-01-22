package com.springapp.mvc.web;

import com.springapp.mvc.modal.Member;
import com.springapp.mvc.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rdemarla on 30-Oct-15.
 **/

@Controller
//@RequestMapping("/members")
public class MemberController
{
    private final MainService mainService;

    @Autowired
    public MemberController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping("/members-view")
    public String getMemberPage()
    {
        return "components/members/members-view";
    }

    @Transactional
    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public void addMember(@RequestBody Member member)
    {
        mainService.addMember(member);
    }
}
