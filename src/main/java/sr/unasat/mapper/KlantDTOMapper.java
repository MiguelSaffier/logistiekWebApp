package sr.unasat.mapper;

import org.jvnet.hk2.annotations.Service;
import sr.unasat.dto.KlantDTO;
import sr.unasat.entity.Klant;

import java.util.function.Function;

@Service
public class KlantDTOMapper implements Function<Klant, KlantDTO> {


    @Override
    public KlantDTO apply(Klant klant) {
        return new KlantDTO(klant.getId(), klant.getVoornaam(), klant.getAchternaam(), klant.getAdres(), klant.getTelefoon());
    }
}
