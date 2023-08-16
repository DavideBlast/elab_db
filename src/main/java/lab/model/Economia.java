package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Economia {
    private final int hashEconomia;
    private final float pilprocapite;
    private final int stipendioMedio;
    private final float tassoDisoccupazione;
    
    public Economia(int hashEconomia, float pilprocapite, int stipendioMedio, float tassoDisoccupazione) {
        this.hashEconomia = hashEconomia;
        this.pilprocapite = pilprocapite;
        this.stipendioMedio = stipendioMedio;
        this.tassoDisoccupazione = tassoDisoccupazione;
    }

    public int getHashEconomia() {
        return hashEconomia;
    }

    public float getPilprocapite() {
        return pilprocapite;
    }

    public int getStipendioMedio() {
        return stipendioMedio;
    }

    public float getTassoDisoccupazione() {
        return tassoDisoccupazione;
    }

    @Override
    public String toString() {
        return "Economia [hashEconomia=" + hashEconomia + ", pilprocapite=" + pilprocapite + ", stipendioMedio="
                + stipendioMedio + ", tassoDisoccupazione=" + tassoDisoccupazione + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hashEconomia;
        result = prime * result + Float.floatToIntBits(pilprocapite);
        result = prime * result + stipendioMedio;
        result = prime * result + Float.floatToIntBits(tassoDisoccupazione);
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
        Economia other = (Economia) obj;
        if (hashEconomia != other.hashEconomia)
            return false;
        if (Float.floatToIntBits(pilprocapite) != Float.floatToIntBits(other.pilprocapite))
            return false;
        if (stipendioMedio != other.stipendioMedio)
            return false;
        if (Float.floatToIntBits(tassoDisoccupazione) != Float.floatToIntBits(other.tassoDisoccupazione))
            return false;
        return true;
    }

}
