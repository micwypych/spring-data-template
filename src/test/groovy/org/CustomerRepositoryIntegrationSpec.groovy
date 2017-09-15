package org

import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = AppConfig.class)
class CustomerRepositoryIntegrationSpec extends Specification {

    @Autowired CustomerRepository repository

    @Before
    def clearDB() {
        repository.deleteAll()
    }

    def "is able to find a single customer by last name" () {
        when:
          Customer mark = new Customer("Mark", "Mueller")
          mark = repository.save mark

          Customer carter = new Customer("Carter", "Beauford")
          carter = repository.save carter

          List<Customer> result = repository.findByLastName "Mueller"

        then:
          mark.id != null
          carter.id != null
          repository.count() == 2
          result.size() == 1
          result[0].firstName == "Mark"
          result[0].lastName == "Mueller"
    }
}
