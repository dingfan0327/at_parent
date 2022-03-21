package com.at.credit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.at.credit.entity.Credit;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;

import java.math.BigDecimal;


public interface CreditService extends IService<Credit> {

    /**
     * @TwoPhaseBusinessAction 描述⼆阶段提交
     * name: 为  tcc⽅法的  bean 名称，需要全局唯⼀，⼀般写⽅法名即可
     * commitMethod: Commit⽅法的⽅法名
     * rollbackMethod:Rollback⽅法的⽅法名
     * @BusinessActionContextParamete 该注解⽤来修饰  Try⽅法的⼊参，
     * 被修饰的⼊参可以在  Commit ⽅法和  Rollback ⽅法中通过
     * BusinessActionContext 获取。
     */
    public void increase(@BusinessActionContextParameter(paramName = "acctNo") String acctNo,
                         @BusinessActionContextParameter(paramName = "settleAcctNo") String settleAcctNo,
                         @BusinessActionContextParameter(paramName = "amt") BigDecimal amt,
                         @BusinessActionContextParameter(paramName = "clientNo") String clientNo,
                         @BusinessActionContextParameter(paramName = "settleClientNo") String settleClientNo);

}