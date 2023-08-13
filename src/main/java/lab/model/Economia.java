package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Economia {
    private final Integer hashEconomia;
    private final Float pilprocapite;
    private final Integer stipendioMedio;
    private final Float tassoDisoccupazione;
    
    public Economia(Integer hashEconomia, Float pilprocapite, Integer stipendioMedio, Float tassoDisoccupazione) {
        this.hashEconomia = hashEconomia;
        this.pilprocapite = pilprocapite;
        this.stipendioMedio = stipendioMedio;
        this.tassoDisoccupazione = tassoDisoccupazione;
    }

    public Integer getHashEconomia() {
        return hashEconomia;
    }

    public Float getPilprocapite() {
        return pilprocapite;
    }

    public Integer getStipendioMedio() {
        return stipendioMedio;
    }

    public Float getTassoDisoccupazione() {
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
        result = prime * result + ((hashEconomia == null) ? 0 : hashEconomia.hashCode());
        result = prime * result + ((pilprocapite == null) ? 0 : pilprocapite.hashCode());
        result = prime * result + ((stipendioMedio == null) ? 0 : stipendioMedio.hashCode());
        result = prime * result + ((tassoDisoccupazione == null) ? 0 : tassoDisoccupazione.hashCode());
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
        if (hashEconomia == null) {
            if (other.hashEconomia != null)
                return false;
        } else if (!hashEconomia.equals(other.hashEconomia))
            return false;
        if (pilprocapite == null) {
            if (other.pilprocapite != null)
                return false;
        } else if (!pilprocapite.equals(other.pilprocapite))
            return false;
        if (stipendioMedio == null) {
            if (other.stipendioMedio != null)
                return false;
        } else if (!stipendioMedio.equals(other.stipendioMedio))
            return false;
        if (tassoDisoccupazione == null) {
            if (other.tassoDisoccupazione != null)
                return false;
        } else if (!tassoDisoccupazione.equals(other.tassoDisoccupazione))
            return false;
        return true;
    }
}
