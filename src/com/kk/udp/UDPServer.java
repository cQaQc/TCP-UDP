package com.kk.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
/**
 *
 * @author 柯神_
 * @date 2020-11-23 17:59:21
 * @param [args]
 * @return void
*/
    public static void main(String[] args) throws IOException {
        System.out.println("server：在等待收货...");

        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        while (true){
        //接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        datagramSocket.receive(datagramPacket);//阻塞式接收数据

        String s = new String(datagramPacket.getData(),0, datagramPacket.getLength());// 重新组装接收到的数据，即：将字节转换成字符串
        System.out.println(s);
        }
    }
}
