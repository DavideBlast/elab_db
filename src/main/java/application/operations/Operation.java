package application.operations;

import java.util.List;
import java.util.Optional;

public interface Operation {

    String getQuery(Optional<List<Object>> args);

    List<String> getInputNames();

    List<Tipo> getInputTypes();

    public enum Tipo {
        INT("int"),
        DOUBLE("double"),
        STRING("string"),
        MISCELLANEOUS("miscellaneous");

        private String tipo;

        private Tipo(final String tipo) {
            this.tipo = tipo;
        }

        public String toString() {
            return this.tipo;
        }
    }
}