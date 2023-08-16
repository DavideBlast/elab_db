package lab.db.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lab.utils.Utils;
import lab.db.Table;
import lab.model.AnnuncioUtente;
import lab.model.AnnuncioUtente.StatoAnnuncio;
import lab.model.AnnuncioUtente.TipoAnnuncio;

public final class AnnunciTable implements Table<AnnuncioUtente, Integer> {
    public static final String TABLE_NAME = "annunci_utente";

     private final Connection connection; 

     public AnnunciTable(final Connection connection) {
         this.connection = Objects.requireNonNull(connection);
     }

     @Override
     public String getTableName() {
         return TABLE_NAME;
     }

     @Override
     public boolean createTable() {
         // 1. Create the statement from the open connection inside a try-with-resources
         try (final Statement statement = this.connection.createStatement()) {
             // 2. Execute the statement with the given query
             statement.executeUpdate(
                 "CREATE TABLE " + TABLE_NAME + " (" +
                         "idAnnuncio int NOT NULL," +
                         "idImmobile int NOT NULL FOREIGN KEY REFERENCES Immobili," + 
                         "E-mail varchar NOT NULL FOREIGN KEY REFERENCES Utenti," + 
                         "StatoAnnuncio stato_annuncio NOT NULL" + //
                            "CHECK(stato_annuncio in ('Attivo', 'Inattivo'))," +
                         "DataCreazione datetime NOT NULL," +
                         "TipoAnnuncioUtente tipo_annuncio NOT NULL" +
                            "CHECK(tipo annuncio in ('Vendita', 'Affitto'))," +
                         "CostoMensile int NOT NULL CHECK (CostoMensile > 0)," +
                         "Prezzo int NOT NULL CHECK (Prezzo > 0)," +
                         "PRIMARY KEY(idAnnuncio, idImmobile, e-mail)" +
                     ")");
             return true;
         } catch (final SQLException e) {
             // 3. Handle possible SQLExceptions
             return false;
         }
     }

     @Override
     public Optional<AnnuncioUtente> findByPrimaryKey(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     /**
      * Given a ResultSet read all the students in it and collects them in a List
      * @param resultSet a ResultSet from which the Student(s) will be extracted
      * @return a List of all the students in the ResultSet
      */
     private List<AnnuncioUtente> readStudentsFromResultSet(final ResultSet resultSet) {
        // Create an empty list, then
        // Inside a loop you should:
        //      1. Call resultSet.next() to advance the pointer and check there are still rows to fetch
        //      2. Use the getter methods to get the value of the columns
        //      3. After retrieving all the data create a Student object
        //      4. Put the student in the List
        // Then return the list with all the found students

        // Helpful resources:
        // https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
        // https://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
        List<AnnuncioUtente> list = new ArrayList<>();
        
        try {
            while (resultSet.next()) {
                AnnuncioUtente annuncioUtente = new AnnuncioUtente(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getInt(4) == 0 ? StatoAnnuncio.ATTIVO : StatoAnnuncio.INATTIVO,
                    resultSet.getDate(5),
                    resultSet.getInt(6) == 0 ? TipoAnnuncio.AFFITTO : TipoAnnuncio.VENDITA,
                    resultSet.getInt(7) < 0 ? Optional.empty() : Optional.of(resultSet.getInt(7)),
                    resultSet.getInt(8) < 0 ? Optional.empty() : Optional.of(resultSet.getInt(8)));
                list.add(annuncioUtente);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
     }

     @Override
     public List<AnnuncioUtente> findAll() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean dropTable() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean save(final AnnuncioUtente utente) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean delete(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean update(final AnnuncioUtente utente) {
         throw new UnsupportedOperationException("TODO");
     }
    
}
