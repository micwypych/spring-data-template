package org

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

import spock.lang.Specification

@ContextConfiguration(classes = AppConfig.class)
class AppSpec extends Specification {

    @Autowired
    App app

    def "application has a greeting"() {
        when:
        def result = app.greeting

        then:
        result != null
    }
}
