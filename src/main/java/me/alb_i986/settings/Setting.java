package me.alb_i986.settings;

public interface Setting<T> {

    String key();
    T value();
    boolean isDefined();
}
