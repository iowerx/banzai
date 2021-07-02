package io.werx.banzai.singleton

//import groovy.lang.Singleton
import io.werx.banzai.LogLevel

//@Singleton
class LogLevelSingleton {
    private static final LogLevelSingleton instance = new LogLevelSingleton()

    LogLevel level = LogLevel.INFO

    private LogLevelSingleton() {
    }

}
