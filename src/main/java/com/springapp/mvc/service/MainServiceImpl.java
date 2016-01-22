package com.springapp.mvc.service;

import com.springapp.mvc.modal.Member;
import com.springapp.mvc.modal.UserRoles;
import com.springapp.mvc.modal.Users;
import com.springapp.mvc.repository.MemberRepository;
import com.springapp.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by rdemarla on 30-Oct-15.
 **/

@Service
public class MainServiceImpl implements MainService
{
    private MemberRepository memberRepository;
    private UserRepository userRepository;

    @Autowired
    public MainServiceImpl(MemberRepository memberRepo, UserRepository userRepo)
    {
        this.memberRepository = memberRepo;
        this.userRepository = userRepo;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addMember(Member member) {
        member.setTransactionDate(new Date());
        if(member.getAddress() != null)
            member.getAddress().setTransactionDate(new Date());

        memberRepository.addMember(member);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public boolean isUserAvailable(Users users) {
        return false;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addUser(UserRoles userRoles) {
        userRepository.addUser(userRoles);
    }
}
