package org.wruthless;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetInfo {

    public static void main(String[] args) throws Exception {

        InetAddress ip;
        ip = InetAddress.getLocalHost();
        System.out.printf("%s%s%n", "IP Address: ", ip.getHostAddress());

        NetworkInterface network = NetworkInterface.getByInetAddress(ip);

        // Subnet mask
        InetAddress localHost = Inet4Address.getLocalHost();

        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
        System.out.printf("%s%s%n", "Subnet Mask: ",
                networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength());


        // MAC Address
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {

            NetworkInterface ni = networkInterfaces.nextElement();
            byte[] hardwareAddress = ni.getHardwareAddress();

            if (hardwareAddress != null) {
                String[] hexFormat = new String[hardwareAddress.length];

                for (int i = 0; i < hardwareAddress.length; i++) {
                    hexFormat[i] = String.format("%02X", hardwareAddress[i]);
                }
                System.out.println(String.join("-", hexFormat));
            }
        }

    } // main()


} // end NetInfo{}

