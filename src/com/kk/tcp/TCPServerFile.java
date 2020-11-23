package com.kk.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerFile {
    /**
     *
     * @author 柯神_
     * @date 2020-11-23 16:55:47
     * @param [args]
     * @return void
    */
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动.....  ");

        // 1. 创建服务端ServerSocket
        ServerSocket serverSocket = new ServerSocket(9998);
        // 2. 建立连接
        Socket accept = serverSocket.accept();
        // 3. 创建流对象
        InputStream inputStream = accept.getInputStream();
        // 3.1 获取输入流,读取文件数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        // 3.2 创建输出流,保存到本地
        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        // 4. 读写数据
        byte[] b = new byte[1024 * 8];
        int len;
        while ((len = bufferedInputStream.read(b)) != -1) {
            bufferedOutputStream.write(b, 0, len);
        }
        //5. 关闭资源
        bufferedOutputStream.close();
        bufferedInputStream.close();
        accept.close();
        System.out.println("文件已保存!");
    }
}
