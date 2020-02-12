package com.glsx.vasp.modules.repository;

import com.glsx.vasp.base.BaseRepository;
import com.glsx.vasp.modules.entity.TradingFlow;

import java.io.Serializable;

public interface ITradingFlowDao extends BaseRepository<TradingFlow, Long>, Serializable {

    TradingFlow findByFlowNo(String flowNo);

}
