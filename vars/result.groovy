import hudson.model.Result

/**
 * hudson.model.Result:
 *
 * static Result 	ABORTED
 * The build was manually aborted.
 * BallColor 	color
 * Default ball color for this status.
 * boolean 	completeBuild
 * Is this a complete build - i.e.
 * static com.thoughtworks.xstream.converters.SingleValueConverter 	conv
 * static Result 	FAILURE
 * The build had a fatal error.
 * static Result 	NOT_BUILT
 * The module was not built.
 * int 	ordinal
 * Bigger numbers are worse.
 * static Result 	SUCCESS
 * The build had no errors.
 * static Result 	UNSTABLE
 */

Result get() {
        currentBuild.result
}

void set(Result result) {
        currentBuild.result = result
}

def to(Result r, String because = '') {
        String msg = "Transition job from ${currentBuild.result} to ${r} "
        msg = because ? (msg + because) : msg
        echo msg
        currentBuild.result = r
}

def call( Result r, String because = '') {
        to(r, because)
}
