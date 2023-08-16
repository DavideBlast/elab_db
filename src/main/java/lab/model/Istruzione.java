package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Istruzione {

    private final int hashIstruzione;
    private final float percentualeLaureati;
    private final float percentualeDiplomati;
    private final int numeroUniversita;

    public Istruzione(int hashIstruzione, float percentualeLaureati, float percentualeDiplomati,
            int numeroUniversita) {
        this.hashIstruzione = hashIstruzione;
        this.percentualeLaureati = percentualeLaureati;
        this.percentualeDiplomati = percentualeDiplomati;
        this.numeroUniversita = numeroUniversita;
    }

    public int getHashIstruzione() {
        return hashIstruzione;
    }

    public float getPercentualeLaureati() {
        return percentualeLaureati;
    }

    public float getPercentualeDiplomati() {
        return percentualeDiplomati;
    }

    public int getNumeroUniversita() {
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
        result = prime * result + hashIstruzione;
        result = prime * result + Float.floatToIntBits(percentualeLaureati);
        result = prime * result + Float.floatToIntBits(percentualeDiplomati);
        result = prime * result + numeroUniversita;
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
        if (hashIstruzione != other.hashIstruzione)
            return false;
        if (Float.floatToIntBits(percentualeLaureati) != Float.floatToIntBits(other.percentualeLaureati))
            return false;
        if (Float.floatToIntBits(percentualeDiplomati) != Float.floatToIntBits(other.percentualeDiplomati))
            return false;
        if (numeroUniversita != other.numeroUniversita)
            return false;
        return true;
    }
}
