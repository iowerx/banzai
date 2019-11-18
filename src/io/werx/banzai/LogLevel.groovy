package io.werx.banzai

enum LogLevel {

    OFF(0),
    FATAL(1),
    ERROR(2),
    WARN(3),
    INFO(4),
    DEBUG(5),
    TRACE(6),
    ALL(7)

    private final int value

    LogLevel(int value) {
        this.value = value
    }

    int getValue() {
        value
    }

}
