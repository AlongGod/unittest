package com.xushuzn.common.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AbstractPO implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private List<ExpressionChain> expressionChainList;
    @JsonIgnore
    private Set<String> forceUpdateProperties;
    @JsonIgnore
    private Map<String, Object> incrementUpdateMap;

    public AbstractPO() {
        expressionChainList = new ArrayList<ExpressionChain>();
        forceUpdateProperties = new HashSet<String>();
        incrementUpdateMap = new LinkedHashMap<String, Object>();
    }

    public void or(ExpressionChain expressionChain) {
        expressionChainList.add(expressionChain);
    }

    public <T> void or(Expression<T> expression) {
        expressionChainList.add(new ExpressionChain().and(expression));
    }

    public <T> void and(Expression<T> expression) {
        if (expressionChainList.isEmpty()) {
            expressionChainList.add(new ExpressionChain());
        }
        expressionChainList.get(0).and(expression);
    }

    protected void addForceUpdateProperty(String property) {
        if (!forceUpdateProperties.contains(property)) {
            forceUpdateProperties.add(property);
        }
    }

    public void increment(String property, Object value) {
        String column = DAOUtils.toColumnName(property);

        if (!incrementUpdateMap.containsKey(column)) {
            incrementUpdateMap.put(column, value);
        }
    }

    public List<ExpressionChain> getExpressionChainList() {
        return expressionChainList;
    }

    public void setExpressionChainList(List<ExpressionChain> expressionChainList) {
        this.expressionChainList = expressionChainList;
    }

    public Set<String> getForceUpdateProperties() {
        return forceUpdateProperties;
    }

    public void setForceUpdateProperties(Set<String> forceUpdateProperties) {
        this.forceUpdateProperties = forceUpdateProperties;
    }

    public Map<String, Object> getIncrementUpdateMap() {
        return incrementUpdateMap;
    }

    public void setIncrementUpdateMap(Map<String, Object> incrementUpdateMap) {
        this.incrementUpdateMap = incrementUpdateMap;
    }
}
