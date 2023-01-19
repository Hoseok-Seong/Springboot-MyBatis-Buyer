package shop.mtcoding.buyer.util;

import org.junit.jupiter.api.Test;

public class CookieTest {
    @Test
    public void parse_test() {
        String cookies = "remember=ssar; JSESSIONID=E393553755C95D63915E4BD7D89509FD";
        String arr[] = cookies.split(";");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        String username = arr[0].split("=")[1].trim();
        System.out.println(username);
    }
}
