package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

//TODO find a way to implement the transaction class into the purchase
// process in order to record each instance of a transaction into the log

public class Transaction{
    Clock clock = new Clock() {
        @Override
        public ZoneId getZone() {
            return null;
        }

        @Override
        public Clock withZone(ZoneId zone) {
            return null;
        }

        @Override
        public Instant instant() {
            return null;
        }

        public BigDecimal balance = BigDecimal.valueOf(0.0);

        public BigDecimal deposit(BigDecimal amount) {
            commitChangeToLog("FEED MONEY", amount);
            return balance;
        }

        public BigDecimal purchase(Product item) {
            String description = item.getName() + " " + item.getSlotIdentifier();
            commitChangeToLog(description, item.getPrice().multiply(BigDecimal.valueOf(-1)));

            return balance;
        }

        public BigDecimal withdraw() {
            BigDecimal cash = balance;
            commitChangeToLog("GIVE CHANGE", balance.multiply(BigDecimal.valueOf(-1)));
            return cash;
        }


        public BigDecimal getBalance() {
            return balance;
        }

        private void writeToLog(String action) {
            File purchaseLog = new File("log.txt");
            try {
                FileWriter writer = new FileWriter(purchaseLog, true);
                writer.write(action);
                writer.close();
            } catch (Exception e) {
                System.out.println("File not found");
            }


        }

        private void commitChangeToLog(String description, BigDecimal amountToChange) {
            String oldBalance = String.valueOf(balance);
            balance = balance.add(amountToChange);
            String newBalance = String.valueOf(balance);
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String currentDate = dateFormat.format(new Date());
            String completedLog = currentDate + " " + clock.instant() + " " + description + " " +
                    oldBalance + " " + newBalance;
            writeToLog(completedLog);
        }


    };
}