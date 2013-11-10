package com.johnflan.dispatcher.example;

import com.johnflan.dispatcher.EventHandler;

public class BreakfastReadyEventHandler implements EventHandler {

    Boolean kettleBoiled = Boolean.FALSE;
    Boolean toastToasted = Boolean.FALSE;


    private void handle(Kettle kettle, EventTypes event){
        if (event.equals(EventTypes.KETTLE_BOILED)){
            kettleBoiled = true;
        }

        breakfastReady();
    }

    private void handle(Toaster toaster, EventTypes event){
        if(event.equals(EventTypes.TOASTER_TOASTED)){
            toastToasted = Boolean.TRUE;
        }
        breakfastReady();
    }

    private void breakfastReady(){

        if(kettleBoiled && toastToasted){
            System.out.println("Breakfast ready!");
        }
    }

    @Override
    public void notify(Object object, Enum eventType) {

        if (object instanceof Toaster){
            handle((Toaster) object, (EventTypes) eventType);
        }

        if (object instanceof Kettle){
            handle((Kettle) object, (EventTypes) eventType);
        }


    }
}
