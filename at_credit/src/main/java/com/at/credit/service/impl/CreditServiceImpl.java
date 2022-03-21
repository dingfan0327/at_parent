package com.at.credit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.at.credit.entity.Credit;
import com.at.credit.mapper.CreditMapper;
import com.at.credit.service.CreditService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 贷记服务
 */
@Slf4j
@Service
public class CreditServiceImpl extends ServiceImpl<CreditMapper, Credit> implements CreditService {

    /**
     * 定期支取贷记事件
     *
     * @param acctNo       ⽤户名
     * @param settleAcctNo 结算账户
     * @param tranAmt      交易金额
     * @param clientNo     客户号
     * @return
     */
    public void increase(String acctNo, String settleAcctNo, BigDecimal tranAmt, String clientNo, String settleClientNo) {
        //随机事件，检查账户是否账户限制
        QueryWrapper<Credit> wrapper = new QueryWrapper<Credit>();
        wrapper.lambda().eq(Credit::getAcctNo, settleAcctNo);
        wrapper.lambda().eq(Credit::getClientNo, settleClientNo);
        Credit userCredit = this.getOne(wrapper);
        if (userCredit == null) {
            throw new RuntimeException("账户不存在，或已经销户！");
        }
        userCredit.setAmt(userCredit.getAmt().add(tranAmt));
        this.saveOrUpdate(userCredit);
    }

}
