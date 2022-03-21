package com.at.debit.service.impl;


import com.at.debit.mapper.DebitMapper;
import com.at.debit.entity.Debit;
import com.at.debit.service.DebitService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 贷记服务
 */
@Slf4j
@Service
public class DebitServiceImpl extends ServiceImpl<DebitMapper, Debit> implements DebitService {

    /**
     * 定期支取借记事件
     *
     * @param acctNo       账户
     * @param settleAcctNo 结算账号
     * @param tranAmt      交易金额
     * @param clientNo     客户号
     * @return
     */
    public void decrease(String acctNo, String settleAcctNo, BigDecimal tranAmt, String clientNo,
                         String settleClientNo) {
        QueryWrapper<Debit> wrapper = new QueryWrapper<Debit>();
        wrapper.lambda().eq(Debit::getAcctNo, acctNo);
        wrapper.lambda().eq(Debit::getClientNo, clientNo);
        Debit userDebit = this.getOne(wrapper);
        if (userDebit == null) {
            throw new RuntimeException("账户不存在，或已经销户！");
        }
        userDebit.setAmt(userDebit.getAmt().subtract(tranAmt));
        this.saveOrUpdate(userDebit);
    }

}