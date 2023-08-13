package lab.model;

public class Asta extends Annuncio{
    private final int prezzoMinimo;
    private final int rialzoMinimo;
    private final int depositoCauzionale;
    private final int dataFine;

    public Asta(final int idAnnuncio, final int idImmobile, final String email, final int dataCreazione, final int prezzoMinimo, final int rialzoMinimo,
            final int depositoCauzionale, final int dataFine) {
        super(idAnnuncio, idImmobile, email, dataCreazione);
        this.prezzoMinimo = prezzoMinimo;
        this.rialzoMinimo = rialzoMinimo;
        this.depositoCauzionale = depositoCauzionale;
        this.dataFine = dataFine;
    }

    public int getIdAnnuncio() {
        return getIdAnnuncio();
    }

    public int getIdImmobile() {
        return getIdImmobile();
    }

    public String getEmail() {
        return getEmail();
    }

    public int getDataCreazione() {
        return getDataCreazione();
    }

    public int getPrezzoMinimo() {
        return prezzoMinimo;
    }

    public int getRialzoMinimo() {
        return rialzoMinimo;
    }

    public int getDepositoCauzionale() {
        return depositoCauzionale;
    }

    public int getDataFine() {
        return dataFine;
    }

    @Override
    public String toString() {
        return "Asta [idAnnuncio=" + getIdAnnuncio() + ", idImmobile=" + getIdImmobile() + ", email=" + getEmail() + ", dataCreazione="
                + getDataCreazione() + ", prezzoMinimo=" + prezzoMinimo + ", rialzoMinimo=" + rialzoMinimo
                + ", depositoCauzionale=" + depositoCauzionale + ", dataFine=" + dataFine + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getIdAnnuncio();
        result = prime * result + getIdImmobile();
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + getDataCreazione();
        result = prime * result + prezzoMinimo;
        result = prime * result + rialzoMinimo;
        result = prime * result + depositoCauzionale;
        result = prime * result + dataFine;
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
        Asta other = (Asta) obj;
        if (getIdAnnuncio() != other.getIdAnnuncio())
            return false;
        if (getIdImmobile() != other.getIdImmobile())
            return false;
        if (getEmail() == null) {
            if (other.getEmail() != null)
                return false;
        } else if (!getEmail().equals(other.getEmail()))
            return false;
        if (getDataCreazione() != other.getDataCreazione())
            return false;
        if (prezzoMinimo != other.prezzoMinimo)
            return false;
        if (rialzoMinimo != other.rialzoMinimo)
            return false;
        if (depositoCauzionale != other.depositoCauzionale)
            return false;
        if (dataFine != other.dataFine)
            return false;
        return true;
    }
}
