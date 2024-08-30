import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer x = new Random().nextInt(100);
        System.out.println(x.getClass());
    }
}