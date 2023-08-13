package lab.db.tables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lab.db.Table;
import lab.model.Immobile;

public class ImmobiliTable implements Table<Immobile, Integer> {

    public static final String TABLE_NAME = "Immobili";
    private final Connection connection; 

    public ImmobiliTable(final Connection connection) {
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
                    "idImmobile NOT NULL," +
                    "idZona NOT NULL FOREIGN KEY REFERENCES Zone," + 
                    "metriQuadri NOT NULL CHECK (metriQuadri > 0)," +
                    "classeEnergetica classe energetica CHECK(classe energetica in (’A+’, ’A’, ’B’, ’C’, ’D’, ’E’,’F’, ’G’))," +
                    "annoCostruzione int CHECK (annoCostruzione > 0)," +
                    "via varchar NOT NULL," +
                    "numeroCivico int NOT NULL," +
                    "tipoImmobile tipo immobile NOT NULL CHECK(tipo immobile in (’Appartamento’, ’Villa’, ’Stanza’))," +
                    "numeroInterno int," +
                    "piano int," +
                    "numeroStanze int CHECK (numeroStanze > 0)," +
                    "numeroConquilini int," +
                    "PRIMARY KEY(idImmobile, idCitta, idZona)" +
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
    public Optional<Immobile> findByPrimaryKey(Integer primaryKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrimaryKey'");
    }

    @Override
    public List<Immobile> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean save(Immobile value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(Immobile updatedValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer primaryKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}