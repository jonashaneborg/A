package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "banking";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
            for (Person person : personList) {
            System.out.println(person);
         }
         System.out.println("Size: " + personList.size());

        // create new todo
        em.getTransaction().begin();

        Person Tellev = new Person();
        Tellev.setName("Jarle");

        Address address = new Address();
        address.setStreet("Heien");
        address.setNumber(3);

        Tellev.addAddress(address);
        address.addPerson(Tellev);

        CreditCard card = new CreditCard();
        card.setBalance(1000);
        card.setNumber(100);
        card.setNumber(43214321);
        Tellev.addCreditCard(card);
        card.setPerson(Tellev);

        Pincode code = new Pincode();
        code.setPincode(1234);
        code.setCount(5);

        card.setPincode(code);

        Bank dank = new Bank();
        dank.setName("dank");
        dank.addCreditcard(card);
        card.setBank(dank);



        em.persist(Tellev);
        em.persist(address);
        em.persist(card);
        em.persist(dank);

        em.getTransaction().commit();

        em.close();
    }
}
