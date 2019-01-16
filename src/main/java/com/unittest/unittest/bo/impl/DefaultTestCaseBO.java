package com.unittest.unittest.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xushuzn.common.bo.AbstractBO;
import com.xushuzn.common.dao.DAO;
import com.unittest.unittest.bo.TestCaseBO;
import com.unittest.unittest.dao.TestCaseDAO;
import com.unittest.unittest.model.TestCase;

@Service("testCaseBO")
public class DefaultTestCaseBO extends AbstractBO<TestCase, java.lang.String> implements TestCaseBO {
    @Autowired
    private TestCaseDAO testCaseDAO;

    @Override
    protected DAO<TestCase, java.lang.String> getDAO() {
        return testCaseDAO;
    }
}
