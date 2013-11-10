package com.johnflan.dispatcher;

public interface EventHandler {

    public void notify(Object object, Enum eventType);
}
