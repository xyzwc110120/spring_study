package com.cyx.spring._24_spring_transaction_xml.service.impl;

import com.cyx.spring._24_spring_transaction_xml.dao.TransferDAO;
import com.cyx.spring._24_spring_transaction_xml.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferDAO transferDAO;

    @Autowired
    public TransferServiceImpl(TransferDAO transferDAO) {
        this.transferDAO = transferDAO;
    }

    @Override
    public void transfer(Long outMemberId, Long inMemberId, Integer money) {
        transferDAO.transferOut(outMemberId, money);
        // 制造异常，使方法中断，此时转出操作执行了，而转入操作没有执行，转账就会出现问题
        int i = 1 / 0;
        transferDAO.transferIn(inMemberId, money);
    }
}
