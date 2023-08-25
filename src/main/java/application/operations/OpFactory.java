package application.operations;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import application.App;

public class OpFactory {

    public Operation createOp2() {
        return new Operation(){

            private Iterator<Integer> idIterator = null;

			@Override
			public Optional<String> getUpdate(List<Object> args) {
                var in_metriQuadri = (Integer) args.get(0);
                var in_classeEnergetica = (String) args.get(1);
                var in_annoCostruzione = (Integer) args.get(2);
                var in_via = (String) args.get(3);
                var in_numeroCivico = (Integer) args.get(4);
                var in_tipoImmobile = (String) args.get(5);
                var in_numeroInterno = (in_tipoImmobile.equals("Appartamento")) ? (String) args.get(6) : "null";
                var in_piano = (in_tipoImmobile.equals("Appartamento")) ? (String) args.get(7) : "null";
                var in_numeroStanze = (in_tipoImmobile.equals("Appartamento") || in_tipoImmobile.equals("Villa")) ? (String) args.get(8) : "null";
                var in_numeroConquilini = (in_tipoImmobile.equals("Stanza")) ? (String) args.get(9) : "null";
                var in_tipoAnnuncioUtente = (String) args.get(10);
                var in_costoMensile = (in_tipoAnnuncioUtente.equals("Affitto")) ? (String) args.get(11) : "null";
                var in_prezzo = (in_tipoAnnuncioUtente.equals("Vendita")) ? (String) args.get(12) : "null";

                int in_idImmobile = 0;

                try {
                    String check = "select count(*) from immobili where via = '" + in_via + "' AND numeroCivico = " + in_numeroCivico;
                    String check2 = "select idImmobile from immobili where via = '" + in_via + "' AND numeroCivico = " + in_numeroCivico;
                    if(in_tipoImmobile.equals("Appartamento")){
                        check += " AND numeroInterno = " + in_numeroInterno;
                        check2 += " AND numeroInterno = " + in_numeroInterno;
                    }
                    PreparedStatement statement = App.getConnection().prepareStatement(check);
                    ResultSet resultSet = statement.executeQuery(check);
                    resultSet.next();
                    
                    if (resultSet.getInt(1) == 0) {
                        statement.executeUpdate("INSERT INTO immobili (idImmobile, idZona, metriQuadri, classeEnergetica, annoCostruzione, via, numeroCivico, tipoImmobile, numeroInterno, piano, numeroStanze, numeroConquilini) \n" + 
                                  "VALUES (default, 1, " + in_metriQuadri + ", '" + in_classeEnergetica + "', " + in_annoCostruzione + ", '" + in_via + "', " + in_numeroCivico + ", '" + in_tipoImmobile + "', " + in_numeroInterno + ", " + in_piano + ", " + in_numeroStanze + ", " + in_numeroConquilini + "); \n");
                    }
                    statement = App.getConnection().prepareStatement(check2);
                    resultSet = statement.executeQuery();
                    resultSet.next();

                    in_idImmobile = resultSet.getInt(1);

                    if(idIterator == null){
                        statement = App.getConnection().prepareStatement("select idAnnuncio from annunci_utente order by idAnnuncio desc limit 1");
                        resultSet = statement.executeQuery();
                        resultSet.next();

                        idIterator = new IDIterator(resultSet.getInt(1));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return Optional.of("INSERT INTO annunci_utente (idAnnuncio, idImmobile, email, statoAnnuncio, dataCreazione, tipoAnnuncioUtente, costoMensile, prezzo) \n" + 
                                    "VALUES (" + idIterator.next() + ", " + in_idImmobile + ", 'vittorio@gmail.com', 'Attivo', NOW(), '" + in_tipoAnnuncioUtente + "', " + in_costoMensile + ", " + in_prezzo + ");");
			}

			@Override
			public String getQuery(Optional<List<Object>> args) {
                return "SELECT * \n" +
                       "FROM annunci_utente \n" +
                       "ORDER BY idAnnuncio DESC \n" +
                       "LIMIT 1";
			}

			@Override
			public List<String> getInputNames() {
				return List.of("metriQuadri",
                               "classeEnergetica",
                               "annoCostruzione",
                               "via",
                               "numeroCivico",
                               "tipoImmobile",
                               "numeroInterno",
                               "piano",
                               "numeroStanze",
                               "numeroConquilini",
                               "tipoAnnuncioUtente",
                               "costoMensile",
                               "prezzo");
			}

			@Override
			public List<Object> translateInput(List<String> inputs) {
				return List.of(Integer.parseInt(inputs.get(0)),
                               inputs.get(1),
                               Integer.parseInt(inputs.get(2)),
                               inputs.get(3),
                               Integer.parseInt(inputs.get(4)),
                               inputs.get(5),
                               inputs.get(6),
                               inputs.get(7),
                               inputs.get(8),
                               inputs.get(9),
                               inputs.get(10),
                               inputs.get(11),
                               inputs.get(12));
			}
        };
    }

    public Operation createOp6() {
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
            public List<Object> translateInput(List<String> inputs) {
                return List.of(Integer.parseInt(inputs.get(0)));
            }

            @Override
            public Optional<String> getUpdate(List<Object> args) {
                return Optional.empty();
            }
        };
    }

    public Operation createOp11_12() {
        return new Operation() {

			@Override
			public Optional<String> getUpdate(List<Object> args) {
				return Optional.of("INSERT INTO Messaggi (timestamp, email, idAnnuncio, testo, mittente) \n" + 
                                   "VALUES (NOW(), 'vittorio@gmail.com', 1, '" + (String) args.get(0) + "', 'Richiedente')");
			}

			@Override
			public String getQuery(Optional<List<Object>> args) {
                return "SELECT testo, mittente, timestamp \n" +
                       "FROM messaggi \n" +
                       "WHERE email = 'vittorio@gmail.com' \n" +
                       "AND idAnnuncio = 1 \n" +
                       "ORDER BY timestamp";
			}

			@Override
			public List<String> getInputNames() {
				return List.of("Testo");
			}

			@Override
			public List<Object> translateInput(List<String> inputs) {
				return List.of(inputs.get(0));
			}
        };
    }

    public Operation createOp15() {
        return new Operation() {

            @Override
            public Optional<String> getUpdate(List<Object> args) {
                return Optional.empty();
            }

            @Override
            public String getQuery(Optional<List<Object>> args) {
                if (!args.isPresent()) {
                    return "SELECT 'perc_diff'";
                }

                var in_idImmobile = args.get().get(0);
                int idCitta = 0;
                double costoMedioMqCitta = 0;

                try {

                    PreparedStatement statement = App.getConnection().prepareStatement("select C.idCitta from (immobili I join zone Z on I.idZona = Z.idZona and I.idImmobile = " + in_idImmobile + ") join citta C on Z.idCitta = C.idCitta");
                    ResultSet resultSet = statement.executeQuery();
                    resultSet.next();
                    idCitta = resultSet.getInt(1);

                    statement = App.getConnection().prepareStatement("SELECT SUM(costoMedioMq*numeroImmobili) FROM zone WHERE idCitta = " + idCitta);
                    resultSet = statement.executeQuery();
                    resultSet.next();
                    var dividendo = resultSet.getDouble(1);
                    statement = App.getConnection().prepareStatement("SELECT SUM(numeroImmobili) FROM zone WHERE idCitta = " + idCitta);
                    resultSet = statement.executeQuery();
                    resultSet.next();
                    var divisore = resultSet.getDouble(1);
                    
                    costoMedioMqCitta = dividendo/divisore;

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return "SELECT ((prezzo/metriQuadri)- " + costoMedioMqCitta + ") * 100/ " + costoMedioMqCitta + " AS perc_diff " +
                        "FROM (immobili I JOIN annunci_utente A " +
                        "ON (A.idImmobile = I.idImmobile)) JOIN Zone Z " +
                        "ON (I.idZona = Z.idZona) JOIN Citta C " +
                        "ON (Z.idCitta = C.idCitta) " +
                        "WHERE A.idImmobile = " + in_idImmobile + " AND statoAnnuncio = 'Attivo'";
            }

            @Override
            public List<String> getInputNames() {
                return List.of("idImmobile");
            }

            @Override
            public List<Object> translateInput(List<String> inputs) {
                return List.of(Integer.parseInt(inputs.get(0)));
            }
            
        };
    }


    public Operation createOp18() {
        return new Operation(){

            @Override
            public Optional<String> getUpdate(List<Object> args) {
                return Optional.empty();
            }

            @Override
            public String getQuery(Optional<List<Object>> args) {
                if (!args.isPresent()) {
                    return "SELECT C.idCitta, C.nome, A.punteggioAmbiente , A.punteggioTrasporto , A.punteggioEconomia , A.punteggioSanita , A.punteggioIstruzione " +
                            "FROM (citta_anni A JOIN citta C on A.idCitta = C.idCitta) " +
                            "WHERE A.anno = 42069";
                }
                var in_anno = args.get().get(0);
                return "SELECT C.idCitta, C.nome, A.punteggioAmbiente , A.punteggioTrasporto , A.punteggioEconomia , A.punteggioSanita , A.punteggioIstruzione " +
                        "FROM (citta_anni A JOIN citta C on A.idCitta = C.idCitta) " +
                        "WHERE A.anno = " + in_anno +
                        " ORDER BY A.punteggioAmbiente + A.punteggioTrasporto + A.punteggioEconomia + A.punteggioSanita + A.punteggioIstruzione DESC " + 
                        "LIMIT 5";
            }

            @Override
            public List<String> getInputNames() {
                return List.of("anno");
            }

            @Override
            public List<Object> translateInput(List<String> inputs) {
                return List.of(Integer.parseInt(inputs.get(0)));
            }
            
        };
    }

    private class IDIterator implements Iterator<Integer> {

        private int current;

        protected IDIterator(final int current){
            this.current = current + 1;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return current++;
        }

    }

    public Operation createOp22() {
        return new Operation() {

            @Override
            public String getQuery(Optional<List<Object>> args) {
                if (!args.isPresent()) {
                    return "SELECT * FROM citta_anni";
                }
                return "SELECT * FROM citta_anni WHERE idCitta = " + args.get().get(0) + " AND anno = " + args.get().get(1);
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
                    ResultSet resultSet = statement.executeQuery();
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Ambiente (hashAmbiente, pm25media, percentualeSpazioVerdeUrbano) \n" + 
                                "VALUES (" + newHashAmbiente + ", " +  in_pm25media + " , " + in_percentualeSpazioVerdeUrbano + " ); \n";
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from economia where hashEconomia = " + newHashEconomia);
                    resultSet = statement.executeQuery();
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Economia (hashEconomia, PILProCapite, stipendioMedio, tassoDisoccupazione) \n" + 
                                "VALUES (" + newHashEconomia + ", " + in_PILProCapite + " , " + in_stipendioMedio + " , " + in_tassoDisoccupazione + " ); \n"; 
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from istruzione where hashIstruzione = " + newHashIstruzione);
                    resultSet = statement.executeQuery();
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Istruzione (hashIstruzione, percentualeLaureati, percentualeDiplomati, numeroUniversita) \n" + 
                                "VALUES (" + newHashIstruzione + ", " + in_percentualeLaureati + " , " + in_percentualeDiplomati + " , " + in_numeroUniversita + " );\n ";
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from sanita where hashSanita = " + newHashSanita);
                    resultSet = statement.executeQuery();
                    resultSet.next();
                    if (resultSet.getInt(1) == 0) {
                        output+="INSERT INTO Sanita (hashSanita, postiLettoProCapite, aspettativaVita) \n" + 
                                "VALUES (" + newHashSanita + ", " + in_postiLettoProCapite + " , " + in_aspettativaVita + " );\n ";
                    }

                    statement = App.getConnection().prepareStatement("select count(*) from trasporto where hashTrasporto = " + newHashTrasporto);
                    resultSet = statement.executeQuery();
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

