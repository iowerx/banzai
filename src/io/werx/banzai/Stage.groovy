package io.werx.banzai

class Stage implements Serializable {

    def tasks = [:]
    
    Stage(String name, ) {
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