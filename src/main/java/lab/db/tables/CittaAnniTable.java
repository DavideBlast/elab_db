package lab.db.tables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lab.db.Table;
import lab.model.CittaAnno;

public class CittaAnniTable implements Table<CittaAnno, Integer> {

    public static final String TABLE_NAME = "citta_anni";
    private final Connection connection; 

    public CittaAnniTable(final Connection connection) {
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
                    "idCitta int NOT NULL FOREIGN KEY REFERENCES Citta," +
                    "anno int NOT NULL FOREIGN KEY REFERENCES Anni," + 
                    "punteggioAmbiente int NOT NULL CHECK (punteggioAmbiente > 0)," +
                    "punteggioTrasporto int NOT NULL CHECK (punteggioTrasporto > 0)," +
                    "punteggioEconomia int NOT NULL CHECK (punteggioEconomia > 0)," +
                    "punteggioSanita int NOT NULL CHECK (punteggioSanita > 0)," +
                    "punteggioIstruzione int NOT NULL CHECK (punteggioIstruzione > 0)," +
                    "PRIMARY KEY(idCitta, anno)" + 
                ")");
            return true;
        } catch (final SQLException e) {
            // 3. Handle possible SQLExceptions
            return false;
        }
    }

    @Override
    public boolean dropTable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dropTable'");
    }

    @Override
    public Optional<CittaAnno> findByPrimaryKey(Integer primaryKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrimaryKey'");
    }

    @Override
    public List<CittaAnno> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean save(CittaAnno value) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(CittaAnno updatedValue) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer primaryKey) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}