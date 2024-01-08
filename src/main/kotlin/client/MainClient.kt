package client

fun main(args: Array<String>) {
    val client = GrpcClient()
    //client.processSending("test name")
    //client.processStreaming()
    client.processSending("") //With error in the result
}