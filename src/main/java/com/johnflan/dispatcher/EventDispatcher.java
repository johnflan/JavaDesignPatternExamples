package com.johnflan.dispatcher;

public interface EventDispatcher {

    public void register(EventHandler listener, Enum... eventType);
    public void notify(Object object, Enum eventType);

}
