package com.springapp.mvc.repository;


import com.springapp.mvc.modal.Member;
import org.springframework.dao.DataAccessException;

/**
 * Created by rdemarla on 30-Oct-15.
 **/
public interface MemberRepository
{
    void addMember(Member member) throws DataAccessException;
}
