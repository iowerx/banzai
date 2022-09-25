import io.werx.banzai.LogLevel
import static io.werx.banzai.LogLevel.*

@groovy.transform.Field
LogLevel level

// Requires a singleton
def getLevel() {
    if (this.level == null) {
        this.level = INFO
    }
    this.level
}

def setLevel(LogLevel level) {
    this.level = level
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
    // Will initialize global level if it has not been.
    if (getLevel().getValue() >= level.getValue()) {
        echo "${level}: ${message}"
    }
}
