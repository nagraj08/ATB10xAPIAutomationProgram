package in.co.courage.ex01_RA_Basics;

public class APITesting004DesignPattern {
    public APITesting004DesignPattern Step1() {
        System.out.println("Step1");
        return this;
    }
    public APITesting004DesignPattern Step2() {
        System.out.println("Step1");
        return this;
    }
    public APITesting004DesignPattern Step3(String param1) {
        System.out.println(param1);
        return this;
    }

    public static void main(String[] args) {
        APITesting004DesignPattern dp = new APITesting004DesignPattern();
        dp.Step1().Step2().Step3("Nagraj");
    }
}
