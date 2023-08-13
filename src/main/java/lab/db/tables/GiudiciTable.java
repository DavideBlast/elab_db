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
import lab.model.Giudice;

public final class GiudiciTable implements Table<Giudice, Integer> {
    public static final String TABLE_NAME = "Giudici";

     private final Connection connection; 

     public GiudiciTable(final Connection connection) {
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
                         "E-mail varchar PRIMARY KEY," +
                         "Telefono varchar CHECK (len(Telefono)=10)," + 
                         "Nome char(25) NOT NULL" +
                     ")");
             return true;
         } catch (final SQLException e) {
             // 3. Handle possible SQLExceptions
             return false;
         }
     }

     @Override
     public Optional<Giudice> findByPrimaryKey(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     /**
      * Given a ResultSet read all the students in it and collects them in a List
      * @param resultSet a ResultSet from which the Student(s) will be extracted
      * @return a List of all the students in the ResultSet
      */
     private List<Giudice> readStudentsFromResultSet(final ResultSet resultSet) {
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
        List<Giudice> list = new ArrayList<>();
        
        try {
            while (resultSet.next()) {
                Giudice giudice = new Giudice(resultSet.getString(1),
                    resultSet.getString(2) == null ? Optional.empty() : Optional.of(resultSet.getString(2)),
                    resultSet.getString(3));
                list.add(giudice);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
     }

     @Override
     public List<Giudice> findAll() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean dropTable() {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean save(final Giudice utente) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean delete(final Integer id) {
         throw new UnsupportedOperationException("TODO");
     }

     @Override
     public boolean update(final Giudice utente) {
         throw new UnsupportedOperationException("TODO");
     }
    
}
