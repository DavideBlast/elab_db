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
import lab.model.Asta;

public final class AsteTable implements Table<Asta, Integer> {
    public static final String TABLE_NAME = "aste";

     private final Connection connection; 

     public AsteTable(final Connection connection) {
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
                         "idAsta int NOT NULL," +
                         "idImmobile int NOT NULL FOREIGN KEY REFERENCES immobili," + 
                         "email varchar NOT NULL FOREIGN KEY REFERENCES utenti," + 
                         "dataCreazione datetime NOT NULL," +
                         "prezzoMinimo int NOT NULL CHECK (prezzoMinimo > 0)," +
                         "rialzoMinimo int NOT NULL CHECK (rialzoMinimo > 0)," +
                         "depositoCauzionale int NOT NULL" +
                            "CHECK (depositoCauzionale > 0)," +
                         "dataFine datetime NOT NULL," +
                         "PRIMARY KEY(idAnnuncio, idImmobile, e-mail)" +
                     ")");
             return true;
         } catch (final SQLException e) {
             // 3. Handle possible SQLExceptions
             return false;
         }
     }

     @Override
     public Optional<Asta> findByPrimaryKey(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     /**
      * Given a ResultSet read all the students in it and collects them in a List
      * @param resultSet a ResultSet from which the Student(s) will be extracted
      * @return a List of all the students in the ResultSet
      */
     private List<Asta> readStudentsFromResultSet(final ResultSet resultSet) {
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
        List<Asta> list = new ArrayList<>();
        
        try {
            while (resultSet.next()) {
                Asta asta = new Asta(resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7),
                    resultSet.getDate(8));
                list.add(asta);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
     }

     @Override
     public List<Asta> findAll() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean dropTable() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean save(final Asta utente) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean delete(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean update(final Asta utente) {
         throw new UnsupportedOperationException("TODO");
     }
    
}
