package com.cyx.spring._24_spring_transaction_xml;

import com.cyx.spring._24_spring_transaction_xml.service.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class TransferTest {

    @Autowired
    private TransferService transferService;

    @Test
    @DisplayName("模拟转账")
    void testTransfer() {
        transferService.transfer(11L, 9L, 50);
    }

}
