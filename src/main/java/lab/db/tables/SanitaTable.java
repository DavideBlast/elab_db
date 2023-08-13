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
import lab.model.Economia;
import lab.model.Sanita;

public final class SanitaTable implements Table <Sanita, Integer>{
    public static final String TABLE_NAME = "sanita";

    private final Connection connection; 

    public SanitaTable(final Connection connection) {
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
                        "hashSanita int NOT NULL PRIMARY KEY," +
                        "aspettativaVita float NOT NULL," + 
                        "postiLettoProCapite float NOT NULL," + 
                        "CONSTRAINT sanita_chk_1 CHECK ((aspettativaVita > 0))," + 
                        "CONSTRAINT sanita_chk_2 CHECK ((postiLettoProCapite > 0))" + 
                    ")");
            return true;
        } catch (final SQLException e) {
            // 3. Handle possible SQLExceptions
            return false;
        }
    }

     @Override
    public Optional<Sanita> findByPrimaryKey(Integer primaryKey) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<Sanita> findAll() {
         throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean dropTable() {
         throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean save(Sanita value) {
         throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean delete(Integer primaryKey) {
         throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean update(Sanita updatedValue) {
         throw new UnsupportedOperationException("TODO");
    }
}
