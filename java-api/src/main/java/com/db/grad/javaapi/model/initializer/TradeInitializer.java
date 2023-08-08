package com.db.grad.javaapi.model.initializer;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Counterparty;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.CounterpartyRepository;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.Date;

@Component
public class TradeInitializer implements CommandLineRunner {

    private final TradeRepository tradeRepository;
    private final BookRepository bookRepository;
    private final CounterpartyRepository counterpartyRepository;
    private final SecurityRepository securityRepository;

    @Autowired
    public TradeInitializer(TradeRepository tradeRepository,BookRepository bookRepository,
            CounterpartyRepository counterpartyRepository,
            SecurityRepository securityRepository) {
        this.tradeRepository = tradeRepository;
        this.bookRepository = bookRepository;
        this.counterpartyRepository = counterpartyRepository;
        this.securityRepository = securityRepository;
    }

    @Override
    public void run(String... args) {
        initializeTrades();
    }

    private void initializeTrades() {
        // Sample data
        // Book book1 = new Book("Book One");
        // Counterparty counterparty1 = new Counterparty("Counterparty A");
        // Security security1 = new Security("ISIN1", "CUSIP1", "Issuer X",
        //         new Date(), 2.0f, "Type X", 1000.0f, "Active");

        // Trade trade1 = new Trade(book1, counterparty1, security1, 100, "Pending", 120.0f, "Buy",
        //         new Date(), new Date());

        //Create and save Trade entities
        //tradeRepository.save(trade1);
    //   Random r = new Random();
   	//    float coupons[] = {0.5f,1.0f,1.5f,2.0f,2.5f,3.0f,3.5f,4.0f};
    //      for (int i=1; i<=15; i++)
    //      {
    //         Book book = new Book("Book "+i);
    //         bookRepository.save(book);
    //         String status = ((i%5+1)%2 == 0) ? "Inactive" : "Active";
    //         Counterparty counterparty = new Counterparty("Counterparty " + i);
    //         counterpartyRepository.save(counterparty);
    //         float randomValue = 100.0f + (10000.0f - 100.0f) * r.nextFloat(); 
            
    //         Security security = new Security("ISIN"+i, "CUSIP"+i, "Issuer " + (26-i),new Date(), coupons[(i%10)%8], "Type "+ (26-i), randomValue, status);
    //         securityRepository.save(security);
    //         String approval_Status = ((i%5+1)%3 == 0) ? "Approved" : "Pending";
    //         String buy_sell = ((i%4+1)%2 == 0) ? "Buy" : "Sell";
    //         randomValue = 100.0f + (10000.0f - 100.0f) * r.nextFloat();
    //         Trade trade = new Trade(book, counterparty, security, 100 + (10000 - 100) * r.nextInt(), approval_Status, randomValue, buy_sell, new Date(), new Date());

    //         // Create and save Trade entities
    //         tradeRepository.save(trade);
            
    //      }
        // You can add more Trade entities or modify the data as needed.
    }
}
