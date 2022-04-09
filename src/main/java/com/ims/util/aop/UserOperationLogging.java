package com.ims.util.aop;

import com.ims.dao.ActionRecordMapper;
import com.ims.domain.ActionRecord;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;


public class UserOperationLogging {

    @Autowired
    ActionRecordMapper actionRecordMapper;

    public void logging(JoinPoint joinPoint, UserOperation userOperation){
        ActionRecord actionRecord = new ActionRecord();
        System.out.println(joinPoint.toString());
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
//        if(!methodName.startsWith("_")){
//            Double time = (double) System.currentTimeMillis();
//            Subject subject = SecurityUtils.getSubject();
//            Session session = subject.getSession();
//            actionRecord.setUserId(Integer.valueOf((String) session.getAttribute("userId")));
//            actionRecord.setUsername((String) session.getAttribute("username"));
//            actionRecord.setTime(time);
//            actionRecord.setActionName(methodName);
//            System.out.println(actionRecord);
//            actionRecordMapper.insertRecord(actionRecord);
//        }
//        else{
//            System.out.println("null");
//        }
    }
}
