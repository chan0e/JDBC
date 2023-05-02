import java.util.List;

public class App {

    public static void main(String[] args) {
        Passengerlist list = new Passengerlist();
        List<Passenger> passengers = list.getData();

        System.out.println(passengers);


    }
}
