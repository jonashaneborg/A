package no.hvl.dat250.jpa.basicexample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    @OneToMany
    private List<CreditCard> creditCards;

    @ManyToMany
    private List<Address> addresses;

    public Person(){
        addresses = new ArrayList<Address>();
        creditCards = new ArrayList<CreditCard>();
    }

    public void addAddress(Address address){
        addresses.add(address);
    }

    public List<Address> getAddresses(){
        return addresses;
    }

    public void addCreditCard(CreditCard creditCard){
        creditCards.add(creditCard);
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public void setCreditCards(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    @Override
    public String toString() {
        String cards = "";
        for (CreditCard c : creditCards)
            cards += c.getNumber() + ", ";
        String addr = "";
        for (Address a : addresses)
            addr += a.getStreet() + " " + a.getNumber();
        return "Person [name=" + name + ", cards=" + cards + " addresses=" + addr
                + "]";
    }
}


