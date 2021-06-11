package io.werx.banzai

import hudson.model.Result
import static hudson.model.Result.ABORTED
import static hudson.model.Result.FAILURE
import static hudson.model.Result.NOT_BUILT
import static hudson.model.Result.SUCCESS
import static hudson.model.Result.UNSTABLE
import static LogLevel.*

class Banzai implements Serializable {

    def script
    
    Banzai(def script) {
        this.script = script
    }

    def run() {
        script.ansiColor('xterm') {
            script.timestamps {

                script.result.set(SUCCESS)

                // LogLevel Usage:
                LogLevel logLevel = DEBUG
                script.echo "setLevel to ${DEBUG}"
                script.log.setLevel(logLevel)
                script.echo "level: ${script.log.level}"
                script.echo "value: ${script.log.level.value}"
                script.log TRACE, "this is trace."
                script.log DEBUG, "this is debug."
                script.log INFO, "this is info."
                script.log WARN, "this is warning."
                script.log ERROR, "this is error."
                script.log FATAL, "this is fatal."
                script.log ALL, "this is all - no use case."
                script.log OFF, "this is off, no use cases."

                // Tasks from array:
                /*
                def stringsToEcho = ["a", "b", "c", "d"]

                def stages = stringsToEcho.collectEntries {
                    ["echoing ${it}": transformIntoStep(it)]
                }

                script.parallel stages
                */

                def banzaiStages = new BanzaiStages()

                banzaiStages.add("1st", {
                    script.log INFO, "first"
                    // script.result UNSTABLE
                })

                banzaiStages.add("2nd", {
                    script.log INFO, "second"
                    // script.result FAILURE
                })

                banzaiStages.add("3rd", {
                    script.log INFO, "third"
                    // script.result NOT_BUILT, "just because."
                })

                script.parallel banzaiStages.tasks

                // BanzaiStage

                script.banzai.addStage "Stage 1", { script.log INFO, "First" }
                script.banzai.addStage "Stage 2", { aStage() }
                script.banzai.addStage "Stage 3.", third

                script.banzai.execStages()

                // If this far, then success.
                script.result.set(SUCCESS)

            }
        }
    } // run() 


    void aStage() {
        script.echo "A method wrapped in a closure."
    }

    def third = { script.log INFO, "Closure variable." }

    def aStageTask() {

    }

    def transformIntoStep(inputString) {
        // We need to wrap what we return in a Groovy closure, or else it's invoked
        // when this method is called, not when we pass it to parallel.
        // To do this, you need to wrap the code below in { }, and either return
        // that explicitly, or use { -> } syntax.
        return {
            script.log INFO, inputString
        }
    }

}