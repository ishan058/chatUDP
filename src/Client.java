import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer;
        DatagramPacket packet;
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 12345;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String message = scanner.nextLine();
            buffer = message.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
            socket.send(packet);

            buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Server: " + message);
        }
    }
