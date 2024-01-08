package client

fun main(args: Array<String>) {
    val client = GrpcClient()
    client.processSending("test name")
    client.processStreaming()
}