package com.unittest.unittest.model;

import java.util.List;
import java.util.Map;

public class CompareResult implements java.io.Serializable{


    private static final long serialVersionUID = 1L;
    private String key;
    private String expect;
    private String actual;

    private Boolean isEqual;

    private Map<Integer, List<CompareResult>> childCompareResults;

    public Map<Integer,  List<CompareResult>> getChildCompareResults() {
        return childCompareResults;
    }

    public void setChildCompareResults(Map<Integer,  List<CompareResult>> childCompareResults) {
        this.childCompareResults = childCompareResults;
    }

    public Boolean getEqual() {
        return isEqual;
    }

    public void setEqual(Boolean equal) {
        isEqual = equal;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }
}
