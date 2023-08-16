package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Trasporto {
    private final int hashEconomia;
    private final float percorrenzaMediaPendolare;
    private final float autoProCapite;
    
    public Trasporto(int hashEconomia, float percorrenzaMediaPendolare, float autoProCapite) {
        this.hashEconomia = hashEconomia;
        this.percorrenzaMediaPendolare = percorrenzaMediaPendolare;
        this.autoProCapite = autoProCapite;
    }
    
    public int getHashEconomia() {
        return hashEconomia;
    }

    public float getPercorrenzaMediaPendolare() {
        return percorrenzaMediaPendolare;
    }

    public float getAutoProCapite() {
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
        result = prime * result + hashEconomia;
        result = prime * result + Float.floatToIntBits(percorrenzaMediaPendolare);
        result = prime * result + Float.floatToIntBits(autoProCapite);
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
        if (hashEconomia != other.hashEconomia)
            return false;
        if (Float.floatToIntBits(percorrenzaMediaPendolare) != Float.floatToIntBits(other.percorrenzaMediaPendolare))
            return false;
        if (Float.floatToIntBits(autoProCapite) != Float.floatToIntBits(other.autoProCapite))
            return false;
        return true;
    }
    
}
