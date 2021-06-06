@groovy.transform.Field
String any = "String"

@groovy.transform.Field
Map stages = [:]

def addStage( String name, Closure c ) {
    stages[name] = c
}

def execStages() {

    Map tasks = [:]
    
    stages.each { tasks[ it.key ] = it.value }

    //parallel tasks
    
    echo "size: ${stages.size()}"
    stages.each { 
            echo "${it.key}: " 
            //echo it.value() 
        }
        
    parallel tasks
}
