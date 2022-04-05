package com.ims.common.util;

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

    public void exception(String result){
        failure();
        setData(result);
    }

    public static String _exception(String result){
        Response response = generateResponse();
        response.failure();
        response.setData(result);
        return response.toJSONString();
    }

    public static String _default(){
        Response response = Response.generateResponse();
        response.failure();
        response.setData("参数错误");
        return response.toJSONString();
    }

    public String toJSONString(){
        return result.toJSONString();
    }



}
