/**
 * @author jianglinchen
 * @description 自动售货机
 * @date 2020/5/1 / 23:10
 */
public class VendingMachine {

    int price = 80;
    int balance = f();
    int total;

    VendingMachine() {

    }

    VendingMachine(int balance) {
        this();
        this.showBalance();
    }

    int f() {
        return 20;
    }

    void setPrice(int price) {
        this.price = price;
        this.getFood();
    }

    void showPrompt() {
        System.out.println("Welcome");
    }

    void insertMoney(int amount) {
        balance = balance + amount;
        // 在成员函数的内部直接调用自己(this)的成员函数
        showBalance();
        this.showBalance();
    }

    void showBalance() {
        System.out.println(this.balance);
    }

    void getFood() {
        if (balance >= price) {
            System.out.println("here you are.");
            balance = balance - price;
            total = total + price;
        }
    }

    public static void main(String[] args) {
        // 创建一个类的对象
        VendingMachine vm = new VendingMachine();
        vm.showPrompt();
        vm.showBalance();
        vm.insertMoney(100);
        vm.getFood();
        vm.showBalance();
        VendingMachine vm1 = new VendingMachine(100);
        vm1.setPrice(20);
        vm.showBalance();
        vm1.showBalance();
    }
}
