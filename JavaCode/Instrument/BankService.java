package Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService {
    
    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.setAccountNumber(instrumentDO.getBankAccountNumber());
        bankInstrument.setIfscCode(instrumentDO.getIfscCode());
        bankInstrument.setInstrumentID(new Random().nextInt(100-10) + 10);
        bankInstrument.setInstrumentType(instrumentDO.getInstrumentType());
        bankInstrument.setUserID(instrumentDO.getUserID());

        if (!usersVsInstrument.containsKey(bankInstrument.getUserID())) {
            List<Instrument> instrumentsList = new ArrayList<>();
            instrumentsList.add(bankInstrument);
            usersVsInstrument.put(bankInstrument.getUserID(), instrumentsList);
        } else {
            List<Instrument> instrumentsList = usersVsInstrument.get(bankInstrument.getUserID());
            instrumentsList.add(bankInstrument);
        }

        return mapBankInstrumentToInstrumentDO(bankInstrument);
    }

    public InstrumentDO mapBankInstrumentToInstrumentDO(BankInstrument bankInstrument) {
        InstrumentDO instrumentDO = new InstrumentDO();
        instrumentDO.setBankAccountNumber(bankInstrument.getAccountNumber());
        instrumentDO.setIfscCode(bankInstrument.getIfscCode());
        instrumentDO.setInstrumentID(bankInstrument.getInstrumentID());
        instrumentDO.setInstrumentType(bankInstrument.getInstrumentType());
        instrumentDO.setUserID(bankInstrument.getUserID());

        return instrumentDO;
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserID(int userID) {
        List<Instrument> userInstrumentsList = usersVsInstrument.get(userID);
        List<InstrumentDO> userBankInstrumentsList = new ArrayList<>();
        for (Instrument instrument: userInstrumentsList) {
            if (instrument.getInstrumentType() == InstrumentType.BANK) {
                userBankInstrumentsList.add(mapBankInstrumentToInstrumentDO((BankInstrument) instrument));
            }
        }

        return userBankInstrumentsList;
    }
}
