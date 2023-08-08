package com.db.grad.javaapi.model.initializer;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
import java.time.LocalDate;

@Component
public class SecurityInitializer implements CommandLineRunner {

    private final SecurityRepository securityRepository;

    @Autowired
    public SecurityInitializer(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Override
    public void run(String... args) {
        initializeSecurities();
    }

    private void initializeSecurities() {
      Random r = new Random();
        // Sample data
      //   Security security1 = new Security("ISIN1", "CUSIP1", "Issuer A",
      //           new Date(), 2.5f, "Type A", 1000.0f, "Active");
      //   Security security2 = new Security("ISIN2", "CUSIP2", "Issuer B",
      //           new Date(), 3.0f, "Type B", 500.0f, "Inactive");
      //   Security security3 = new Security("ISIN3", "CUSIP3", "Issuer C",
      //           new Date(), 2.0f, "Type C", 800.0f, "Active");

      //   // Create and save Security entities
      //   securityRepository.save(security1);
      //   securityRepository.save(security2);
      //   securityRepository.save(security3);
        float coupons[] = {0.5f,1.0f,1.5f,2.0f,2.5f,3.0f,3.5f,4.0f};
        for(int i=1; i<=20; i++)
        {
            String status = ((i%5+1)%2 == 0) ? "Inactive" : "Active";
            float randomValue = 100.0f + (10000.0f - 100.0f) * r.nextFloat(); 
            Security security = new Security(("ISIN" + i), ("CUSIP"+i), ("Issuer " + (i%5+1)),
                LocalDate.now(), coupons[(i%10)%8], "Type " + (i%5+1), randomValue, status);
            securityRepository.save(security);
        }

        // You can add more Security entities or modify the data as needed.
    }
}
