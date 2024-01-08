package server

import io.grpc.Status
import io.grpc.StatusException
import io.grpc.examples.helloworld.GreeterGrpcKt
import io.grpc.examples.helloworld.HelloReply
import io.grpc.examples.helloworld.HelloRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GreeterCoroutineImplBaseImpl : GreeterGrpcKt.GreeterCoroutineImplBase() {
    override suspend fun sayHello(request: HelloRequest): HelloReply {
        if (request.name!="") {
            println("Received request: $request")
            return HelloReply.newBuilder().setMessage("Response ${request.name}").build()
        } else {
            throw StatusException(Status.INVALID_ARGUMENT)
        }
    }

    override fun sayHelloStream(request: HelloRequest): Flow<HelloReply> = flow {
        while (true) {
            delay(5 * 1000)
            val newResponse = HelloReply.newBuilder().setMessage("Response ${Math.random()}").build()
            emit(newResponse)
        }
    }

}