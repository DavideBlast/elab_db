package application.operations;

import java.util.List;
import java.util.Optional;

public class OpFactory {

    public Operation createOp7() {
        final int idZona = 1;
        return new Operation() {
            
            @Override
            public String getQuery(Optional<List<Object>> args) {
                return args.isPresent() ? "SELECT I.* " +
                    "FROM immobili I JOIN annunci_utente A ON (I.idImmobile = A.idImmobile " +
                    "AND A.statoAnnuncio = 'Attivo' AND I.idZona = " + (Integer) (args.get().get(0)) + " ) " +
                    "ORDER BY dataCreazione DESC" : 
                    "SELECT I.* " +
                    "FROM immobili I JOIN annunci_utente A ON (I.idImmobile = A.idImmobile " +
                    "AND A.statoAnnuncio = 'Attivo' AND I.idZona = " + idZona + " ) " +
                    "ORDER BY dataCreazione DESC";
            }

            @Override
            public List<String> getInputNames() {
                return List.of("idZona");
            }

            @Override
            public List<Tipo> getInputTypes() {
                return List.of(Tipo.INT);
            }

            @Override
            public List<Object> translateInput(List<String> inputs) {
                return List.of(Integer.parseInt(inputs.get(0)));
            }
        };
    }

    public Operation createOp24() {
        return new Operation() {

            @Override
            public String getQuery(Optional<List<Object>> args) {

                return "SET @newHashAmbiente = floor(in_pm25media*10)*1001 + floor(in_percentualeSpazioVerdeUrbano*10);" + 
                       "SET @newHashEconomia = floor((in_tassoDisoccupazione * 10)) * 7239535 + floor((in_PILProCapite / 1000)) * 8035 + floor((in_stipendioMedio - 300));" + 
                       "SET @newHashIstruzione = floor((in_numeroUniversita * 10)) * 1002001 + floor((in_percentualeDiplomati * 10)) * 1001 + floor((in_percentualeLaureati * 10));" +
                       "SET @newHashSanita = floor((in_postiLettoProCapite * 10)) * 501 + floor((in_aspettativaVita * 10 - 500));" +  
                       "SET @newHashTrasporto = floor((in_autoProCapite * 100)) * 151 + in_percorrenzaMediaPendolare;" + 
                       "IF NOT EXISTS (" + 
                       "SELECT 1" + 
                       "FROM Ambiente" + 
                       "WHERE hashAmbiente = @newHashAmbiente" + 
                       ") THEN" + 
                       "INSERT INTO Ambiente (hashAmbiente, pm25media, percentualeSpazioVerdeUrbano)" + 
                       "VALUES (@newHashAmbiente, in_pm25media, in_percentualeSpazioVerdeUrbano);" + 
                       "END IF;" + 
                       "IF NOT EXISTS (" + 
                       "SELECT 1" + 
                       "FROM Economia" + 
                       "WHERE hashEconomia = @newHashEconomia" + 
                       ") THEN" + 
                       "INSERT INTO Economia (hashEconomia, tassoDisoccupazione, PILProCapite, stipendioMedio)" + 
                       "VALUES (@newHashEconomia, in_tassoDisoccupazione, in_PILProCapite, in_stipendioMedio);" + 
                       "END IF;" + 
                       "IF NOT EXISTS (" + 
                       "SELECT 1" + 
                       "FROM Istruzione" + 
                       "WHERE hashIstruzione = @newHashIstruzione" + 
                       ") THEN" + 
                       "INSERT INTO Istruzione (hashIstruzione, percentualeLaureati, percentualeDiplomati, numeroUniversita)" + 
                       "VALUES (@newHashIstruzione, in_percentualeLaureati, in_percentualeDiplomati, in_numeroUniversita);" + 
                       "END IF;" + 
                       "IF NOT EXISTS (" + 
                       "SELECT 1" + 
                       "FROM Sanita" + 
                       "WHERE hashSanita = @newHashSanita" + 
                       ") THEN" + 
                       "INSERT INTO Sanita (hashSanita, postiLettoProCapite, aspettativaVita)" + 
                       "VALUES (@newHashSanita, in_postiLettoProCapite, in_aspettativaVita);" + 
                       "END IF;" + 
                       "IF NOT EXISTS (" + 
                       "SELECT 1" + 
                       "FROM Trasporto" + 
                       "WHERE hashTrasporto = @newHashTrasporto" + 
                       ") THEN" + 
                       "INSERT INTO Trasporto (hashTrasporto, percorrenzaMediaPendolare, autoProCapite)" + 
                       "VALUES (@newHashTrasporto, in_percorrenzaMediaPendolare, in_autoProCapite);" + 
                       "END IF;" + 
                       "SET @punteggioAmbiente = " + ((10 - (Float) args.get().get(2) / 5) + (Float) args.get().get(3) > 30 ? 10 : (Float) args.get().get(3) / 3) / 2 + ";" +
                       "SET @punteggioEconomia =  " + ((Float) args.get().get(4) / 25000 + 26 / 5 + (Integer) args.get().get(5) / 2000 + 5 - (Float) args.get().get(6) * 8 / 11 + 130 / 11) / 3 + ";" +
                       "SET @punteggioIstruzione = " + ((Float) args.get().get(7) * 4 / 25 + 2 / 5 + (Float) args.get().get(8) * 4 / 35 + 2 / 7 + (Integer) args.get().get(9) * 4 / 45 + 14 / 3) / 3 + ";" +
                       "SET @punteggioSanita = " + ((Float) args.get().get(10) * 2 / 5 - 24 + (Float) args.get().get(11) * 40 / 7 + 10 / 7) / 2 + ";" +
                       "SET @punteggioTrasporto = " + ( - (Float) args.get().get(12) * 4 / 15 + 38 / 3 + - (Float) args.get().get(13) * 40 / 7 + 90 / 7) / 2 + ";" +
                       "INSERT INTO citta_anni" +
                       "(idCitta, anno, punteggioAmbiente, punteggioTrasporto, punteggioEconomia, punteggioSanita, punteggioIstruzione, hashAmbiente, hashEconomia, hashIstruzione, hashSanita, hashTrasporto) " + 
                       "VALUES (,,,,,,,,,,,)";
            }

            @Override
            public List<String> getInputNames() {
                return List.of("idCitta",
                               "anno",
                               "pm25media",
                               "percentualeSpazioVerdeUrbano",
                               "pilprocapite",
                               "stipendioMedio",
                               "tassoDisoccupazione",
                               "percentualeLaureati",
                               "percentualeDiplomati",
                               "numeroUniversita",
                               "aspettativaVita",
                               "postiLettoProCapite",
                               "percorrenzaMediaPendolare",
                               "autoProCapite");
            }

            @Override
            public List<Tipo> getInputTypes() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getInputTypes'");
            }

            @Override
            public List<Object> translateInput(List<String> inputs) {
                return List.of(Integer.parseInt(inputs.get(0)),     //idCitta
                               Integer.parseInt(inputs.get(1)),    //anno
                               Float.parseFloat(inputs.get(2)),    //pm25media
                               Float.parseFloat(inputs.get(3)),    //percentualeSpazioVerdeUrbano
                               Float.parseFloat(inputs.get(4)),    //pilprocapite
                               Integer.parseInt(inputs.get(5)),    //stipendioMedio
                               Float.parseFloat(inputs.get(6)),    //tassoDisoccupazione
                               Float.parseFloat(inputs.get(7)),    //percentualeLaureati
                               Float.parseFloat(inputs.get(8)),    //percentualeDiplomati
                               Integer.parseInt(inputs.get(9)),    //numeroUniversita
                               Float.parseFloat(inputs.get(10)),   //aspettativaVita
                               Float.parseFloat(inputs.get(11)),   //postiLettoProCapite
                               Float.parseFloat(inputs.get(12)),   //percorrenzaMediaPendolare
                               Float.parseFloat(inputs.get(13)));  //autoProCapite
            }
            
        };
    }
    
}

