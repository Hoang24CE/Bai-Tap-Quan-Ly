import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class ServerUDP {
    private static final int PORT = 12345;
    private static Set<ClientInfo> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(PORT);
        System.out.println("UDP Server is running on port " + PORT);

        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());
            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            ClientInfo newClient = new ClientInfo(address, port);
            clients.add(newClient);

            System.out.println("Received from " + address + ":" + port + " => " + message);

            // Broadcast message to all clients
            for (ClientInfo client : clients) {
                DatagramPacket sendPacket = new DatagramPacket(
                        message.getBytes(),
                        message.length(),
                        client.address,
                        client.port
                );
                socket.send(sendPacket);
            }
        }
    }

    static class ClientInfo {
        InetAddress address;
        int port;

        ClientInfo(InetAddress address, int port) {
            this.address = address;
            this.port = port;
        }

        @Override
        public int hashCode() {
            return address.hashCode() + port;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ClientInfo) {
                ClientInfo other = (ClientInfo) obj;
                return address.equals(other.address) && port == other.port;
            }
            return false;
        }
    }
}
