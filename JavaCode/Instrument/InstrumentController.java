package Instrument;

import java.util.*;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentController() {
        this.instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrumentDO.getInstrumentType());
        return instrumentService.addInstrument(instrumentDO);
    }

    public List<InstrumentDO> getAllInstruments(int userID) {
        InstrumentService bankInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        List<InstrumentDO> instrumentDOList = bankInstrumentService.getInstrumentsByUserID(userID);

        InstrumentService cardInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);
        instrumentDOList.addAll(cardInstrumentService.getInstrumentsByUserID(userID));

        return instrumentDOList;
    }

    public InstrumentDO getInstrumentByID(int userID, int instrumentID) {
        List<InstrumentDO> userInstrumentsList = getAllInstruments(userID);
        for (InstrumentDO instrument: userInstrumentsList) {
            if (instrument.getInstrumentID() == instrumentID) {
                return instrument;
            }
        }
        return null;
    }
}
