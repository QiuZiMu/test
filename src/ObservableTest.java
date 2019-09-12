import java.util.Observable;
import java.util.Observer;

class InventoryData extends Observable {
    private int valuableProductNum;
    private int normalProductNum;

    public void setCurrentData(int valuableProductNum,int normalProductNum){
        this.normalProductNum=normalProductNum;
        this.valuableProductNum=valuableProductNum;
        statusChange();
    }

    public void statusChange(){
        setChanged();
        notifyObservers();
    }

    public int getValuableProductNum() {
        return valuableProductNum;
    }

    public int getNormalProductNum() {
        return normalProductNum;
    }
}

class ManagerOberserver implements Observer {
    private Observable observable;
    private int valuableProductNum;
    private int normalProductNum;

    public ManagerOberserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }
    public void display(){
        System.out.println(valuableProductNum+" "+normalProductNum);
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof InventoryData) {
            InventoryData inventoryData = (InventoryData) o;
            this.normalProductNum = inventoryData.getNormalProductNum();
            this.valuableProductNum = inventoryData.getValuableProductNum();
            display();
        }
    }
}

public class ObservableTest {
    public static void main(String[] args) {
        InventoryData inventoryData=new InventoryData();
        ManagerOberserver managerOberserver=new ManagerOberserver(inventoryData);
        inventoryData.setCurrentData(11,22);
        managerOberserver.display();
        inventoryData.setCurrentData(10,23);
        managerOberserver.display();
    }
}
