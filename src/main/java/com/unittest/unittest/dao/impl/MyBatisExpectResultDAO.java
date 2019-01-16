package com.unittest.unittest.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xushuzn.common.dao.AbstractDAO;
import com.unittest.unittest.dao.ExpectResultDAO;
import com.unittest.unittest.model.ExpectResult;

@Repository("expectResultDAO")
public class MyBatisExpectResultDAO extends AbstractDAO<ExpectResult, java.lang.String> implements ExpectResultDAO {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    protected String getNamespace() {
        return "expectResultDAO";
    }
}
