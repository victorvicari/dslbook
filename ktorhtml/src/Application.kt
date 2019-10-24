package kotlinguide

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    p {
                        +"paragraph"
                    }
                    b {
                        +"boldtext"
                    }

                    ul {
                       li {
                           +"one"
                       }
                       li {
                           +"two"
                       }
                    }

                    p {
                        a("google.com")
                        a("wikipedia.com")
                        p {
                            a("twitter.com")
                        }
                    }
                }
            }
        }
    }
}
//ul {
//    for (n in 1..10) {
//        li { +"$n" }
//    }
//}

