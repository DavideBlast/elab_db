package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Ambiente {
    private final Integer hashAmbiente;
    private final Float pm25media;
    private final Float percentualeSpazioVerdeUrbano;

    public Ambiente(Integer hashAmbiente, Float pm25media, Float percentualeSpazioVerdeUrbano) {
        this.hashAmbiente = hashAmbiente;
        this.pm25media = pm25media;
        this.percentualeSpazioVerdeUrbano = percentualeSpazioVerdeUrbano;
    }

    public Integer getHashAmbiente() {
        return hashAmbiente;
    }

    public Float getPm25media() {
        return pm25media;
    }

    public Float getPercentualeSpazioVerdeUrbano() {
        return percentualeSpazioVerdeUrbano;
    }

    @Override
    public String toString() {
        return "Ambiente [hashAmbiente=" + hashAmbiente + ", pm25media=" + pm25media + ", percentualeSpazioVerdeUrbano="
                + percentualeSpazioVerdeUrbano + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hashAmbiente == null) ? 0 : hashAmbiente.hashCode());
        result = prime * result + ((pm25media == null) ? 0 : pm25media.hashCode());
        result = prime * result
                + ((percentualeSpazioVerdeUrbano == null) ? 0 : percentualeSpazioVerdeUrbano.hashCode());
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
        Ambiente other = (Ambiente) obj;
        if (hashAmbiente == null) {
            if (other.hashAmbiente != null)
                return false;
        } else if (!hashAmbiente.equals(other.hashAmbiente))
            return false;
        if (pm25media == null) {
            if (other.pm25media != null)
                return false;
        } else if (!pm25media.equals(other.pm25media))
            return false;
        if (percentualeSpazioVerdeUrbano == null) {
            if (other.percentualeSpazioVerdeUrbano != null)
                return false;
        } else if (!percentualeSpazioVerdeUrbano.equals(other.percentualeSpazioVerdeUrbano))
            return false;
        return true;
    }

    
}