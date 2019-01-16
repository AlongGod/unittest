package com.unittest.unittest.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xushuzn.common.bo.AbstractBO;
import com.xushuzn.common.dao.DAO;
import com.unittest.unittest.bo.ExpectResultBO;
import com.unittest.unittest.dao.ExpectResultDAO;
import com.unittest.unittest.model.ExpectResult;

@Service("expectResultBO")
public class DefaultExpectResultBO extends AbstractBO<ExpectResult, java.lang.String> implements ExpectResultBO {
    @Autowired
    private ExpectResultDAO expectResultDAO;

    @Override
    protected DAO<ExpectResult, java.lang.String> getDAO() {
        return expectResultDAO;
    }
}
