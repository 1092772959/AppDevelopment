package com.myapp.demo.tool;

import com.myapp.demo.model.*;

import java.util.List;

import static com.myapp.demo.model.ResultCode.fail;
import static com.myapp.demo.model.ResultCode.success;

/**
 * @program: demo
 * @description: 返回数据类型
 * @author: ydc
 * @create: 2019-04-25 13:59
 **/
public class ResultTool {
    public static Result<List<Object>> success(List<Object> object){
        Result<List<Object>> result = new Result<>();
        result.setStatus(success);
        result.setData(object);
        return result;
    }

    public static Result<Object> success(Object object){
        Result<Object> result = new Result<>();
        result.setStatus(success);
        result.setData(object);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setStatus(success);
        result.setData(null);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setStatus(fail);
        result.setData(null);
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(fail);
        result.setData(null);
        return result;
    }
}
