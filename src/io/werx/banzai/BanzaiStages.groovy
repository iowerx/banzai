package io.werx.banzai

class BanzaiStages implements Serializable {

    def tasks = [:]
    
    BanzaiStages() {
    }

    add( String name, Closure task) {
        tasks[name] = task
    }
          

//def transformIntoStep(inputString) {
//    return {
//            script.info inputString
//    }
//}
    
    
}