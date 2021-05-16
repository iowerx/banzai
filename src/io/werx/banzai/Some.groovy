
/**
*
* The Banzai algorithm for Jenkins pipelines expects that all jobs are a series of 
* one or more parallel jobs of one or more parallel stages of one or more parallel tasks.
* In this way, there is a single data structure for all jobs, a map of Jobs each 
* containing a map of Stages containing a map of Tasks.
*
* foreach( stage ) 


*/