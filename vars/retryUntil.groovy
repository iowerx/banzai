// #!/usr/bin/env groovy - shebang not required.

import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.LocalTime
import groovy.time.TimeDuration

import java.time.temporal.ChronoUnit

/**
 * retryUntil until either the max attempts or timeout has been reached.
 *
 * If no maxRetries is specified, then closure will be called repeatedly until timeout.
 * If no maxTime is specified, then closure will be called for specified maxRetries.
 * There must be either a maxRetries or MaxTime specified.
 *
 *
 * @param config
 * @return
 */

def noOp() {
    0
}

def call( Map config ) {

    // callback
    // pauseFor
    // maxTime
    // maxTries

    if (config == null) {
        throw new Exception( "No configuration specified." )
    }

    Closure task = (config.task == null) ? null : config.callback
    if (task == null) {
        throw new Exception("No task specified.")
    }

    Closure callback = (config.callback == null) ? noOp : config.callback

    // No value runs once
    def maxTries = (config.maxTries == null) ? 0 : ((config.maxTries <= 0) ? 0 : config.maxTries)

    def maxTime = Duration.ZERO

    if ( config.maxTime ) {
        maxTime = Duration.parse( config.maxTime )
    }

    if ( maxTries == 0 && (maxTime == Duration.ZERO) ) {
        throw new Exception( "Specify either a maximum time or maximum retries." )
    }

    Instant start = Instant.now()
    def tries = maxTries
    while ( true ) {
        echo "Trying task ..."

        // For compatibility with shell scripts, 0 == success
        if (!task.call()) {
            return
        }

        // if there is a not maxTime, else return
        def gap = ChronoUnit.MILLIS.between( start, Instant.now() )
        def timeout = maxTime.toMillis()
        if ( timeout ) {
            if ( gap >= timeout ) {
                throw new Exception( "No success after waiting ${config.maxTime} retries." )
            }
            // No timeout yet...
        } else {
            // There is no timeout, retry only.
        }

        // This is the last try.
        if (tries == 1) {
            throw new Exception( "No success after ${maxTries} retries." )
        } else {
            callback()
            tries--
        }

    }

}