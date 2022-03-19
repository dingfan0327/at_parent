package com.at.bussiness.service.impl;

import com.at.bussiness.feign.CreditServiceFeign;
import com.at.bussiness.feign.DebitServiceFeign;
import com.at.bussiness.service.BussinessService;
import com.at.bussiness.utils.IdWorker;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 业务逻辑
 */
@Service
public class BussinessServiceImpl implements BussinessService {

    @Autowired
    CreditServiceFeign creditServiceFeign;
    @Autowired
    DebitServiceFeign debitServiceFeign;

    @Autowired
    IdWorker idWorker;

    /**
     * 定期支取
     *
     * @param acctNo   账号
     * @param amt      支取金额
     * @param clientNo 客户号
     */
    @GlobalTransactional(name = "withdrawal", timeoutMills = 100000, rollbackFor = Exception.class)
    public void withdrawal(String acctNo, String settleAcctNo,
                           BigDecimal amt, String clientNo, String settleClientNo) {
        //交易流水
        long refrence = idWorker.nextId();

        //先借记事件
        debitServiceFeign.decrease(refrence, acctNo, settleAcctNo, amt, clientNo, settleClientNo);
        //后贷记事件
        creditServiceFeign.increase(refrence, acctNo, settleAcctNo, amt, clientNo, settleClientNo);

    }


}
