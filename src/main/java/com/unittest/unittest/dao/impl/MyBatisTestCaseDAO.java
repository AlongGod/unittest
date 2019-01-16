package com.unittest.unittest.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xushuzn.common.dao.AbstractDAO;
import com.unittest.unittest.dao.TestCaseDAO;
import com.unittest.unittest.model.TestCase;

@Repository("testCaseDAO")
public class MyBatisTestCaseDAO extends AbstractDAO<TestCase, java.lang.String> implements TestCaseDAO {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    protected String getNamespace() {
        return "testCaseDAO";
    }
}
