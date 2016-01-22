package com.springapp.mvc.repository.jdbc;

import com.springapp.mvc.modal.Member;
import com.springapp.mvc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

/**
 * Created by rdemarla on 30-Oct-15.
 **/
public class JDBCMemberRepoImpl implements MemberRepository {

    private SimpleJdbcInsert insertMember;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JDBCMemberRepoImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        insertMember = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addMember(Member member) throws DataAccessException {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(member);
        if (member.isNew()) {
            Number newKey = insertMember.executeAndReturnKey(parameterSource);
            member.setId(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                    "UPDATE member SET first_name=:firstName, last_name=:lastName, image_path=:imagePath, " +
                            "role=:role, gender=:gender, email=:email, transaction_date=:transactionDate WHERE id=:id",
                    parameterSource);
        }
    }
}