package com.db.grad.javaapi.model.initializer;

import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.repository.CounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CounterpartyInitializer implements CommandLineRunner {

    private final CounterpartyRepository counterpartyRepository;

    @Autowired
    public CounterpartyInitializer(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    @Override
    public void run(String... args) {
        initializeCounterparties();
    }

    private void initializeCounterparties() {
        // Sample data

         for(int i=1; i<=40; i++)
         {
            String counterPartyName = "CounterParty " + i;
            Counterparty counterparty = new Counterparty(counterPartyName);
            counterpartyRepository.save(counterparty);
         }
    }
}
