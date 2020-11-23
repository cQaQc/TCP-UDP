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

        Socket socket = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream=null;

        //1.客户端==>我需要知道服务器的地址
        try {
            socket = new Socket("127.0.0.1", 9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.发送消息
            try {
                outputStream = socket.getOutputStream();
                dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF("欢迎您，柯神_");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //最后关闭连接，释放资源
                dataOutputStream.close();
                outputStream.close();
                socket.close();
            }
    }
}
