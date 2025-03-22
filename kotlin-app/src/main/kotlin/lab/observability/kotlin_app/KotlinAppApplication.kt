package lab.observability.kotlin_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class KotlinAppApplication

fun main(args: Array<String>) {
	runApplication<KotlinAppApplication>(*args)
}
