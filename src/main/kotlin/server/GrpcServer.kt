package server

import io.grpc.Server
import io.grpc.ServerBuilder

class GrpcServer {
    private val server: Server = ServerBuilder.forPort(5001).addService(GreeterCoroutineImplBaseImpl()).build()

    fun start() {
        server.start()
        println("gRPC server started on port 5001")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@GrpcServer.stop()
                println("*** server shut down")
            }
        )
        server.awaitTermination()
    }

    fun stop() {
        server.shutdown()
    }
}