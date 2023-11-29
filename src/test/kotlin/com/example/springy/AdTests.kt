package com.example.springy

import com.example.springy.model.ArtistAd
import com.example.springy.util.getTestAd
import com.example.springy.util.let2
import com.example.springy.util.typeReference
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@SpringBootTest(
	classes = [SpringyApplication::class],
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class AddTests(@Autowired val client: TestRestTemplate) {

	@Test
	fun `Test posting add increasing list count`() {
		val randomId = java.util.UUID.randomUUID().toString()
		val testAd = getTestAd(randomId)

		val adCount = client.getForEntity("/ads/artists", List::class.java).body?.size

		val result = client.postForEntity("/ads/create", testAd, List::class.java)

		assert(result != null)
		assert(result.statusCode == HttpStatus.OK)
		let2(adCount, result.body?.size) { startCount, endCount -> assert(endCount > startCount)  }
	}

	@Test
	fun `Test posted ad found on list`() {
		val randomId = java.util.UUID.randomUUID().toString()
		val testAd = getTestAd(randomId)

		val url = "/ads/create"
		val method = HttpMethod.POST
		val headers = HttpHeaders()
		val entity = HttpEntity<Any>(testAd, headers)
		val response = client.exchange(url, method, entity, typeReference<List<ArtistAd>>())
		val containsTestAd = response.body?.any { it.id == testAd.id}

		assert(containsTestAd == true)
	}

}
