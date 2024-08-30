package Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService {
    
    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.setCardNumber(instrumentDO.getCardNumber());
        cardInstrument.setCvvNumber(instrumentDO.getCvvNumber());
        cardInstrument.setInstrumentID(new Random().nextInt(100-10) + 10);
        cardInstrument.setInstrumentType(instrumentDO.getInstrumentType());
        cardInstrument.setUserID(instrumentDO.getUserID());

        if (!usersVsInstrument.containsKey(cardInstrument.getUserID())) {
            List<Instrument> instrumentsList = new ArrayList<>();
            instrumentsList.add(cardInstrument);
            usersVsInstrument.put(cardInstrument.getUserID(), instrumentsList);
        } else {
            List<Instrument> instrumentsList = usersVsInstrument.get(cardInstrument.getUserID());
            instrumentsList.add(cardInstrument);
        }

        return mapBankInstrumentToInstrumentDO(cardInstrument);
    }

    public InstrumentDO mapBankInstrumentToInstrumentDO(CardInstrument bankInstrument) {
        InstrumentDO instrumentDO = new InstrumentDO();
        instrumentDO.setCardNumber(bankInstrument.getCardNumber());
        instrumentDO.setCvvNumber(bankInstrument.getCvvNumber());
        instrumentDO.setInstrumentID(bankInstrument.getInstrumentID());
        instrumentDO.setInstrumentType(bankInstrument.getInstrumentType());
        instrumentDO.setUserID(bankInstrument.getUserID());

        return instrumentDO;
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserID(int userID) {
        List<Instrument> userInstrumentsList = usersVsInstrument.get(userID);
        List<InstrumentDO> userCardInstrumentsList = new ArrayList<>();
        for (Instrument instrument: userInstrumentsList) {
            if (instrument.getInstrumentType() == InstrumentType.CARD) {
                userCardInstrumentsList.add(mapBankInstrumentToInstrumentDO((CardInstrument) instrument));
            }
        }

        return userCardInstrumentsList;
    }
}
