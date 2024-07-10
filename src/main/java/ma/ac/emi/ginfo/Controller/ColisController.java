package ma.ac.emi.ginfo.Controller;


import ma.ac.emi.ginfo.Service.ColisService;
import ma.ac.emi.ginfo.model.Colis;
import ma.ac.emi.ginfo.model.Facteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "colis")
public class ColisController {

    @Autowired
    private final ColisService colisService;

    //the constructor run bydefault
    public ColisController(ColisService colisService) {
        this.colisService = colisService;
    }


    @GetMapping  //to get from server
    public List<Colis> getColis(){
        return colisService.getColis();
    }



    @GetMapping (path = "{colisId}") //to get from server
    public Colis getColis(@PathVariable("colisId") Long colisId){
        return colisService.getColis(colisId);
    }

    @PostMapping //to push into server
    public void registerNewColis(@RequestBody Colis colis){ //it will take it from server and deal ith it as a Colis
        colisService.addNewColis(colis);
    }

    @DeleteMapping(path = "{colisId}")
    public void deleteColis(@PathVariable("colisId") Long colisId){
        colisService.deleteColis(colisId);
    }

    @PutMapping(path = "{colisId}")
    public void updateColis(@PathVariable("colisId") Long colisId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String date){

        Facteur f1 = new Facteur(name,"test1","test1","test1","test1");
        LocalDate ld = LocalDate.of(2023,2,Integer.parseInt(date));
        colisService.updateColis(colisId,ld,f1);

    }
}
