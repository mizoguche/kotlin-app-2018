package info.mizoguche.kotlinserver2018

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.response.respondText
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
            call.respondText("Hello, Kotlin server!", ContentType.Text.Plain)
        }
    }
}
