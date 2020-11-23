package com.kk.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
/**
 *
 * @author 柯神_
 * @date 2020-11-23 17:57:43
 * @param [args]
 * @return void
 * udp,不需要连接服务器
*/
    public static void main(String[] args) throws IOException {

        //1.建一个DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket();

        //-- 建一个需要发送的包 --
        String msg = "你好,柯神_";
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("localhost"), 9999);

        //2.发送包
        datagramSocket.send(datagramPacket);
        System.out.println("客户端：快递已发货");
    }
}
