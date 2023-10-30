package utilities;

public class reusableMethods {
public static void bekle(int saniye ){
    try {
        Thread.sleep(saniye * 1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

}
