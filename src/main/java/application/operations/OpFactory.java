package application.operations;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import application.App;

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

            @Override
            public Optional<String> getUpdate(List<Object> args) {
                return Optional.empty();
            }
        };
    }

    public Operation createOp24() {
        return new Operation() {

            @Override
            public String getQuery(Optional<List<Object>> args) {
                return "SELECT * FROM citta_anni";
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
                               Integer.parseInt(inputs.get(4)),    //pilprocapite
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

            @Override
            public Optional<String> getUpdate(List<Object> args) {
                var in_pm25media = (Float) args.get(2);
                var in_percentualeSpazioVerdeUrbano = (Float) args.get(3);
                var in_PILProCapite = (Integer) args.get(4);
                var in_stipendioMedio = (Integer) args.get(5);
                var in_tassoDisoccupazione = (Float) args.get(6);
                var in_percentualeLaureati = (Float) args.get(7);
                var in_percentualeDiplomati = (Float) args.get(8);
                var in_numeroUniversita = (Integer) args.get(9);
                var in_aspettativaVita = (Float) args.get(10);
                var in_postiLettoProCapite = (Float) args.get(11);
                var in_percorrenzaMediaPendolare = (Float) args.get(12);
                var in_autoProCapite = (Float) args.get(13);

                int newHashAmbiente = ((int) in_pm25media.floatValue()*10)*1001 + (int) in_percentualeSpazioVerdeUrbano.floatValue()*10;
                long newHashEconomia = ((long) in_tassoDisoccupazione.floatValue()*10)*7239535 + ((long) in_PILProCapite.floatValue()/1000)*8035 + (long) in_stipendioMedio.floatValue()-300;
                int newHashIstruzione = ((int) in_numeroUniversita.floatValue()*10)*1002001 + ((int) in_percentualeDiplomati.floatValue()*10)*1001 + (int) in_percentualeLaureati.floatValue()*10;
                int newHashSanita = ((int) in_postiLettoProCapite.floatValue()*10)*501 + ((int) in_aspettativaVita.floatValue()*10-500);
                int newHashTrasporto = ((int) in_autoProCapite.floatValue()*100)*151 + (int) in_percorrenzaMediaPendolare.floatValue()*100;

                float punteggioAmbiente = ((10 - in_pm25media / 5) + in_percentualeSpazioVerdeUrbano > 30 ? 10 : in_percentualeSpazioVerdeUrbano / 3) / 2;
                float punteggioEconomia = (in_PILProCapite / 25000 + 26 / 5 + in_stipendioMedio / 2000 + 5 - in_tassoDisoccupazione * 8 / 11 + 130 / 11) / 3;
                float punteggioIstruzione = (in_percentualeLaureati * 4 / 25 + 2 / 5 + in_percentualeDiplomati * 4 / 35 + 2 / 7 + in_numeroUniversita * 4 / 45 + 14 / 3) / 3;
                float punteggioSanita = (in_aspettativaVita * 2 / 5 - 24 + in_postiLettoProCapite * 40 / 7 + 10 / 7) / 2;
                float punteggioTrasporto = ( - in_percorrenzaMediaPendolare * 4 / 15 + 38 / 3 + - in_autoProCapite * 40 / 7 + 90 / 7) / 2;

                String output = "";

                try {
                    PreparedStatement statement = App.getConnection().prepareStatement("select count(*) from ambiente where hashAmbiente = " + newHashAmbiente);
                    ResultSet resultSet = statement.executeQuery("select count(*) from ambiente where hashAmbiente = " + newHashAmbiente);
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Ambiente (hashAmbiente, pm25media, percentualeSpazioVerdeUrbano) \n" + 
                                "VALUES (" + newHashAmbiente + ", " +  in_pm25media + " , " + in_percentualeSpazioVerdeUrbano + " ); \n";
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from economia where hashEconomia = " + newHashEconomia);
                    resultSet = statement.executeQuery("select count(*) from economia where hashEconomia = " + newHashEconomia);
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Economia (hashEconomia, PILProCapite, stipendioMedio, tassoDisoccupazione) \n" + 
                                "VALUES (" + newHashEconomia + ", " + in_PILProCapite + " , " + in_stipendioMedio + " , " + in_tassoDisoccupazione + " ); \n"; 
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from istruzione where hashIstruzione = " + newHashIstruzione);
                    resultSet = statement.executeQuery("select count(*) from istruzione where hashIstruzione = " + newHashIstruzione);
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Istruzione (hashIstruzione, percentualeLaureati, percentualeDiplomati, numeroUniversita) \n" + 
                                "VALUES (" + newHashIstruzione + ", " + in_percentualeLaureati + " , " + in_percentualeDiplomati + " , " + in_numeroUniversita + " );\n ";
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from sanita where hashSanita = " + newHashSanita);
                    resultSet = statement.executeQuery("select count(*) from sanita where hashSanita = " + newHashSanita);
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Sanita (hashSanita, postiLettoProCapite, aspettativaVita) \n" + 
                                "VALUES (" + newHashSanita + ", " + in_postiLettoProCapite + " , " + in_aspettativaVita + " );\n ";
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from trasporto where hashTrasporto = " + newHashTrasporto);
                    resultSet = statement.executeQuery("select count(*) from trasporto where hashTrasporto = " + newHashTrasporto);
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Trasporto (hashTrasporto, percorrenzaMediaPendolare, autoProCapite) \n" + 
                                "VALUES (" + newHashTrasporto + ", " +  in_percorrenzaMediaPendolare + " , " + in_autoProCapite + " );\n ";
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return Optional.of(output +
                    "INSERT INTO citta_anni " +
                    "(idCitta, anno, punteggioAmbiente, punteggioTrasporto, punteggioEconomia, punteggioSanita, punteggioIstruzione, hashAmbiente, hashEconomia, hashIstruzione, hashSanita, hashTrasporto) " + 
                    "VALUES ("+ (Integer) args.get(0) +"," + (Integer) args.get(1) +", " + punteggioAmbiente + ", " + punteggioTrasporto + ", " + punteggioEconomia + ", " + punteggioSanita + ", " + punteggioIstruzione + ", " + newHashAmbiente + ", " + newHashEconomia + ", " + newHashIstruzione + ", " + newHashSanita + ", " + newHashTrasporto + ");"
                );
            }
            
        };
    }
    
}

