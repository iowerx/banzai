import io.werx.banzai.LogLevel
import static io.werx.banzai.LogLevel.*

@groovy.transform.Field
LogLevel level = INFO


def setLevel(def level) {
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

def call(LogLevel logLevel = LogLevel.ALL, String message = "Empty.") {
    if (level.value >= logLevel.value) {
        echo "${logLevel}: ${message}"
    }
}
