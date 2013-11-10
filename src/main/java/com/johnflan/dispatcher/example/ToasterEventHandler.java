package com.johnflan.dispatcher.example;

import com.johnflan.dispatcher.EventHandler;

public class ToasterEventHandler implements EventHandler {


    private void handleEvent(Toaster toaster, EventTypes eventType){
        if (EventTypes.TOASTER_TOASTED.equals(eventType)){
            System.out.println("The toaster is toasting");
        }
    }

    @Override
    public void notify(Object object, Enum eventType) {
        handleEvent((Toaster) object, (EventTypes) eventType);
    }
}
