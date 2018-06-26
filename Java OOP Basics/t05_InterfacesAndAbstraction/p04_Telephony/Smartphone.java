package t05_InterfacesAndAbstraction.p04_Telephony;

public class Smartphone implements Callable, Browsable {

    @Override
    public void browseWeb(String URL) {
        for (int i = 0; i < URL.length(); i++) {
            if (Character.isDigit(URL.charAt(i))) {
                throw new IllegalArgumentException("Invalid URL!");
            }
        }
        System.out.printf("Browsing: %s!%n", URL);
    }

    @Override
    public void callPhone(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException("Invalid number!");
            }
        }
        System.out.printf("Calling... %s%n", number);
    }
}
