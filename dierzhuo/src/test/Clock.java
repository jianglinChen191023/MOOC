package test;

/**
 * @author jianglinchen
 * @description 时钟
 * @date 2020/5/27 / 14:30
 */
public class Clock {

    private Display hour = new Display(24);
    private Display minute = new Display(60);

    public Clock() {
    }

    public void start() {
        while (true) {
            minute.increase();
            if (minute.getValue() == 0) {
                hour.increase();
            }

            System.out.printf("%02d : %02d\n", hour.getValue(), minute.getValue());
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.start();
    }
}
