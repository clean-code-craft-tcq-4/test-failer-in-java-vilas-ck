public class AlertMain {
    public static void main(String[] args) {
        alerter.alertInCelsius(400.5f);
        assert(alerter.failedCount ==1);
        alerter.alertInCelsius(303.6f);
        assert(alerter.failedCount == 1);
        alerter.alertInCelsius(29.5f);
        assert(alerter.failedCount ==1);
        alerter.alertInCelsius(2000.5f);
        assert(alerter.failedCount == 2);
        alerter.alertInCelsius(-100.5f);
        assert(alerter.failedCount ==2);
        alerter.alertInCelsius(105f);
        assert(alerter.failedCount ==2);
        System.out.printf("%d failed alerts.\n", alerter.failedCount);
        System.out.println("All is well (maybe!)\n");
    }
}
