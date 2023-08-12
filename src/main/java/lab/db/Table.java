package lab.db;

import java.util.List;
import java.util.Optional;

/**
 * Represents a database table, with rows represented by objects of type V
 * and primary key of type K.
 * @param <V> the type of the objects saved in the table
 * @param <K> the type of the primary key of the table
 */
public interface Table<V,K> {
    /**
     * @return the name of the table
     */
    String getTableName();
    
    /**
     * Creates the database table
     * @return false if the table could not be created
     */
    boolean createTable();
    
    /**
     * Drops the database table
     * @return false if the table could not be dropped
     */
    boolean dropTable();
    
    /**
     * Finds an object in the table with the given primary key
     * @param primaryKey the primary key used to search the object in the underlying database
     * @return an empty optional if there is no object with the given ID in the database
     */
    Optional<V> findByPrimaryKey(final K primaryKey);
    
    /**
     * @return a list with all the rows of the database 
     */
    List<V> findAll();
    
    /**
     * Saves an object to the database
     * @param value the object to save to the underlying database
     * @return false if the object could not be saved (e.g. an object with the same key
     *         is already present)
     */
    boolean save(final V value);
    
    /**
     * Updates an object 
     * @param updatedValue the object to update
     * @return false if the object could not be updated (e.g. there is not already an
     *         object with the given primary key in the database)
     */
    boolean update(final V updatedValue);
    
    /**
     * Deletes from the underlying database the row with the given primary key
     * @param primaryKey the primary key of the row to delete
     * @return false if the row could not be deleted
     */
    boolean delete(final K primaryKey);
}
