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
import lab.model.Rialzo;

public final class RialziTable implements Table<Rialzo, Integer> {
    public static final String TABLE_NAME = "rialzi";

     private final Connection connection; 

     public RialziTable(final Connection connection) {
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
                         "prezzoAttuale int NOT NULL CHECK (prezzoAttuale > 0)," +
                         "email varchar(30) NOT NULL FOREIGN KEY REFERENCES utenti," + 
                         "idAnnuncio int NOT NULL FOREIGN KEY REFERENCES annunci_utente," + 
                         "dataRialzo datetime NOT NULL," +
                         "PRIMARY KEY(prezzoAttuale, e-mail, idAnnuncio)" +
                     ")");
             return true;
         } catch (final SQLException e) {
             // 3. Handle possible SQLExceptions
             return false;
         }
     }

     @Override
     public Optional<Rialzo> findByPrimaryKey(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     /**
      * Given a ResultSet read all the students in it and collects them in a List
      * @param resultSet a ResultSet from which the Student(s) will be extracted
      * @return a List of all the students in the ResultSet
      */
     private List<Rialzo> readStudentsFromResultSet(final ResultSet resultSet) {
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
        List<Rialzo> list = new ArrayList<>();
        
        try {
            while (resultSet.next()) {
                Rialzo rialzo = new Rialzo(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDate(4));
                list.add(rialzo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
     }

     @Override
     public List<Rialzo> findAll() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean dropTable() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean save(final Rialzo utente) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean delete(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean update(final Rialzo utente) {
         throw new UnsupportedOperationException("TODO");
     }
    
}
