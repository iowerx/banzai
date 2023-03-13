// #!/usr/bin/env groovy - shebang not required.

def call( String name ) {

    def priority = false

    def eVal = env[name]
    def pVal = params[name]

    // Check that the parameter is specified anywhere.
    if (eVal == null && pVal == null) {
        return null
    }

    // Does environment begin with Bang?
    eVal = eVal?.trim()
    if (eVal?.startsWith('!')) {
        eVal = eVal.substring(1)
        priority = true
    }

    // If Environment has priority, then Environment.
    // Otherwise, if Parameter is null/empty/false, then Environment.
    // Otherwise, Parameter.
    def val = priority ? eVal : (pVal ?: eVal)

    // Boolean parameter types are returned as boolean.
    switch (pVal?.getClass()?.getName()) {
        case 'java.lang.Boolean':
            // Only if there is no matching boolean parameter can it be effectively out scoped.
            return val.toBoolean()
        default:
            return val
    }

}
