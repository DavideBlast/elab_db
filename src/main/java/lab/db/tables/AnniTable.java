package lab.db.tables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lab.db.Table;
import lab.model.Anno;

public class AnniTable implements Table<Anno, Integer> {

    public static final String TABLE_NAME = "Anni";
    private final Connection connection; 

    public AnniTable(final Connection connection) {
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
                    "anno int PRIMARY KEY" +
                ")");
            return true;
        } catch (final SQLException e) {
            // 3. Handle possible SQLExceptions
            return false;
        }
    }

    @Override
    public boolean dropTable() {
        throw new UnsupportedOperationException("Unimplemented method 'dropTable'");
    }

    @Override
    public Optional<Anno> findByPrimaryKey(Integer primaryKey) {
        throw new UnsupportedOperationException("Unimplemented method 'findByPrimaryKey'");
    }

    @Override
    public List<Anno> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean save(Anno value) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(Anno updatedValue) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer primaryKey) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}