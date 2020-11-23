package com.kk.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
/**
 *
 * @author 柯神_
 * @date 2020-11-23 13:49:18
 * @param [args]
 * @return void
*/
    public static void main(String[] args) throws IOException {

        //1.服务端==>我得有一个地址，提供给客户端
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端的连接
        Socket accept = serverSocket.accept();
        //3.读取消息
        InputStream inputStream = accept.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println(dataInputStream.readUTF());
        //最后关闭连接，释放资源
        dataInputStream.close();
        inputStream.close();
        accept.close();
    }
}
