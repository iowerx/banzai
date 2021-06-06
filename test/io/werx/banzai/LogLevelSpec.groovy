package io.werx.banzai

import spock.lang.Specification
import static io.werx.banzai.LogLevel.*

class LogLevelSpec extends Specification {

    def "Correct value of LogLevel"() {

        when:
        int value = level.value // uses synthetic accessor getValue()

        then:
        value == exprepr

        where:
        level || exprepr
        OFF   || 0
        FATAL || 1
        ERROR || 2
        WARN  || 3
        INFO  || 4
        DEBUG || 5
        TRACE || 6
        ALL   || 7
    }

    def "Correct name of LogLevel"() {

        when:
        String name = level // as String is automatic

        then:
        name == exprepr

        where:
        level || exprepr
        OFF   || 'OFF'
        FATAL || 'FATAL'
        ERROR || 'ERROR'
        WARN  || 'WARN'
        INFO  || 'INFO'
        DEBUG || 'DEBUG'
        TRACE || 'TRACE'
        ALL   || 'ALL'
    }

}
