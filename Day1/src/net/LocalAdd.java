package net;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author lwf
 * @title: LocalAdd
 * @projectName Day1
 * @description: TODO
 * @date 2020/10/1021:22
 */
public class LocalAdd {
    public static void main(String[] args) throws UnknownHostException {
        Inet4Address address= (Inet4Address) Inet4Address.getLocalHost();
        System.out.println(address.getHostAddress());
    }
}
