package Instrument;

import java.util.*;

public abstract class InstrumentService {
    static Map<Integer, List<Instrument>> usersVsInstrument = new HashMap<>();

    public abstract InstrumentDO addInstrument(InstrumentDO instrumentDO);

    public abstract List<InstrumentDO> getInstrumentsByUserID(int userID);
}
