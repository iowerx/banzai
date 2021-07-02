import io.werx.banzai.LogLevel
import io.werx.banzai.singleton.LogLevelSingleton

import static io.werx.banzai.LogLevel.*

// TODO - Field is apparently NOT a singleton
//@groovy.transform.Field
//LogLevel level = INFO

// Requires a singleton
def getLevel() {
    LogLevelSingleton.instance.getLevel()
}
def setLevel(LogLevel level) {
    LogLevelSingleton.instance.setLevel(level)
}

def fatal(def message) {
    call(FATAL, message)
}

def error(def message) {
    call(ERROR, message)
}

def warn(def message) {
    call(WARN, message)
}

def info(def message) {
    call(INFO, message)
}

def debug(def message) {
    call(DEBUG, message)
}

def trace(def message) {
    call(TRACE, message)
}

def call(LogLevel level = LogLevel.ALL, String message = "Empty.") {
    if (getLevel().value >= level.value) {
        echo "${level}: ${message}"
    }
}
