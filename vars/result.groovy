import hudson.model.Result

/**
 * hudson.model.Result:
 *
 * ABORTED   - The build was manually aborted.
 * FAILURE   - The build had a fatal error.
 * NOT_BUILT - The module was not built.
 * SUCCESS   - The build had no errors.
 * UNSTABLE  - The build completed but with errors. 
 * boolean completeBuild - Is this a complete build
 * ordinal   - Bigger numbers are worse.
 *
 */

Result get() {
        currentBuild.result
}

void set(Result result) {
        currentBuild.result = result.toString()
}

def to(Result r, String because = '') {
        String msg = "Transition job from ${currentBuild.result} to ${r} " + because
        echo msg
        currentBuild.result = r.toString()
}

def call( Result r, String because = '') {
        to(r, because)
}
