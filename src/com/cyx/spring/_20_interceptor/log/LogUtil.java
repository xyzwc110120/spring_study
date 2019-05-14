package com.cyx.spring._20_interceptor.log;

import java.util.Date;

public class LogUtil {

    public void writeLog(String className, String methodName) {
        System.out.println(new Date() + " 调用了 " + className + " 类中的 " + methodName + " 方法");
    }
}
