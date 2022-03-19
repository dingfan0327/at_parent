package com.at.credit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.at.credit.entity.Credit;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import java.math.BigDecimal;


public interface CreditService extends IService<Credit> {

    public void increase(@BusinessActionContextParameter(paramName = "acctNo")String acctNo,
                         @BusinessActionContextParameter(paramName = "settleAcctNo") String settleAcctNo,
                         @BusinessActionContextParameter(paramName = "amt") BigDecimal amt,
                         @BusinessActionContextParameter(paramName = "clientNo") String clientNo,
                         @BusinessActionContextParameter(paramName = "settleClientNo") String settleClientNo);

}