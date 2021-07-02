package io.werx.banzai



class BzStage implements Serializable {

    def script
    def task
    def when
    
    BzStage(def script, Closure task) {
        this.script = script
        this.task = task
    }
    
}
