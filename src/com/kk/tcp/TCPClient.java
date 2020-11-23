package com.kk.tcp;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    /**
     *
     * @author 柯神_
     * @date 2020-11-23 13:51:00
     * @param [args]
     * @return void
    */
    public static void main(String[] args) throws IOException {

        //1.客户端==>我需要知道服务器的地址
        Socket socket = new Socket("127.0.0.1", 9999);
        //2.发送消息
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("欢迎您，柯神_");
        //最后关闭连接，释放资源
        dataOutputStream.close();
        outputStream.close();
        socket.close();

    }
}
