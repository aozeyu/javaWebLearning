import com.example.demo4.*;

public class ObserverTest {
    public static void main(String[] args) {
        ToBeObserve beauty = new Beauty();
        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();

        beauty.addObserver(observerA);
        beauty.addObserver(observerB);

        beauty.notifyObserver("快来啊");
        System.out.println("----------");
        beauty.removeObserver(observerA);
        beauty.notifyObserver("快来啊");
    }
}
