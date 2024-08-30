package Transaction;

import java.util.*; 

public class TransactionController {
    TransactionService transactionService;

    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    public TransactionDO makePayment(TransactionDO transaction) {
        return transactionService.makePayment(transaction);
    }

    public List<Transaction> getTransactionHistory(int userID) {
        return transactionService.getTransactionHistory(userID);
    }
} 
