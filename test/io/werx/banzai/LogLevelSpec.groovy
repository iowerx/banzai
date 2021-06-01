package io.werx.banzai

import spock.lang.Specification
import io.werx.banzai.LogLevel

class LogLevelSpec extends Specification {

    def "Correct value of LogLevel"() {
        when:
        int value = level.getValue()

        then:
        value == exprepr

        where:
        level          || exprepr
        LogLevel.OFF   || 0
        LogLevel.FATAL || 1
        LogLevel.ERROR || 2
        LogLevel.WARN  || 3
        LogLevel.INFO  || 4
        LogLevel.DEBUG || 5
        LogLevel.TRACE || 6
        LogLevel.ALL   || 7
    }

    def "Correct name of LogLevel"() {
        when:
        String name = level as String

        then:
        name == exprepr

        where:
        level          || exprepr
        LogLevel.OFF   || 'OFF'
        LogLevel.FATAL || 'FATAL'
        LogLevel.ERROR || 'ERROR'
        LogLevel.WARN  || 'WARN'
        LogLevel.INFO  || 'INFO'
        LogLevel.DEBUG || 'DEBUG'
        LogLevel.TRACE || 'TRACE'
        LogLevel.ALL   || 'ALL'
    }

}
