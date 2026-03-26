package Interface;

public class RemoteControllerTest {
    public static void main(String[] args) {
        // RemoteController remoteController = new RemoteController();
        // remoteController.turnOn();
        // remoteController.turnOff();

        System.out.println("====================");
        SamsungRemoteController samsungRemoteController = new SamsungRemoteController();
        samsungRemoteController.turnOn();
        samsungRemoteController.turnOff();
        samsungRemoteController.ListenMusic();

        System.out.println("====================");
        LGRemoteController lgRemoteController = new LGRemoteController();
        lgRemoteController.turnOn();
        lgRemoteController.turnOff();
        lgRemoteController.pickupPhone();
    }
}
