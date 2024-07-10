package ma.ac.emi.ginfo;

import ma.ac.emi.ginfo.Repository.*;
import ma.ac.emi.ginfo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ColisProjectApplication {

    @Autowired
    CentreLocalRepository cl;

    @Autowired
    CentreRegionalRepository cr;

    @Autowired
    FacteurRepository fc;

    @Autowired
    ColisRepository cs;

    @Autowired
    HabitantRepository hb;

    public static void main(String[] args) {
        SpringApplication.run(ColisProjectApplication.class, args);
    }


    @Bean
    public CommandLineRunner console() {
        return args -> {
            System.out.println("-------------------execution du programme -------------------------");

            System.out.println("-------------------CentreRegionel -------------------------");

            CentreRegional cr1 = new CentreRegional("ait melloul",41000,"sid mimoune","kasbah","Agadir");
            CentreRegional cr2 = new CentreRegional("doha",81000,"mosque","marjan","Marrakech");
            CentreRegional cr3 = new CentreRegional("drarga",47000,"tiran","tikiouine","Agadir");





            cr.saveAll(List.of(cr1,cr2,cr3));


            System.out.println("-------------------------------------------------------------------");



            System.out.println("-------------------CentreLocal -------------------------");

            CentreLocal cl1 = new CentreLocal("ait melloul",40000,"sid mimoune","kasbah","Agadir");
            CentreLocal cl2 = new CentreLocal("doha",80000,"mosque","marjan","Marrakech");
            CentreLocal cl3 = new CentreLocal("drarga",45000,"tiran","tikiouine","Agadir");

            cl1.setCentreParent(cr1);
            cl2.setCentreParent(cr1);
            cl3.setCentreParent(cr2);


            cl.saveAll(List.of(cl1,cl2,cl3));

            System.out.println("-------------------------------------------------------------------");



            System.out.println("-------------------Facteur-------------------------");

            Facteur f1 = new Facteur("test1","test1","test1","test1","test1");
            Facteur f2 = new Facteur("test2","test2","test2","test2","test2");
            Facteur f3 = new Facteur("test3","test3","test3","test3","test3");

            f1.setCentrePostal(cr1);
            f2.setCentrePostal(cr1);
            f3.setCentrePostal(cr2);

            fc.saveAll(List.of(f1,f2,f3));

            System.out.println("-------------------------------------------------------------------");

            System.out.println("-------------------habitant-------------------------");

            Habitant h1 = new Habitant("cap1@gmail.com","0606060606");
            Habitant h2 = new Habitant("cap2@gmail.com","0606060606");
            Habitant h3 = new Habitant("cap3@gmail.com","0606060606");




            hb.saveAll(List.of(h1,h2,h3));

            System.out.println("-------------------------------------------------------------------");




            System.out.println("-------------------Colis-------------------------");

            Colis c1 = new Colis(LocalDate.of(2015,12,3),LocalDate.of(2015,12,3));
            Colis c2 = new Colis(LocalDate.of(2015,12,3),LocalDate.of(2015,12,3));
            Colis c3 = new Colis(LocalDate.of(2015,12,3),LocalDate.of(2015,12,3));


            c1.setFacteur(f1);
            c2.setFacteur(f2);
            c3.setFacteur(f1);

            c1.setSender_habitant(h1);
            c2.setSender_habitant(h2);
            c3.setSender_habitant(h3);

            c1.setReceiver_habitant(h2);
            c2.setReceiver_habitant(h3);
            c3.setReceiver_habitant(h1);


            cs.saveAll(List.of(c1,c2,c3));

            System.out.println("-------------------------------------------------------------------");


        };
    }
}
