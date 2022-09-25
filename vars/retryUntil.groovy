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

def call( Map config ) {

    long maxTimeMillis = 0

    if ( config == null ) {
        throw new Exception( "No configuration specified." )
    }

    Closure task = (config.task == null) ? null : config.task
    if ( task == null ) {
        throw new Exception( "No task specified." )
    }

    Closure callback = (config.callback == null) ? { 0 } : config.callback

    // No value runs once
    def maxTries = (config.maxTries == null) ? 1 : ((config.maxTries <= 0) ? 0 : config.maxTries)

    def maxTime = Duration.ZERO
    if ( config.maxTime ) {
        maxTime = Duration.parse( config.maxTime )
        maxTimeMillis = maxTime.toMillis()
    }

    if ( maxTries == 0 && (maxTime == Duration.ZERO) ) {
        throw new Exception( "Specify either a maximum time or maximum retries." )
    }

    def pauseFor = Duration.ZERO
    if ( config.pauseFor ) {
        pauseFor = Duration.parse( config.pauseFor )
    }

    Instant start = Instant.now()
    def tries = maxTries
    while ( true ) {

        // For compatibility with shell scripts, 0 == success
        if ( !task.call() ) {
            return
        }

        // if there is a not maxTime, else return
        def timeMillis = ChronoUnit.MILLIS.between( start, Instant.now() )
        if ( maxTimeMillis && (timeMillis >= maxTimeMillis) ) {
            throw new Exception( "No success after waiting ${config.maxTime} time." )
        }   // else there is no timeout, or not yet.

        // Ignore if no maxTries
        if ( !maxTries && (tries == 1) ) {
            throw new Exception( "No success after ${maxTries} retries." )
        }

        if ( callback() ) {
            throw new Exception( "Terminated by callback()." )
        }

        if ( pauseFor > Duration.ZERO ) {
            sleep( time: pauseFor.toMillis(), unit: 'MILLISECONDS' )
        }

        // Countdown only if maxTries
        if ( maxTries ) { tries-- }

    }

}