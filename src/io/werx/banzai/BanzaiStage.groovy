package io.werx.banzai

class BanzaiStage implements Serializable {

    def task
    def when
    
    BanzaiStage(Closure task) {
        this.task = task
    }
    
}
