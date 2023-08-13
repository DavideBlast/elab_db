package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Trasporto {
    private final Integer hashEconomia;
    private final Float percorrenzaMediaPendolare;
    private final Float autoProCapite;
    
    public Trasporto(Integer hashEconomia, Float percorrenzaMediaPendolare, Float autoProCapite) {
        this.hashEconomia = hashEconomia;
        this.percorrenzaMediaPendolare = percorrenzaMediaPendolare;
        this.autoProCapite = autoProCapite;
    }
    
    public Integer getHashEconomia() {
        return hashEconomia;
    }

    public Float getPercorrenzaMediaPendolare() {
        return percorrenzaMediaPendolare;
    }

    public Float getAutoProCapite() {
        return autoProCapite;
    }

    @Override
    public String toString() {
        return "Trasporto [hashEconomia=" + hashEconomia + ", percorrenzaMediaPendolare=" + percorrenzaMediaPendolare
                + ", autoProCapite=" + autoProCapite + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hashEconomia == null) ? 0 : hashEconomia.hashCode());
        result = prime * result + ((percorrenzaMediaPendolare == null) ? 0 : percorrenzaMediaPendolare.hashCode());
        result = prime * result + ((autoProCapite == null) ? 0 : autoProCapite.hashCode());
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
        Trasporto other = (Trasporto) obj;
        if (hashEconomia == null) {
            if (other.hashEconomia != null)
                return false;
        } else if (!hashEconomia.equals(other.hashEconomia))
            return false;
        if (percorrenzaMediaPendolare == null) {
            if (other.percorrenzaMediaPendolare != null)
                return false;
        } else if (!percorrenzaMediaPendolare.equals(other.percorrenzaMediaPendolare))
            return false;
        if (autoProCapite == null) {
            if (other.autoProCapite != null)
                return false;
        } else if (!autoProCapite.equals(other.autoProCapite))
            return false;
        return true;
    }
}
