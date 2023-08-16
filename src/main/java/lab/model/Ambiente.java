package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Ambiente {
    private final int hashAmbiente;
    private final float pm25media;
    private final float percentualeSpazioVerdeUrbano;

    public Ambiente(int hashAmbiente, float pm25media, float percentualeSpazioVerdeUrbano) {
        this.hashAmbiente = hashAmbiente;
        this.pm25media = pm25media;
        this.percentualeSpazioVerdeUrbano = percentualeSpazioVerdeUrbano;
    }

    public int getHashAmbiente() {
        return hashAmbiente;
    }

    public float getPm25media() {
        return pm25media;
    }

    public float getPercentualeSpazioVerdeUrbano() {
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
        result = prime * result + hashAmbiente;
        result = prime * result + Float.floatToIntBits(pm25media);
        result = prime * result + Float.floatToIntBits(percentualeSpazioVerdeUrbano);
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
        if (hashAmbiente != other.hashAmbiente)
            return false;
        if (Float.floatToIntBits(pm25media) != Float.floatToIntBits(other.pm25media))
            return false;
        if (Float.floatToIntBits(percentualeSpazioVerdeUrbano) != Float
                .floatToIntBits(other.percentualeSpazioVerdeUrbano))
            return false;
        return true;
    }
    
}