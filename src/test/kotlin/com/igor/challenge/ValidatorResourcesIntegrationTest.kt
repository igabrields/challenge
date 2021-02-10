package com.igor.challenge

import com.igor.challenge.api.ValidatorResources
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ValidatorResourcesIntegrationTest {

	@Autowired
	lateinit var validatorResources: ValidatorResources

	@Test
	fun contextLoads() {
		assertThat(validatorResources)
	}

}

