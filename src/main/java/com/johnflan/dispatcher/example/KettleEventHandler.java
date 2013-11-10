package com.johnflan.dispatcher.example;

import com.johnflan.dispatcher.EventHandler;

import static com.johnflan.dispatcher.example.EventTypes.KETTLE_BOILED;

public class KettleEventHandler implements EventHandler {

    private void handleEvent(Kettle kettle, EventTypes event) {
        if (event.equals(KETTLE_BOILED)) {
            System.out.println("The kettle is boiling");
        }
    }

    @Override
    public void notify(Object object, Enum eventType) {
        handleEvent((Kettle) object, (EventTypes) eventType);
    }
}
