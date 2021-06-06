package io.werx.banzai

/**
 *
 post:  The post section defines one or more additional steps that are run upon the completion.

 Required:  No
 Parameters:  None
 Allowed:  In the top-level pipeline block and each stage block.
 Conditions:
 always -  Run the steps in the post section regardless of the completion status of the Pipeline’s or stage’s run.
 changed -  Only run the steps in post if the current Pipeline’s or stage’s run has a different completion status from its previous run.
 fixed -  Only run the steps in post if the current Pipeline’s or stage’s run is successful and the previous run failed or was unstable.
 regression -  Only run the steps in post if the current Pipeline’s or stage’s run’s status is failure, unstable, or aborted and the previous run was successful.
 aborted -  Only run the steps in post if the current Pipeline’s or stage’s run has an "aborted" status, usually due to the Pipeline being manually aborted. This is typically denoted by gray in the web UI.
 failure -  Only run the steps in post if the current Pipeline’s or stage’s run has a "failed" status, typically denoted by red in the web UI.
 success -  Only run the steps in post if the current Pipeline’s or stage’s run has a "success" status, typically denoted by blue or green in the web UI.
 unstable -  Only run the steps in post if the current Pipeline’s or stage’s run has an "unstable" status, usually caused by test failures, code violations, etc. This is typically denoted by yellow in the web UI.
 unsuccessful -  Only run the steps in post if the current Pipeline’s or stage’s run has not a "success" status. This is typically denoted in the web UI depending on the status previously mentioned.
 cleanup -  Run the steps in this post condition after every other post condition has been evaluated, regardless of the Pipeline or stage’s status.
 *
 * 
 * script.currentBuild.result = Constants.UNSTABLE
 * 
 *    public static final String SUCCESS = "SUCCESS"
 *     public static final String FAILURE = "FAILURE"
 *     public static final String ABORTED = "ABORTED"
 *     public static final String STABLE = "STABLE"
 *     public static final String UNSTABLE = "UNSTABLE"
 *     public static final String NOT_BUILT = "NOT_BUILT"
 *     public static final String SKIPPED = "SKIPPED"
 * 
 * enum StageStatus {
 *     SUCCESS ("Success"),
 *     FAILURE ("Failure"),
 *     UNSTABLE ("Unstable"),
 *     ABORTED ("Aborted"),
 *     NOT_BUILT ("Not Built"),
 *     SKIPPED ("Skipped"),
 *     ALL
 * 
 */


        class BanzaiStages implements Serializable {

    def tasks = [:]
    
    BanzaiStages() {
    }

    void add( String name, Closure task ) {
        tasks[name] = task
    }
    
}