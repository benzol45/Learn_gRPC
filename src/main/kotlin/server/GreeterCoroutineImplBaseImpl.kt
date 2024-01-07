package server

import io.grpc.examples.helloworld.GreeterGrpcKt
import io.grpc.examples.helloworld.HelloReply
import io.grpc.examples.helloworld.HelloRequest

class GreeterCoroutineImplBaseImpl : GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        println("Received request: $request")
        return HelloReply.newBuilder().setMessage("Response ${request.name}").build()
    }

}