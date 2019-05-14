package com.cyx.spring._26_spring_java_config.service;

public interface TransferService {

    /**
     * 转账操作
     *
     * @param outMemberId 转出用户 id
     * @param inMemberId 转入用户 id
     * @param money 转账金额
     */
    void transfer(Long outMemberId, Long inMemberId, Integer money);

    /**
     * 模拟一个查询方法，将其的事务设置为只读类型
     */
    void getXxx();

}
