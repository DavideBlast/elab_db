package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Sanita {
    private final Integer hashSanita;
    private final Float aspettativaVita;
    private final Float postiLettoProCapite;
    
    public Sanita(Integer hashSanita, Float aspettativaVita, Float postiLettoProCapite) {
        this.hashSanita = hashSanita;
        this.aspettativaVita = aspettativaVita;
        this.postiLettoProCapite = postiLettoProCapite;
    }

    public Integer getHashSanita() {
        return hashSanita;
    }

    public Float getAspettativaVita() {
        return aspettativaVita;
    }

    public Float getPostiLettoProCapite() {
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
        result = prime * result + ((hashSanita == null) ? 0 : hashSanita.hashCode());
        result = prime * result + ((aspettativaVita == null) ? 0 : aspettativaVita.hashCode());
        result = prime * result + ((postiLettoProCapite == null) ? 0 : postiLettoProCapite.hashCode());
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
        if (hashSanita == null) {
            if (other.hashSanita != null)
                return false;
        } else if (!hashSanita.equals(other.hashSanita))
            return false;
        if (aspettativaVita == null) {
            if (other.aspettativaVita != null)
                return false;
        } else if (!aspettativaVita.equals(other.aspettativaVita))
            return false;
        if (postiLettoProCapite == null) {
            if (other.postiLettoProCapite != null)
                return false;
        } else if (!postiLettoProCapite.equals(other.postiLettoProCapite))
            return false;
        return true;
    }
}
