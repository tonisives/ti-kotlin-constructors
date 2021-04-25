import co.touchlab.kermit.Kermit

class WebService(val url: String, apiVersion: String = "2") {
    val completeUrl = "$url/$apiVersion"
    var logger: Kermit? = null

    init {
        println("Initialised with api version: $apiVersion")
        println("url: $completeUrl")
    }

    constructor(environment: Environment) : this(getUrl(environment))

    constructor(environment: Environment, logger: Kermit) : this(getUrl(environment)) {
        this.logger = logger
        logger?.d { "hello from logger" }
    }

    enum class Environment {
        PROD, TEST
    }

    companion object {
        private fun getUrl(environment: Environment): String {
            return when (environment) {
                Environment.PROD -> "https://tonisives.com"
                Environment.TEST -> "https://tonisives.com/test"
            }
        }
    }

    fun getUsers() {
        // the primary constructors val is available throughout the class
        val requestUrl = "$url/users"
    }
}

fun main() {
    WebService("https://tonisives.com")
    WebService(WebService.Environment.TEST)
    WebService(WebService.Environment.TEST, Kermit())
}

open class Parent(input: Int)


class Child : Parent {
    constructor() : super(1) {
        println("Child class initialised")
    }
}