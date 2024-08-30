import Instrument.*;
import Transaction.*;
import User.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        TransactionController transactionController = new TransactionController();
        InstrumentController instrumentController = new InstrumentController();

        UserDO user1 = new UserDO();
        user1.setName("Arpit");
        user1.setEmail("arpit@gmail.com");
        UserDO user1details = userController.addUser(user1);

        UserDO user2 = new UserDO();
        user2.setName("Ankit");
        user2.setEmail("ankit@gmail.com");
        UserDO user2details = userController.addUser(user2);

        InstrumentDO user1Instrument = new InstrumentDO();
        user1Instrument.setBankAccountNumber("1234");
        user1Instrument.setIfscCode("SBI-IN0001");
        user1Instrument.setInstrumentType(InstrumentType.BANK);
        user1Instrument.setUserID(user1details.getUserID());
        InstrumentDO user1BankInstrument = instrumentController.addInstrument(user1Instrument);
        System.out.println("Bank Instrument created for user : " + user1details.getName());

        InstrumentDO user2Instrument = new InstrumentDO();
        user2Instrument.setCardNumber("1234-5678-2134-4567");
        user2Instrument.setUserID(user2details.getUserID());
        user2Instrument.setCvvNumber("342");
        user2Instrument.setInstrumentType(InstrumentType.CARD);
        InstrumentDO user2CardInstrument = instrumentController.addInstrument(user2Instrument);
        System.out.println("Card Instrument created for user : " + user2details.getName());

        TransactionDO transaction1 = new TransactionDO();
        transaction1.setAmount(20000);
        transaction1.setSenderUserID(user1details.getUserID());
        transaction1.setReceivingUserID(user2details.getUserID());
        transaction1.setCreditInstrumentID(user2CardInstrument.getInstrumentID());
        transaction1.setDebitInstrumentID(user1BankInstrument.getInstrumentID());
        
        transactionController.makePayment(transaction1);
        
        List<Transaction> user1Transactions = transactionController.getTransactionHistory(user1details.getUserID());
        System.out.println("Transaction made by " + user1details.getName());
        for (Transaction t: user1Transactions) {
            System.out.println("Sent to " + userController.getUser(t.getReceivingUserID()).getName() + ", amount = " + t.getAmount());
        }
        System.out.println();

        List<Transaction> user2Transactions = transactionController.getTransactionHistory(user2details.getUserID());
        System.out.println("Transaction made by " + user2details.getName());
        for (Transaction t: user2Transactions) {
            System.out.println("Received from " + userController.getUser(t.getSenderUserID()).getName() + ", amount = " + t.getAmount());
        }
    }
}