package Instrument;

public class InstrumentServiceFactory {
    public InstrumentService getInstrumentService(InstrumentType instrumentType) {
        switch (instrumentType) {
            case CARD:
                return new CardService();
            case BANK:
                return new BankService();
            default:
                System.out.println("Invalid instrument type " + instrumentType);
                return null;
        }
    }
}
