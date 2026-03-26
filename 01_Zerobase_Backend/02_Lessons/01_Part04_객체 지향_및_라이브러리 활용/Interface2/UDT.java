package Interface2;

public class UDT extends Soldier implements IBS, RunMountain {

    @Override
    public void run() {
        System.out.println("UDT running");
    }

    @Override
    public void packingBag() {
        System.out.println("UDT packing Bag");
    }

    @Override
    public void runMountain() {
        System.out.println("UDT run Mountain");
    }

    @Override
    public void headCarrier() {
        System.out.println("UDT head Carrier");
    }

    @Override
    public void setBoat() {
        System.out.println("UDT set Boat");
    }
    
}
