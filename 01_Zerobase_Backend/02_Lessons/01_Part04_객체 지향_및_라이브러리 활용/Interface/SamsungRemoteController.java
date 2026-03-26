package Interface;

public class SamsungRemoteController implements RemoteController {
    public void ListenMusic() {
        System.out.println("음악 듣기");
    }

    @Override
    public void turnOn() {
        System.out.println("삼성티비의 전원 켜기");
    }

    @Override
    public void turnOff() {
        System.out.println("삼성티비의 전원 끄기");
    }
}
