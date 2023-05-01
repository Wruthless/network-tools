package org.wruthless;

import java.net.InetAddress;

/**
 * Get the IP Address and Hostname of the local machine.
 */
public class NetAddress {

    public static void main(String[] args) throws Exception{

        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.printf("%s%s%n", "IP Address: ", inetAddress.getHostAddress());
        System.out.printf("%s%s", "Host Name: ", inetAddress.getHostName());

    } // end main()

} // end NetAddress{}
