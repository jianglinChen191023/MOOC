/**
 * 第一周作业
 * 温馨提示：
 * <p>
 * 1.本次作业属于Online Judge题目，提交后由系统即时判分。
 * <p>
 * 2.学生可以在作业截止时间之前不限次数提交答案，系统将取其中的最高分作为最终成绩。
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }

}

/**
 * 注意，在创建和做完运算后应该化简分数为最简形式。如2/4应该被化简为1/2。
 */
class Fraction {

    /**
     * 分子
     */
    int a;

    /**
     * 分母
     */
    int b;

    Fraction() {

    }

    Fraction(int a, int b) {
        this();
        this.a = a;
        this.b = b;
        this.Simplify();
    }

    /**
     * 化简
     */
    void Simplify() {
        int c = 0;
        if (this.a > this.b) {
            c = this.a % this.b;
            if (c == 0) {
                this.a = this.a / this.b;
                this.b = 1;
            } else {
                this.a = this.a / c;
                this.b = this.b / c;
            }

        }

        if (this.a < this.b) {
            c = this.b % this.a;
            if (c == 0) {
                this.b = this.b / this.a;
                this.a = 1;
            } else {
                this.a = this.a / c;
                this.b = this.b / c;
            }
        }

        if (this.a == this.b) {
            this.a = 1;
            this.b = 1;
        }
    }

    /**
     * 将分数转换为double
     */
    double toDouble() {
        // 先将int转为double,结果是double, 最后赋值; 如果2个int计算,结果会是int 再转double, 最后赋值
        double c = (double) this.a / this.b;

        return c;
    }

    /**
     * 将自己的分数和r的分数相加，产生一个新的Fraction的对象。注意小学四年级学过两个分数如何相加的哈。
     *
     * @param r
     * @return
     */
    Fraction plus(Fraction r) {
        int a = (this.a * r.b) + (r.a * this.b);
        int b = this.b * r.b;

        Fraction fraction = new Fraction(a, b);
        return fraction;
    }

    /**
     * 将自己的分数和r的分数相乘，产生一个新的Fraction的对象。
     *
     * @param r
     * @return
     */
    Fraction multiply(Fraction r) {
        int a = this.a * r.a;
        int b = this.b * r.b;
        Fraction fraction = new Fraction(a, b);
        return fraction;
    }

    /**
     * 将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。如果分数是1/1，应该输出1。
     * 当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出。
     */
    void print() {
        toDouble();
        if (this.b == 1) {
            System.out.println(a);
        } else {
            System.out.println(this.a + "/" + this.b);
        }
    }

}
