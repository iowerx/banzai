package io.werx.banzai

import io.werx.banzai.BzStage

/**
 *
 * post -- A map of Closures that are called in the following conditions:
 *
 *   always -  Run the steps in the post section regardless of the completion status of the Pipeline’s or stage’s run.
 *   changed -  Only run the steps in post if the current Pipeline’s or stage’s run has a different completion status from its previous run.
 *   fixed -  Only run the steps in post if the current Pipeline’s or stage’s run is successful and the previous run failed or was unstable.
 *   regression -  Only run the steps in post if the current Pipeline’s or stage’s run’s status is failure, unstable, or aborted and the previous run was successful.
 *   aborted -  Only run the steps in post if the current Pipeline’s or stage’s run has an "aborted" status, usually due to the Pipeline being manually aborted. This is typically denoted by gray in the web UI.
 *   failure -  Only run the steps in post if the current Pipeline’s or stage’s run has a "failed" status, typically denoted by red in the web UI.
 *   success -  Only run the steps in post if the current Pipeline’s or stage’s run has a "success" status, typically denoted by blue or green in the web UI.
 *   unstable -  Only run the steps in post if the current Pipeline’s or stage’s run has an "unstable" status, usually caused by test failures, code violations, etc. This is typically denoted by yellow in the web UI.
 *   unsuccessful -  Only run the steps in post if the current Pipeline’s or stage’s run has not a "success" status. This is typically denoted in the web UI depending on the status previously mentioned.
 *   cleanup -  Run the steps in this post condition after every other post condition has been evaluated, regardless of the Pipeline or stage’s status.
 *   
 */


class BzStages implements Serializable {

    def script
    def tasks = [:]
    //def bzStages = <BzStage>[]
    Map<String, BzStage> bzStages = [:]
    Map<String, Closure> post

    BzStages(def script) {
        this.script = script
        post = [
                'always'      : noOp,
                'changed'     : noOp,
                'fixed'       : noOp,
                'regression'  : noOp,
                'aborted'     : noOp,
                'failure'     : noOp,
                'success'     : noOp,
                'unstable'    : noOp,
                'unsuccessful': noOp,
                'cleanup'     : noOp
        ]

    }

    /**
     *
     * @param name
     * @param task
     */
    void add(String name, Closure task) {
        tasks[name] = task
    }

    /**
     * noOp - a No Operation Closure.
     */
    def noOp = {}
}
