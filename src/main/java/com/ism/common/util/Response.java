package com.ism.common.util;

import com.alibaba.fastjson.JSONObject;

public class Response {

    JSONObject result;
    public Response(){
        result = new JSONObject();
    }

    public static Response generateResponse(){
        return new Response();
    }

    public void setData(String data){
        result.put("data", data);
    }

    public void setResult(String result){
        this.result.put("result", result);
    }

    public void setLength(Integer length){
        result.put("length", length);
    }

    public void success(){
        setResult("成功");
    }

    public void failure(){
        setResult("失败");
    }

    public String toJSONString(){
        return result.toJSONString();
    }



}
