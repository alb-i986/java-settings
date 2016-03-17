package me.alb_i986.settings.core;

public interface Setting<T> {
    String key();
    T value();
    boolean isDefined();
}
