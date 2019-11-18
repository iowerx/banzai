import io.werx.banzai.LogLevel

@groovy.transform.Field
LogLevel level = LogLevel.INFO


def setLevel(def level) {
    this.level = level
}

def fatal(def message) {
    call(LogLevel.FATAL, message)
}

def error(def message) {
    call(LogLevel.ERROR, message)
}

def warn(def message) {
    call(LogLevel.WARN, message)
}

def info(def message) {
    call(LogLevel.INFO, message)
}

def debug(def message) {
    call(LogLevel.DEBUG, message)
}

def trace(def message) {
    call(LogLevel.TRACE, message)
}

def call(LogLevel logLevel = LogLevel.ALL, String message = "Empty.") {
    if (level.value >= logLevel.value) {
        echo "${logLevel}: ${message}"
    }
}
