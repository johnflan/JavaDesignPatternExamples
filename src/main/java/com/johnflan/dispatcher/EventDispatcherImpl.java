package com.johnflan.dispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcherImpl implements EventDispatcher {

    private Map<Enum, List<EventHandler>> eventHandlers;

    public EventDispatcherImpl(){
        eventHandlers = new HashMap<Enum, List<EventHandler>>();
    }

    @Override
    public void register(EventHandler eventHandler, Enum... eventTypes) {

        for (Enum eventType : eventTypes){
            List<EventHandler> eventHandlerList = eventHandlers.get(eventType);

            if(eventHandlerList == null){
                eventHandlerList = new ArrayList<EventHandler>();
            }

            eventHandlerList.add(eventHandler);
            eventHandlers.put(eventType, eventHandlerList);
        }
    }


    @Override
    public void notify(Object changedObject, Enum eventType) {
        List<EventHandler> eventHandlerList = eventHandlers.get(eventType);

        for (EventHandler eventHandler : eventHandlerList){
            eventHandler.notify(changedObject, eventType);
        }
    }

}
