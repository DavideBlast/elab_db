package lab.model;

public class Zona {

    private final int idZona;
    private final int idCitta;
    private final String nome;
    private float costoMedioMq;
    private int numeroImmobili;
    
    public Zona(int idZona, int idCitta, String nome, float costoMedioMq, int numeroImmobili) {
        this.idZona = idZona;
        this.idCitta = idCitta;
        this.nome = nome;
        this.costoMedioMq = costoMedioMq;
        this.numeroImmobili = numeroImmobili;
    }

    public int getIdZona() {
        return idZona;
    }

    public int getIdCitta() {
        return idCitta;
    }

    public String getNome() {
        return nome;
    }

    public float getCostoMedioMq() {
        return costoMedioMq;
    }

    public void setCostoMedioMq(float costoMedioMq) {
        this.costoMedioMq = costoMedioMq;
    }

    public int getNumeroImmobili() {
        return numeroImmobili;
    }

    public void setNumeroImmobili(int numeroImmobili) {
        this.numeroImmobili = numeroImmobili;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idZona;
        result = prime * result + idCitta;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + Float.floatToIntBits(costoMedioMq);
        result = prime * result + numeroImmobili;
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
        Zona other = (Zona) obj;
        if (idZona != other.idZona)
            return false;
        if (idCitta != other.idCitta)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Float.floatToIntBits(costoMedioMq) != Float.floatToIntBits(other.costoMedioMq))
            return false;
        if (numeroImmobili != other.numeroImmobili)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Zona [idZona=" + idZona + ", idCitta=" + idCitta + ", nome=" + nome + ", costoMedioMq=" + costoMedioMq
                + ", numeroImmobili=" + numeroImmobili + "]";
    }
}