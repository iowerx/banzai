package io.werx.banzai

class Banzai implements Serializable {

    def script
    
    Banzai(def script) {
        this.script = script
    }
          
    def run() {
        script.ansiColor('xterm') {
              script.timestamps {
    

          //node { 
                    script.debug "this is debug."
                    script.info "this is info."
                    script.warn "this is warning."
                    script.error "this is error."
                    script.fatal "this is fatal."
                    script.log "plain log message."
          //}


def stringsToEcho = ["a", "b", "c", "d"]

def stages = stringsToEcho.collectEntries {
    ["echoing ${it}" : transformIntoStep(it)]
}

script.parallel stages

def c = { script.info("third") }


def bzStages = new BanzaiStages()

bzStages.add("1st", { script.info("first") } )
bzStages.add("2nd", { script.info("second") } )
//bzStages.add("3rd", c )

script.parallel bzStages.tasks
         
            }
        }
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