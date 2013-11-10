package com.johnflan.dispatcher.example;

import static java.lang.Boolean.*;

public class Kettle{

    private Boolean boiling = FALSE;

    public void toggleSwitch() {
        if (boiling.equals(FALSE)){
            boiling = TRUE;

            DispatcherExample.eventDispatcher.notify(this, EventTypes.KETTLE_BOILED);
        }
    }

}
