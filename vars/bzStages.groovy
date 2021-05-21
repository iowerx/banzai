@groovy.transform.Field
def stages = [:]

def run() {
    stages.each { it ->
        echo "${it.key} : ${it.value}"
    }
}
