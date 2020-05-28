package test;

/**
 * @author jianglinchen
 * @description 钟点
 * @date 2020/5/27 / 14:25
 */
public class Display {

    private int value = 0;
    private int limit = 0;

    public Display() {
    }

    public Display(Integer limit) {
        this.limit = limit;
    }

    public void increase() {
        this.value++;
        if (this.value == this.limit) {
            this.value = 0;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Display(int limit) {
        this.limit = limit;
    }

    public static void main(String[] args) {
        Display display = new Display(24);
        // 无限循环
        for (; ; ) {
            display.increase();
            System.out.println(display.getValue());
        }
    }
}