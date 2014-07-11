package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	def "test User validation"() {
		User u = new User(userName: 'bobmarley', firstName: 'Bob',
			lastName: 'Marley', email: 'bob@example.com')

		assert u.validate()
	}

    // Tests the custom validator.
    void "test custom validator for no users with the name Justin Bieber"() {
        User u = new User(userName:'justin', firstName: 'Justin',
            lastName: 'Bieber', email:'justin@example.com')

        assert !u.validate()

        u.firstName = 'jUsTiN'         // case insensitive
        assert !u.validate()

        u.lastName = 'TV'
        assert u.validate()
    }
}