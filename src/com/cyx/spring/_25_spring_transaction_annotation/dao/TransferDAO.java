package com.cyx.spring._25_spring_transaction_annotation.dao;

public interface TransferDAO {

    /**
     * 转出
     *
     * @param memberId 用户 id
     * @param money 转出金额
     */
    void transferOut(Long memberId, Integer money);

    /**
     * 转入
     *
     * @param memberId 用户 id
     * @param money 转入金额
     */
    void transferIn(Long memberId, Integer money);

}
