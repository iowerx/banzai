package io.werx.banzai

class Stage implements Serializable {

    def tasks = [:]
    
    Stage() {
    }

    void add( String name, Closure task ) {
        tasks[name] = task
    }
          

//def transformIntoStep(inputString) {
//    return {
//            script.info inputString
//    }
//}
    
    
}
