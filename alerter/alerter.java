public class alerter {
    static int failedCount = 0;
    static void alertInCelsius(float fahrenheit) {
        RequestAlert alert = new AlertNetwork();
        float celsius = (fahrenheit - 32) * 5 / 9;
        int returnCode = alert.sendAlert(celsius);
        if (returnCode != 200) {
            failedCount += 1;
        }
    }
}