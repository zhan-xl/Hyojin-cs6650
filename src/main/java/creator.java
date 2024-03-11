import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Channel;

//public class creator {
//    private static final String QUEUE_NAME = "skiersQueue";
//
//    public static void main(String[] args) throws Exception {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("ec2-18-236-175-10.us-west-2.compute.amazonaws.com");
//        factory.setPort(5672);
//        factory.setPassword("password");
//        factory.setUsername("admin");
//        try (Connection connection = factory.newConnection();
//             Channel channel = connection.createChannel()) {
//            // Declare a queue
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            System.out.println("Queue '" + QUEUE_NAME + "' created successfully.");
//        }
//    }
// this class is for testing purpose
public class creator {
    private static final String QUEUE_NAME = "skiersQueue";

    public static void main(String[] args) throws Exception {
        String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classpath);
        connectToRabbitMQ();
    }

    public static void connectToRabbitMQ() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("ec2-35-166-235-163.us-west-2.compute.amazonaws.com");
        factory.setPort(5672);
        factory.setPassword("password");
        factory.setUsername("admin");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // Declare a queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            byte[] payLoad = "queue test message".getBytes();
            channel.basicPublish("", QUEUE_NAME, null, payLoad);

            System.out.println("Queue '" + QUEUE_NAME + "' created successfully.");
        }
    }
}


