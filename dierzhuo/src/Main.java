/**
 * @author jianglinchen
 * @description 第二周作业
 *
 * </p>
 * 1有秒计时的数字时钟（10分）
 * 题目内容：
 * 这一周的编程题是需要你在课程所给的时钟程序的基础上修改而成。但是我们并不直接给你时钟程序的代码
 * ，请根据视频自己输入时钟程序的Display和Clock类的代码，然后来做这个题目。
 * 我们需要给时钟程序加上一个表示秒的Display，然后为Clock增加以下public的成员函数：
 * <p>
 * public test.Clock(int hour, int minute, int second);
 * 用hour, minute和second初始化时间。
 * <p>
 * public void tick();
 * “嘀嗒”一下，时间走1秒。
 * <p>
 * public String toString();
 * 返回一个String的值，以“hh:mm:ss“的形式表示当前时间。这里每个数值都占据两位，不足两位时补0。如“00:01:22"。注意其中的冒号是西文的，不是中文的。
 * <p>
 * 提示：String.format()可以用和printf一样的方式来格式化一个字符串。
 * 另外写一个Main类，它的main函数为下面的样子，注意，必须原封不动地作为Main的main函数：
 * public static void main(String[] args) {
 * java.util.Scanner in = new java.util.Scanner(System.in);
 * test.Clock clock = new test.Clock(in.nextInt(), in.nextInt(), in.nextInt());
 * clock.tick();
 * System.out.println(clock);
 * in.close();
 * }
 * 注意！在提交的时候，把Main、Clock和Display三个类的代码合并在一起，其中Main类是public的，而Clock和Display类是没有修饰符的。另外，千万注意第一行不能有package语句。
 * <p>
 * 输入格式:
 * 采用给定的main函数无需考虑输入输出。
 * <p>
 * 输出格式：
 * 采用给定的main函数无需考虑输入输出。
 * <p>
 * 输入样例：
 * 采用给定的main函数无需考虑输入输出。
 * <p>
 * 输出样例：
 * 采用给定的main函数无需考虑输入输出。
 * <p>
 * 时间限制：500ms内存限制：32000kb
 * </p>
 * @date 2020/5/27 / 15:30
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
    }
}

class Display {
    private int value = 0;
    private int limit = 0;

    public void increase() {
        this.value++;
        if (this.value == this.limit) {
            this.value = 0;
        }
    }

    public Display(int value, int limit) {
        this.value = value;
        this.limit = limit;
    }

    public int getValue() {
        return value;
    }

}

class Clock {
    private Display hour;
    private Display minute;
    private Display second;

    //  用hour, minute和second初始化时间。
    public Clock(int hour, int minute, int second) {
        this.hour = new Display(hour, 24);
        this.minute = new Display(minute, 60);
        this.second = new Display(second, 60);
    }

    // “嘀嗒”一下，时间走1秒。
    public void tick() {
        this.second.increase();
        if (this.second.getValue() == 0) {
            this.minute.increase();
            if (this.minute.getValue() == 0) {
                this.hour.increase();
            }
        }
    }

    //     返回一个String的值，以“hh:mm:ss“的形式表示当前时间。
    //     这里每个数值都占据两位，不足两位时补0。如“00:01:22"。注意其中的冒号是西文的，不是中文的。
    @Override
    public String toString() {
        String format = String.format("%02d:%02d:%02d", hour.getValue(), minute.getValue(), second.getValue());
        return format;
    }
}
