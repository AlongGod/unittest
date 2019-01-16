package com.unittest.unittest.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unittest.unittest.model.CompareResult;

import java.util.*;

public class StringUtil {

    public static boolean isNotEmpty(String input){
        return !isEmpty(input);
    }

    public static boolean isEmpty(String input){
        if (input == null || input.trim().equals("")){
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNumeric(String str)
    {
        return org.apache.commons.lang3.StringUtils.isNumeric(str);
    }

    public static  CompareResult compareJsonResult(String expect, String actual,Boolean isEqual){
        JSONArray expectJson = JSON.parseArray(expect);
        JSONArray actualJson = JSON.parseArray(actual);
        return compareJsonArray(expectJson,actualJson);
    }

    public static  CompareResult compareJsonArray(JSONArray expectJson, JSONArray actualJson){
        Boolean isEqual=true;
        Map<Integer, List<CompareResult>> compareResults =new HashMap<>();

        ListIterator<Object> expectJsonListIterator = expectJson.listIterator();
        ListIterator<Object> actualJsonListIterator = actualJson.listIterator();
        int i=0;
        while(expectJsonListIterator.hasNext()&&actualJsonListIterator.hasNext()){
            JSONObject expectJsonObject = (JSONObject)expectJsonListIterator.next();
            JSONObject actualJsonObject = (JSONObject)actualJsonListIterator.next();
            //对比
            List<CompareResult> compareResultList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : expectJsonObject.entrySet()) {
                String key = entry.getKey();
                Object expectValue = expectJsonObject.get(key);
                Object actualValue = actualJsonObject.get(key);

                CompareResult compareResult = new CompareResult();
                compareResult.setKey(key);
                if(expectValue==null&&actualValue==null){
                    compareResult.setEqual(true);
                }else if((expectValue==null&&actualValue!=null)||(expectValue!=null&&actualValue==null)){
                    compareResult.setExpect(expectValue==null?null:String.valueOf(expectValue));
                    compareResult.setActual(actualValue==null?null:String.valueOf(actualValue));
                    compareResult.setEqual(false);
                    isEqual=false;
                }else{
                    if(expectValue instanceof JSONArray && actualValue instanceof JSONArray){
                        compareResult=compareJsonArray((JSONArray)expectValue, (JSONArray)actualValue);
                        if(!compareResult.getEqual()){
                            isEqual=false;
                        }
                    }else{
                        compareResult.setExpect(String.valueOf(expectValue));
                        compareResult.setActual(String.valueOf(actualValue));
                        compareResult.setEqual(String.valueOf(expectValue).equals(String.valueOf(actualValue)));
                        if(!expectValue.equals(actualValue)){
                            isEqual=false;
                        }
                    }
                }
                compareResultList.add(compareResult);
            }
            compareResults.put(Integer.valueOf(i),compareResultList);
            i++;
        }

        while(expectJsonListIterator.hasNext()){
            List<CompareResult> compareResultList = new ArrayList<>();
            JSONObject expectJsonObject = (JSONObject)expectJsonListIterator.next();
            //对比
            for (Map.Entry<String, Object> entry : expectJsonObject.entrySet()) {
                String key = entry.getKey();
                Object expectValue = expectJsonObject.get(key);

                CompareResult compareResult = new CompareResult();
                compareResult.setKey(key);
                compareResult.setExpect(String.valueOf(expectValue));
                compareResult.setActual(null);
                compareResult.setEqual(false);
                isEqual = false;
                compareResultList.add(compareResult);
            }
            compareResults.put(Integer.valueOf(i),compareResultList);
            i++;
        }
        while(actualJsonListIterator.hasNext()){
            List<CompareResult> compareResultList = new ArrayList<>();
            JSONObject actualJsonObject = (JSONObject)actualJsonListIterator.next();
            //对比
            for (Map.Entry<String, Object> entry : actualJsonObject.entrySet()) {
                String key = entry.getKey();
                Object actualValue = actualJsonObject.get(key);

                CompareResult compareResult = new CompareResult();
                compareResult.setKey(key);
                compareResult.setActual(String.valueOf(actualValue));
                compareResult.setExpect(null);
                compareResult.setEqual(false);
                isEqual = false;
                compareResultList.add(compareResult);
            }
            compareResults.put(Integer.valueOf(i),compareResultList);
            i++;
        }
        CompareResult compareResult = new CompareResult();
        compareResult.setEqual(isEqual);
        compareResult.setChildCompareResults(compareResults);
        return compareResult;

    }
}
