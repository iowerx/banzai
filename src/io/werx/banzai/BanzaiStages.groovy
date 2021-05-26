package io.werx.banzai

class BanzaiStages implements Serializable {

    def tasks = [:]
    
    BanzaiStages() {
    }

    void add( String name, Closure task ) {
        tasks[name] = task
    }
    
}