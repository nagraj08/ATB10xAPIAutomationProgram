package in.co.courage.ex01_RA_Basics;

public class APITesting003NoDesignPattern {
    public void Step1() {
        System.out.println("Step1");
    }
    public void Step2() {
        System.out.println("Step2");
    }
    public void Step3(String param1) {
        System.out.println(param1);
    }

    public static void main(String[] args) {
        APITesting003NoDesignPattern nd = new APITesting003NoDesignPattern();
        nd.Step1();
        nd.Step2();
        nd.Step3("Nagraj");
    }
}
