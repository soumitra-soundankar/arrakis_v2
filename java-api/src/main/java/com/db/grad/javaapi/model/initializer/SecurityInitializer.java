package com.db.grad.javaapi.model.initializer;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

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
    //   Random r = new Random();
    //     // Sample data
    //   //   Security security1 = new Security("ISIN1", "CUSIP1", "Issuer A",
    //   //           new Date(), 2.5f, "Type A", 1000.0f, "Active");
    //   //   Security security2 = new Security("ISIN2", "CUSIP2", "Issuer B",
    //   //           new Date(), 3.0f, "Type B", 500.0f, "Inactive");
    //   //   Security security3 = new Security("ISIN3", "CUSIP3", "Issuer C",
    //   //           new Date(), 2.0f, "Type C", 800.0f, "Active");

    //   //   // Create and save Security entities
    //   //   securityRepository.save(security1);
    //   //   securityRepository.save(security2);
    //   //   securityRepository.save(security3);
    //     float coupons[] = {0.5f,1.0f,1.5f,2.0f,2.5f,3.0f,3.5f,4.0f};
    //     for(int i=1; i<=20; i++)
    //     {
    //         String status = ((i%5+1)%2 == 0) ? "Inactive" : "Active";
    //         float randomValue = 100.0f + (10000.0f - 100.0f) * r.nextFloat(); 
    //         Security security = new Security(("ISIN" + i), ("CUSIP"+i), ("Issuer " + (i%5+1)),
    //             LocalDate.now(), coupons[(i%10)%8], "Type " + (i%5+1), randomValue, status);
    //         securityRepository.save(security);
    //     }
     String fileName ="src/main/java/com/db/grad/javaapi/model/initializer/securities.txt"; // Name of the text file containing the dataset
    DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Format to two decimal places
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                String[] securityData = line.split(", ");
                // System.out.println(securityData);
                
                    int id = Integer.parseInt(securityData[0]);
                    String isin = securityData[1];
                    String cusip = securityData[2];
                    String issuer = securityData[3];
                    LocalDate maturityDate = LocalDate.parse(securityData[4]);

                    Float couponTemp = Float.parseFloat(securityData[5]);
                    
                    String formattedValue = decimalFormat.format(couponTemp);
                    float coupon = Float.parseFloat(formattedValue);
                    // System.out.println(coupon);
                    String type = securityData[6];

                    float faceValueTemp = Float.parseFloat(securityData[7]);
                    formattedValue = decimalFormat.format(faceValueTemp);
                    float faceValue = Float.parseFloat(formattedValue);
                    // System.out.println(faceValue);
                    String status = securityData[8];

                    // Assuming you have a Users class with appropriate constructor
                    Security security = new Security(isin,  cusip,  issuer,  maturityDate,  coupon,  type,  faceValue,  status);

                    // Assuming you have a UsersRepository interface extending JpaRepository
                    securityRepository.save(security);
                
            }
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // You can add more Security entities or modify the data as needed.
    }
}
