package info.mizoguche.kotlinserver2018

import info.mizoguche.kotlinserver2018.presentation.response.HelloResponse
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    embeddedServer(
            factory = Netty,
            port = 8080,
            module = Application::main
    ).start(wait = true)
}

fun Application.main() {
    install(ContentNegotiation) {
        gson { }
    }

    routing {
        get("/") {
            call.respond(HelloResponse("Hello, Kotlin server!"))
        }
    }
}
