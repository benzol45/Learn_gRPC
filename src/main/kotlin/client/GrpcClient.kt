package client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.StatusException
import io.grpc.examples.helloworld.GreeterGrpcKt
import io.grpc.examples.helloworld.HelloRequest
import kotlinx.coroutines.runBlocking
import java.io.Closeable
import java.util.concurrent.TimeUnit

class GrpcClient: Closeable {
    private val channel: ManagedChannel = ManagedChannelBuilder.forAddress("localhost",5001).usePlaintext().build()
    private val stubService = GreeterGrpcKt.GreeterCoroutineStub(channel)

    fun processSending(name: String) {
        val message = HelloRequest.newBuilder().setName(name).build()
        runBlocking {
            try {
                val response = stubService.sayHello(message)
                println("Response: ${response.message}")
            } catch (ex: StatusException) {
                println(ex)
            }
        }
    }

    override fun close() {
        channel.shutdown().awaitTermination(10, TimeUnit.SECONDS)
    }
}