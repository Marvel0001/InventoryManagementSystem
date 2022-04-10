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

    public void logging(JoinPoint joinPoint){
        ActionRecord actionRecord = new ActionRecord();
        String methodName = joinPoint.getSignature().getName();
        if(!methodName.startsWith("_")){
            Long time = System.currentTimeMillis();
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            actionRecord.setUserId(Integer.valueOf(String.valueOf(session.getAttribute("userId"))));
            actionRecord.setUsername((String) session.getAttribute("username"));
            actionRecord.setTime(time);
            actionRecord.setActionName(methodName);
            actionRecordMapper.insertRecord(actionRecord);
        }
    }
}
