package com.glsx.vasp.eshop.modules.trading.service;

import com.glsx.vasp.modules.entity.TradingFlow;
import com.glsx.vasp.modules.repository.ITradingFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 交易服务
 */
@Service
public class TradingService {

    @Autowired
    private ITradingFlowRepository repository;

    public void save(TradingFlow tradingFlow) {
        repository.save(tradingFlow);
    }

    public TradingFlow findByFlowNo(String flowNo) {
        return repository.findByFlowNo(flowNo);
    }

}
