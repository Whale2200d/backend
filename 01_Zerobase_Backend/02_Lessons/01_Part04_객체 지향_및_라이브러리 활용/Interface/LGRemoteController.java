package Interface;

public class LGRemoteController implements RemoteController, PickupPhone {
    @Override
    public void pickupPhone() {
        System.out.println("전화 받기");
    }

    @Override
    public void turnOn() {
        System.out.println("엘지티비의 전원 켜기");
    }

    @Override
    public void turnOff() {
        System.out.println("엘지티비의 전원 끄기");
    }
}
