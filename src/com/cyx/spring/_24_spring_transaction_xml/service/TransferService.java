package com.cyx.spring._24_spring_transaction_xml.service;

public interface TransferService {

    /**
     * 转账操作
     *
     * @param outMemberId 转出用户 id
     * @param inMemberId 转入用户 id
     * @param money 转账金额
     */
    void transfer(Long outMemberId, Long inMemberId, Integer money);

}
