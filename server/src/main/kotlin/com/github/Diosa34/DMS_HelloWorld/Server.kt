package com.github.Diosa34.DMS_HelloWorld

import java.net.*
import java.nio.ByteBuffer
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

class Server(
    host: InetAddress,
    port: Int,
    var sock: SocketChannel = SocketChannel.open()
) {
    val serv: ServerSocketChannel = ServerSocketChannel.open()
    init {
        val addr: SocketAddress = InetSocketAddress(host, port)
        serv.bind(addr)
        this.sock = serv.accept()
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    fun receive() {
        val arr = ByteArray(1024 * 1024)
        val buf = ByteBuffer.wrap(arr)
        println("Hello1")
        this.sock.read(buf)
        buf.flip()
        if (arr.contentEquals(ByteArray(1024 * 1024))) {
            this.serv.close()
            throw ConnectException("Завершена работа клиентского приложения")
        }
        println("Hello2")
        val bufferLogger = BufferLogger(this.sock)
        val command: BoundCommand
        try {
            command = CommandDeserializer.deserialize(arr.toUByteArray())
        } catch (ex: DeserializeException) {
            bufferLogger.print(ex.message)
            println(ex.message)
            bufferLogger.flush()
            return
        }
        println("Hello3")
        executeCall(command, bufferLogger)
        bufferLogger.flush()
        println("Hello4")
    }
}