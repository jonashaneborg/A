package no.hvl.dat250.jpa.basicexample;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Pincode {
    private int pincode;
    private int count;
    @OneToOne
    private CreditCard creditCard;

    public Pincode(){

    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
