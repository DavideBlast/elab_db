package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Istruzione {

    private final Integer hashIstruzione;
    private final Float percentualeLaureati;
    private final Float percentualeDiplomati;
    private final Integer numeroUniversita;

    public Istruzione(Integer hashIstruzione, Float percentualeLaureati, Float percentualeDiplomati,
            Integer numeroUniversita) {
        this.hashIstruzione = hashIstruzione;
        this.percentualeLaureati = percentualeLaureati;
        this.percentualeDiplomati = percentualeDiplomati;
        this.numeroUniversita = numeroUniversita;
    }

    public Integer getHashIstruzione() {
        return hashIstruzione;
    }

    public Float getPercentualeLaureati() {
        return percentualeLaureati;
    }

    public Float getPercentualeDiplomati() {
        return percentualeDiplomati;
    }

    public Integer getNumeroUniversita() {
        return numeroUniversita;
    }

    @Override
    public String toString() {
        return "Istruzione [hashIstruzione=" + hashIstruzione + ", percentualeLaureati=" + percentualeLaureati
                + ", percentualeDiplomati=" + percentualeDiplomati + ", numeroUniversita=" + numeroUniversita + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hashIstruzione == null) ? 0 : hashIstruzione.hashCode());
        result = prime * result + ((percentualeLaureati == null) ? 0 : percentualeLaureati.hashCode());
        result = prime * result + ((percentualeDiplomati == null) ? 0 : percentualeDiplomati.hashCode());
        result = prime * result + ((numeroUniversita == null) ? 0 : numeroUniversita.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Istruzione other = (Istruzione) obj;
        if (hashIstruzione == null) {
            if (other.hashIstruzione != null)
                return false;
        } else if (!hashIstruzione.equals(other.hashIstruzione))
            return false;
        if (percentualeLaureati == null) {
            if (other.percentualeLaureati != null)
                return false;
        } else if (!percentualeLaureati.equals(other.percentualeLaureati))
            return false;
        if (percentualeDiplomati == null) {
            if (other.percentualeDiplomati != null)
                return false;
        } else if (!percentualeDiplomati.equals(other.percentualeDiplomati))
            return false;
        if (numeroUniversita == null) {
            if (other.numeroUniversita != null)
                return false;
        } else if (!numeroUniversita.equals(other.numeroUniversita))
            return false;
        return true;
    }
}
