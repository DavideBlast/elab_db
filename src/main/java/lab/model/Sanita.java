package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Sanita {
    private final int hashSanita;
    private final float aspettativaVita;
    private final float postiLettoProCapite;
    
    public Sanita(int hashSanita, float aspettativaVita, float postiLettoProCapite) {
        this.hashSanita = hashSanita;
        this.aspettativaVita = aspettativaVita;
        this.postiLettoProCapite = postiLettoProCapite;
    }

    public int getHashSanita() {
        return hashSanita;
    }

    public float getAspettativaVita() {
        return aspettativaVita;
    }

    public float getPostiLettoProCapite() {
        return postiLettoProCapite;
    }

    @Override
    public String toString() {
        return "Sanita [hashSanita=" + hashSanita + ", aspettativaVita=" + aspettativaVita + ", postiLettoProCapite="
                + postiLettoProCapite + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hashSanita;
        result = prime * result + Float.floatToIntBits(aspettativaVita);
        result = prime * result + Float.floatToIntBits(postiLettoProCapite);
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
        Sanita other = (Sanita) obj;
        if (hashSanita != other.hashSanita)
            return false;
        if (Float.floatToIntBits(aspettativaVita) != Float.floatToIntBits(other.aspettativaVita))
            return false;
        if (Float.floatToIntBits(postiLettoProCapite) != Float.floatToIntBits(other.postiLettoProCapite))
            return false;
        return true;
    }
}
