package com.johnflan.dispatcher.example;

public class Toaster {


    public void toast(){

        DispatcherExample.eventDispatcher.notify(this, EventTypes.TOASTER_TOASTED);
    }

}
