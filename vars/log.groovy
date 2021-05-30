@groovy.transform.Field
String logLevel = "INFO"


def setLevel(level) {
    logLevel = level
}

def getLevel() { 
    return logLevel
}

def call(def message) {
    echo "${message}"
}
