package server

fun main(args: Array<String>) {
    val server: GrpcServer = GrpcServer()
    server.start()
}