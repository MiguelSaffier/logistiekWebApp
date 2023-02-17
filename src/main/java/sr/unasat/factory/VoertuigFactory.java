package sr.unasat.factory;

import sr.unasat.entity.VrachtWagen;

public class VoertuigFactory {

    public Voertuig getInstance(String voertuig) {

        if (voertuig.equalsIgnoreCase("VrachtWagen")) {
            return new VrachtWagen();
        } else {
            System.out.println(voertuig + " Bestaat niet!!");
            return null;
        }
    }

}
