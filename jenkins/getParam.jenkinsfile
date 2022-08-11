#!/usr/bin/env groovy
@Library('banzai@main') _

import hudson.model.Result

import static hudson.model.Result.*


env.TRUE = 'true'
env.FALSE = 'false'
env.I_TRUE = '!true'
env.I_FALSE = '!false'

env.YES = "yes"
env.NO = "no"
env.I_YES = "!yes"
env.I_NO = "!no"

env.ALWAYS_TRUE = '!true'
env.ALWAYS_FALSE = '!false'

env.PARAM_IS_TRUE_BUT_ENV_IS_FALSE = 'false'
env.PARAM_IS_FALSE_BUT_ENV_IS_TRUE = 'true'

env.ENV_IS_IFALSE_BUT_PARAM_IS_TRUE = '!false'
env.ENV_IS_ITRUE_BUT_PARAM_IS_FALSE = '!true'

env.ENV_IS_PRESENT = "ENV_IS_PRESENT"
//env.ENV_IS_NOT_PRESENT = "ENV_IS_NOT_PRESENT"

env.ENV_IS_SET_PARAM_IS_EMPTY = 'ENV_IS_SET_PARAM_IS_EMPTY'
env.PARAM_IS_SET_ENV_IS_EMPTY = ''

env.FOO = "foo"
env.BAR = "bar"

node('CTS_NGC_SLAVE') {

    properties( [
            parameters( [
                    booleanParam( name: "I_TRUE", defaultValue: false, description: "NOT environemment." ),
                    booleanParam( name: "I_FALSE", defaultValue: true, description: "NOT environment." ),
                    booleanParam( name: "TRUE", defaultValue: true, description: "NOT environment." ),

                    booleanParam( name: "PARAM_IS_TRUE_BUT_ENV_IS_FALSE", defaultValue: true, description: "TRUE" ),
                    booleanParam( name: "PARAM_IS_FALSE_BUT_ENV_IS_TRUE", defaultValue: false, description: "FALSE" ),
                    booleanParam( name: "ENV_IS_IFALSE_BUT_PARAM_IS_TRUE", defaultValue: true, description: "TRUE" ),
                    booleanParam( name: "ENV_IS_ITRUE_BUT_PARAM_IS_FALSE", defaultValue: false, description: "FALSE" ),

                    string( name: "FOO", defaultValue: "", description: "Initial value: foo" ),
                    string( name: "BAR", defaultValue: "", description: "Initial value: bar"),

                    string( name: 'ENV_IS_SET_PARAM_IS_EMPTY', defaultValue: '', description: 'Environment defines a value, but param does not.' ),
                    string( name: 'PARAM_IS_SET_ENV_IS_EMPTY', defaultValue: 'PARAM_IS_SET_ENV_IS_EMPTY', description: 'Parameter defines a value, but env does not.' ),

                    string( name: "TEST_STRING", defaultValue: "test_string", trim: true, description: "Sample string parameter" ),
                    text( name: "TEST_TEXT", defaultValue: "Jenkins Pipeline Tutorial", description: "Sample multi-line text parameter" ),
                    // password( name: "TEST_PASSWORD", defaultValueAsSecret: "SECRET", description: "Sample password parameter" ),
                    choice( name: "TEST_CHOICE", choices: ["production", "staging", "development"], description: "Sample multi-choice parameter" )
            ] )
    ] )

    stage("Setup") {

        echo "Environment variables:"
        echo "PARAM_IS_TRUE_BUT_ENV_IS_FALSE:  env == ${env.PARAM_IS_TRUE_BUT_ENV_IS_FALSE}"
        echo "PARAM_IS_FALSE_BUT_ENV_IS_TRUE:  env == ${env.PARAM_IS_FALSE_BUT_ENV_IS_TRUE}"
        echo "ENV_IS_IFALSE_BUT_PARAM_IS_TRUE: env == ${env.ENV_IS_IFALSE_BUT_PARAM_IS_TRUE}"
        echo "ENV_IS_ITRUE_BUT_PARAM_IS_FALSE: env == ${env.ENV_IS_ITRUE_BUT_PARAM_IS_FALSE}"
        echo "ENV_IS_SET_PARAM_IS_EMPTY:       env == ${env.ENV_IS_SET_PARAM_IS_EMPTY}"
        echo "PARAM_IS_SET_ENV_IS_EMPTY:       env == ${PARAM_IS_SET_ENV_IS_EMPTY}"
        echo ""

        echo "Parameter variables:"
        echo "PARAM_IS_TRUE_BUT_ENV_IS_FALSE:  param == ${params.PARAM_IS_TRUE_BUT_ENV_IS_FALSE}"
        echo "PARAM_IS_FALSE_BUT_ENV_IS_TRUE:  param == ${params.PARAM_IS_FALSE_BUT_ENV_IS_TRUE}"
        echo "ENV_IS_IFALSE_BUT_PARAM_IS_TRUE: param == ${params.ENV_IS_IFALSE_BUT_PARAM_IS_TRUE}"
        echo "ENV_IS_ITRUE_BUT_PARAM_IS_FALSE: param == ${params.ENV_IS_ITRUE_BUT_PARAM_IS_FALSE}"
        echo "ENV_IS_SET_PARAM_IS_EMPTY:       param == ${params.ENV_IS_SET_PARAM_IS_EMPTY}"
        echo "PARAM_IS_SET_ENV_IS_EMPTY:       param == ${params.PARAM_IS_SET_ENV_IS_EMPTY}"

        echo ""

    }

    stage("getParam() Boolean") {

        echo "Using getParam()"
        echo "PARAM_IS_TRUE_BUT_ENV_IS_FALSE:  getParam() == ${getParam('PARAM_IS_TRUE_BUT_ENV_IS_FALSE')}"
        echo "PARAM_IS_FALSE_BUT_ENV_IS_TRUE:  getParam() == ${getParam('PARAM_IS_FALSE_BUT_ENV_IS_TRUE')}"
        echo "ENV_IS_IFALSE_BUT_PARAM_IS_TRUE: getParam() == ${getParam('ENV_IS_IFALSE_BUT_PARAM_IS_TRUE')}"
        echo "ENV_IS_ITRUE_BUT_PARAM_IS_FALSE: getParam() == ${getParam('ENV_IS_ITRUE_BUT_PARAM_IS_FALSE')}"

    }

    stage("getParam() Present") {
        echo ""
        echo "PARAM_NOT_PRESENT:               getParam() == ${getParam('PARAM_NOT_PRESENT')}"
        echo "ENV_IS_PRESENT:                  getParam() == ${getParam('ENV_IS_PRESENT')}"
        echo "ENV_IS_NOT_PRESENT:              getParam() == ${getParam('ENV_IS_NOT_PRESENT')}"
        echo "ENV_IS_SET_PARAM_IS_EMPTY:       getParam() == ${getParam('ENV_IS_SET_PARAM_IS_EMPTY')}"
        echo "PARAM_IS_SET_ENV_IS_EMPTY:       getParam() == ${getParam('PARAM_IS_SET_ENV_IS_EMPTY')}"
    }

}
