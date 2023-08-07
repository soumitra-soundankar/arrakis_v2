package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public Trade getTradeById(long id) throws ResourceNotFoundException {
        return tradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Trade with ID = " + id));
    }
}
