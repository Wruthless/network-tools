package org.wruthless;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetInfoExtended {

    public static void main(String[] args) {

        try {
            System.out.printf("%s%s%n", "getLocalHost: ", InetAddress.getLocalHost().toString());
            System.out.printf("%s", "All addresses for local host:");

            InetAddress[] addr = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());

            for (InetAddress a : addr) {
                System.out.printf("%n%s", a.toString());
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            Enumeration<NetworkInterface> nicEnum = NetworkInterface.getNetworkInterfaces();

            while(nicEnum.hasMoreElements()) {
                NetworkInterface ni = nicEnum.nextElement();
                System.out.printf("%n%s%s", "Name: ", ni.getDisplayName());
                System.out.printf("%n%s%s%n", "Name: ", ni.getName());

                Enumeration<InetAddress> addrEnum = ni.getInetAddresses();

                while(addrEnum.hasMoreElements()) {
                    InetAddress ia = addrEnum.nextElement();
                    System.out.printf("%s", ia.getHostName());
                }
            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
