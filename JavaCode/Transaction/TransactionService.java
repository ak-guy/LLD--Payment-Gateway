package Transaction;

import java.util.*;

import Instrument.InstrumentController;
import Instrument.InstrumentDO;

public class TransactionService {
    public static Map<Integer, List<Transaction>> userVsTransaction;
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        this.instrumentController = new InstrumentController();
        this.processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userID) {
        return userVsTransaction.get(userID);
    }

    public TransactionDO makePayment(TransactionDO transaction) {
        InstrumentDO senderInstrumentDO = instrumentController.getInstrumentByID(transaction.getSenderUserID(), transaction.getDebitInstrumentID());
        InstrumentDO receiverInstrumentDO = instrumentController.getInstrumentByID(transaction.getReceivingUserID(), transaction.getCreditInstrumentID());
        processor.makePayment(senderInstrumentDO, receiverInstrumentDO);

        Transaction txn = new Transaction();
        txn.setAmount(transaction.getAmount());
        txn.setSenderUserID(transaction.getSenderUserID());
        txn.setReceivingUserID(transaction.getReceivingUserID());
        txn.setTransactionID(new Random().nextInt(90) + 10);
        txn.setDebitInstrumentID(transaction.getDebitInstrumentID());
        txn.setCreditInstrumentID(transaction.getCreditInstrumentID());
        txn.setTransactionStatus(TransactionStatus.COMPLETED);

        List<Transaction> senderTransactions = userVsTransaction.get(txn.getSenderUserID());
        if (senderTransactions == null) {
            senderTransactions = new ArrayList<>();
            userVsTransaction.put(txn.getSenderUserID(), senderTransactions);
        } 
        senderTransactions.add(txn);

        List<Transaction> receiverTransactions = userVsTransaction.get(txn.getReceivingUserID());
        if (receiverTransactions == null) {
            receiverTransactions = new ArrayList<>();
            userVsTransaction.put(txn.getReceivingUserID(), receiverTransactions);
        } 
        receiverTransactions.add(txn);

        transaction.setTransactionStatus(txn.getTransactionStatus());
        transaction.setTransactionID(txn.getTransactionID());
        return transaction;
    }
}
