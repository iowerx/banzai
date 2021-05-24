@groovy.transform.Field
String logLevel = "INFO"

def call(def message) {
    echo "${message}"
}
