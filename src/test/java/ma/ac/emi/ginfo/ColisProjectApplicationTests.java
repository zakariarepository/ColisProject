package ma.ac.emi.ginfo;

import ma.ac.emi.ginfo.Repository.ColisRepository;
import ma.ac.emi.ginfo.model.Colis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ColisProjectApplicationTests {

    @Autowired
    ColisRepository colisRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void printAllColis(){
        Colis c1 = new Colis(LocalDate.of(2015,12,3),LocalDate.of(2015,12,3));
        Colis c2 = new Colis(LocalDate.of(2015,12,3),LocalDate.of(2015,12,3));
        Colis c3 = new Colis(LocalDate.of(2015,12,3),LocalDate.of(2015,12,3));


        colisRepository.saveAll(List.of(c1,c2,c3));
        System.out.println(colisRepository.findAll());
    }
}
