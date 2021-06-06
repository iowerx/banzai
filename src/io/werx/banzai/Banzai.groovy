package io.werx.banzai

import static LogLevel.*

class Banzai implements Serializable {

    def script
    
    Banzai(def script) {
        this.script = script
    }

    def run() {
        script.ansiColor('xterm') {
            script.timestamps {

                // LogLevel Usage:
                LogLevel logLevel = DEBUG
                script.echo "setLevel to ${DEBUG}"
                script.log.setLevel(logLevel)
                script.echo "level: ${script.log.level}"
                script.echo "value: ${script.log.level.value}"
                script.debug "this is debug."
                script.info "this is info."
                script.warn "this is warning."
                script.error "this is error."
                script.fatal "this is fatal."
                script.log DEBUG, "this too is debug."

                //node {

                //}

                // Tasks from array:
                def stringsToEcho = ["a", "b", "c", "d"]

                def stages = stringsToEcho.collectEntries {
                    ["echoing ${it}": transformIntoStep(it)]
                }

                // script.parallel stages

                // BanzaiStages: 

                def banzaiStages = new BanzaiStages()

                banzaiStages.add("1st", { script.info("first") })
                banzaiStages.add("2nd", { script.info("second") })

                // script.parallel banzaiStages.tasks

                // BanzaiStage

                // script.banzai.stages["bz First",  new BanzaiStage( { script.info("bz First") } ) ]
                // script.banzai.stages["bz Second", new BanzaiStage( { second } ) ]

                script.banzai.addStage "Stage 1", { script.info("First") }
                script.banzai.addStage "Stage 2", { aStage() }
                script.banzai.addStage "Stage 3.", third

                script.banzai.execStages()

            }
        }
    } // run() 


    void aStage() {
        script.echo "A method wrapped in a closure."
    }

def third = { script.info("Closure variable.") }


def aStageTask() {

}


def transformIntoStep(inputString) {
    // We need to wrap what we return in a Groovy closure, or else it's invoked
    // when this method is called, not when we pass it to parallel.
    // To do this, you need to wrap the code below in { }, and either return
    // that explicitly, or use { -> } syntax.
    return {
            script.info inputString
    }
}

}