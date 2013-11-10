package com.johnflan.dispatcher.example;

import com.johnflan.dispatcher.EventDispatcher;
import com.johnflan.dispatcher.EventDispatcherImpl;

import static com.johnflan.dispatcher.example.EventTypes.*;

public class DispatcherExample {

    // Static reference to the eventDispatcher is used here but
    // in a real world scenario, you would inject the dispatcher
    // using a DI framework.
    public static EventDispatcher eventDispatcher;



    public static void main(String[] args){

        eventDispatcher = new EventDispatcherImpl();

        //Register event handlers to a given event
        eventDispatcher.register(new KettleEventHandler(), KETTLE_BOILED);
        eventDispatcher.register(new ToasterEventHandler(), TOASTER_TOASTED);

        //Register an event handler instance to multiple events
        BreakfastReadyEventHandler breakFastReadyEventHandler = new BreakfastReadyEventHandler();
        eventDispatcher.register(breakFastReadyEventHandler, KETTLE_BOILED, TOASTER_TOASTED);


        new Kettle().toggleSwitch();
        new Toaster().toast();
    }

}
