package com.kk.tcp;

import java.io.*;
import java.net.Socket;

public class TCPClientFile {
/**
 *
 * @author 柯神_
 * @date 2020-11-23 16:55:50
 * @param [args]
 * @return void
*/
    public static void main(String[] args) throws IOException {
        // 1.创建流对象
        // 1.1 创建输入流,读取本地文件
        FileInputStream fileInputStream = new FileInputStream("D:\\Users\\蜘蛛啊全是腿儿\\Pictures\\Camera Roll\\timg (2).jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // 1.2 创建输出流,写到服务端
        Socket socket = new Socket("127.0.0.1", 9998);
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos   = new BufferedOutputStream(outputStream);

        //2.写出数据
        byte[] b  = new byte[1024 * 8 ];
        int len ;
        while (( len  = bufferedInputStream.read(b))!=-1) {
            bos.write(b, 0, len);
            bos.flush();
        }
        System.out.println("文件发送完毕");
        // 3.释放资源
        bos.close();
        socket.close();
        bufferedInputStream.close();
        System.out.println("文件上传完毕!");
    }
}
