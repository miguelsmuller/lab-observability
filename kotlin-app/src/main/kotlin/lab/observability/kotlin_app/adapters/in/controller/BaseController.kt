package lab.observability.kotlin_app.adapters.`in`.controller

import lab.observability.kotlin_app.adapters.out.client.PythonAppClient
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/")
class BaseController(
        private val pythonApp: PythonAppClient
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun default(): BaseResponse {
        val pythonAppResponse = pythonApp.getMessage()

        return BaseResponse(
            messageFromKotlinApp = LocalDateTime.now().toString(),
            messageFromPythonApp = pythonAppResponse
        )
    }
}