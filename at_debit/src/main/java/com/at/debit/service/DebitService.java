package com.at.debit.service;

import com.at.debit.entity.Debit;
import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.rm.tcc.api.BusinessActionContextParameter;

import java.math.BigDecimal;

public interface DebitService extends IService<Debit> {

    public void decrease(@BusinessActionContextParameter(paramName = "acctNo") String acctNo,
                         @BusinessActionContextParameter(paramName = "settleAcctNo") String settleAcctNo,
                         @BusinessActionContextParameter(paramName = "amt") BigDecimal amt,
                         @BusinessActionContextParameter(paramName = "clientNo") String clientNo,
                         @BusinessActionContextParameter(paramName = "settleClientNo") String settleClientNo);

}