package Transaction;

public class Transaction {
    int transactionID;
    int amount;
    int senderUserID;
    int receivingUserID;
    int debitInstrumentID;
    int creditInstrumentID;
    TransactionStatus transactionStatus;

    public int getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getSenderUserID() {
        return senderUserID;
    }
    public void setSenderUserID(int senderUserID) {
        this.senderUserID = senderUserID;
    }
    public int getReceivingUserID() {
        return receivingUserID;
    }
    public void setReceivingUserID(int receivingUserID) {
        this.receivingUserID = receivingUserID;
    }
    public int getDebitInstrumentID() {
        return debitInstrumentID;
    }
    public void setDebitInstrumentID(int debitInstrumentID) {
        this.debitInstrumentID = debitInstrumentID;
    }
    public int getCreditInstrumentID() {
        return creditInstrumentID;
    }
    public void setCreditInstrumentID(int creditInstrumentID) {
        this.creditInstrumentID = creditInstrumentID;
    }
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }
    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

}
