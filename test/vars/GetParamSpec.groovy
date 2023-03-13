import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import spock.lang.Ignore

class GetParamSpec extends JenkinsPipelineSpecification {

    def GetParam = null

    void setup() {

        GetParam = loadPipelineScriptForTest( "vars/getParam.groovy" )

        getPipelineMock( "libraryResource" )( _ ) >> {
            return "Dummy Message"
        }

    }

    def "foo"() {
        setup:
        def script = getPipelineMock("CpsScript")
        explicitlyMockPipelineVariable("propertyMap")
        script.propertyMap = getPropertyMap(  )
        def params = getBuildParams()
        script.params = params
        explicitlyMockPipelineVariable("env")
        script.env = getEnvironment(  )
        GetParam.env = getEnvironment(  )
        GetParam.params = params

        when:
        def param = GetParam.call(name)

        then:
        param == expr

        where:
        name                        | expr
        'ENV_IS_SET_PARAM_IS_EMPTY' | 'ENV_IS_SET_PARAM_IS_EMPTY'
        'PARAM_IS_SET_ENV_IS_EMPTY' | 'PARAM_IS_SET_ENV_IS_EMPTY'
        'ENV_IS_NULL_PARAM_EXISTS'  | 'EXISTS'

    }

    void cleanup() {
    }

    Map  getBuildParams() {
        Map params = [:]
        params["TRUE"] = 'true'
        params["FALSE"] = 'false'
        params["PARAM_IS_TRUE_BUT_ENV_IS_FALSE"] = 'true'
        params["PARAM_IS_FALSE_BUT_ENV_IS_TRUE"] = 'false'
        params["ENV_IS_IFALSE_BUT_PARAM_IS_TRUE"] = 'true'
        params["ENV_IS_ITRUE_BUT_PARAM_IS_FALSE"] = 'false'
        params["FOO"] = ""
        params["BAR"] = ""
        params['ENV_IS_SET_PARAM_IS_EMPTY'] = ''
        params['PARAM_IS_SET_ENV_IS_EMPTY'] = 'PARAM_IS_SET_ENV_IS_EMPTY'
        params['ENV_IS_NULL_PARAM_EXISTS'] = 'EXISTS'

        return params
    }

    Map getEnvironment() {
        Map env = [:]
        env["I_TRUE"] = '!true'
        env["I_FALSE"] = '!false'
        env["TRUE"] = 'true'
        env["FALSE"] = 'false'
        env["PARAM_IS_TRUE_BUT_ENV_IS_FALSE"] = 'true'
        env["PARAM_IS_FALSE_BUT_ENV_IS_TRUE"] = 'false'
        env["ENV_IS_IFALSE_BUT_PARAM_IS_TRUE"] = 'true'
        env["ENV_IS_ITRUE_BUT_PARAM_IS_FALSE"] = 'false'
        env["FOO"] = ""
        env["BAR"] = ""
        env['ENV_IS_SET_PARAM_IS_EMPTY'] = 'ENV_IS_SET_PARAM_IS_EMPTY'
        env['PARAM_IS_SET_ENV_IS_EMPTY'] = ''
        //env['ENV_IS_NULL_PARAM_EXISTS'] = null

//         "TEST_STRING", defaultValue: "test_string", trim: true, description: "Sample string parameter" ),
//         "TEST_TEXT", defaultValue: "Jenkins Pipeline Tutorial", description: "Sample multi-line text parameter" ),
        // password( name: "TEST_PASSWORD", defaultValueAsSecret: "SECRET", description: "Sample password parameter" ),
//         name: "TEST_CHOICE", choices: ["production", "staging", "development"], description: "Sample multi-choice parameter" ),

//        ame: 'ENV_IS_I_YES_PARAM_IS_NO', defaultValue: 'NO', description: "getParam shoud be YES.")

        return env
    }

    private Map getPropertyMap() {
        return ["some": "someValue"]
    }

}