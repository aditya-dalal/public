package designPatternsNew.behavioural.chainOfResponsibility;

/**
 * Created by aditya.dalal on 16/03/18.
 */
public class COR {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.dispenseAmount(3900);
    }
}

interface DispenseChain {
    void setDispenseChain(DispenseChain dispenseChain);
    void dispenseAmount(int amt);
}

class DispenseChain2000 implements DispenseChain {

    DispenseChain chain;
    @Override
    public void setDispenseChain(DispenseChain dispenseChain) {
        this.chain = dispenseChain;
    }

    @Override
    public void dispenseAmount(int amt) {
        int num = amt/2000;
        if(num > 0)
            System.out.println("dispensing " + num + " of 2000");
        if(amt%2000 > 0)
            chain.dispenseAmount(amt%2000);
    }
}

class DispenseChain500 implements DispenseChain {

    DispenseChain chain;
    @Override
    public void setDispenseChain(DispenseChain dispenseChain) {
        this.chain = dispenseChain;
    }

    @Override
    public void dispenseAmount(int amt) {
        int num = amt/500;
        if(num > 0)
            System.out.println("dispensing " + num + " of 500");
        if(amt%500 > 0)
            chain.dispenseAmount(amt%500);
    }
}

class DispenseChain100 implements DispenseChain {

    DispenseChain chain;
    @Override
    public void setDispenseChain(DispenseChain dispenseChain) {
        this.chain = dispenseChain;
    }

    @Override
    public void dispenseAmount(int amt) {
        int num = amt/100;
        if(num > 0)
            System.out.println("dispensing " + num + " of 100");
        if(amt%100 > 0)
            chain.dispenseAmount(amt%100);
    }
}

class ATM {
    DispenseChain dispenseChain;
    public ATM() {
        DispenseChain d2k = new DispenseChain2000();
        DispenseChain d500 = new DispenseChain500();
        DispenseChain d100 = new DispenseChain100();
        dispenseChain = d2k;
        d2k.setDispenseChain(d500);
        d500.setDispenseChain(d100);
    }

    public void dispenseAmount(int amt) {
        dispenseChain.dispenseAmount(amt);
    }
}
