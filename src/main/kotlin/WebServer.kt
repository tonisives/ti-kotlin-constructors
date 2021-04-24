class WebService(val url: String, apiVersion: String = "2") {
    val completeUrl = "$url/$apiVersion"

    init {
        println("Initialised with api version: $apiVersion")
        println("url: $completeUrl")
    }

    constructor(environment: Environment) : this(getUrl(environment))

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

fun main(args: Array<String>) {
    WebService("https://tonisives.com")
    WebService(WebService.Environment.TEST)
}