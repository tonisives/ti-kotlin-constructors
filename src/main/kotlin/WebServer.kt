class WebService(val url: String, apiVersion: String) {
    val completeUrl = "$url/$apiVersion"

    init {
        println("Initialised with api version: $apiVersion")
    }

    fun getUsers() {
        // the primary constructors val is available throughout the class
        val requestUrl = "$url/users"
    }
}

fun main(args: Array<String>) {
    WebService("https://tonisives.com", "1")
}