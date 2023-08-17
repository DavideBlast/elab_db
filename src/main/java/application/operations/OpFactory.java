package application.operations;

import java.util.List;
import java.util.Optional;


public class OpFactory {

    public OpFactory() {}

    public Operation createOp7() {
        return new Operation() {
            
            @Override
            public String getQuery(Optional<List<Object>> args) {
                return args.isPresent() ? "SELECT I.*" +
                    "FROM immobili I JOIN annunci_utente A ON (I.idImmobile = A.idImmobile" +
                    "AND A.statoAnnuncio = 'Attivo' AND I.idZona = " + (Integer) (args.get().get(0)) + ")" +
                    "ORDER BY dataCreazione DESC" : "Errore Op7";
            }
        };
    }
}


// SELECT I.*
// FROM immobili I JOIN annunci_utente A ON (I.idImmobile = A.idImmobile
// AND A.statoAnnuncio = 'Attivo' AND I.idZona = ?)
// ORDER BY dataCreazione DESC

