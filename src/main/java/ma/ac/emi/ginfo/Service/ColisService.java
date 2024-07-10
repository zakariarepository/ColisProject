package ma.ac.emi.ginfo.Service;


import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.Repository.ColisRepository;
import ma.ac.emi.ginfo.model.Colis;
import ma.ac.emi.ginfo.model.Facteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ColisService {

    private final ColisRepository colisRepository;

    @Autowired
    public ColisService(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    public List<Colis> getColis(){
        return colisRepository.findAll();
    }

    public Colis getColis(Long num){
        return colisRepository.findColisByNumero(num);
    }


    public void addNewColis(Colis colis) {
        Colis colisOptional = colisRepository.findColisByNumero(colis.getNumero());
        colisRepository.save(colis);
    }

    public void deleteColis(Long colisId) {
        boolean exists = colisRepository.existsById(colisId);
        if(!exists){
            throw new IllegalStateException("colis with id "+colisId+" doesn't exists");
        }
        colisRepository.deleteById(colisId);
    }

    @Transactional
    public void updateColis(Long colisId, LocalDate dateReception, Facteur facteur) {
        Colis colis=colisRepository.findById(colisId)
                .orElseThrow(()->new IllegalStateException("colis with id "+colisId+" doesn't exist"));
            colis.setDateReception(dateReception);

        }

}
