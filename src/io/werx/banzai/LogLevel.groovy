package io.werx.banzai

/**
 * LogLevels logLevel = 'INFO' as LogLevels
 * script.echo logLevel
 * script.echo logLevel.value
 *
 */
enum LogLevel {

    OFF(0),
    FATAL(1),
    ERROR(2),
    WARN(3),
    INFO(4),
    DEBUG(5),
    TRACE(6),
    ALL(7)

    LogLevel() {

    }
    LogLevel(int value) {
        this.value = value
    }

    private final int value

    int getValue() {
        value
    }

}
