package application.operations;

import java.util.List;
import java.util.Optional;

public interface Operation {

    String getQuery(Optional<List<Object>> args);

}