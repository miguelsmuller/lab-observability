package lab.observability.kotlin_app.adapters.out.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "python-app", url = "\${services.python.url}")
interface PythonAppClient {

    @GetMapping("/")
    fun getMessage(): String
}