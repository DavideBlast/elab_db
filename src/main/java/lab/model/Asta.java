package lab.model;

import java.sql.Date;

public class Asta extends Annuncio{
    private final int prezzoMinimo;
    private final int rialzoMinimo;
    private final int depositoCauzionale;
    private final Date dataFine;

    public Asta(final int idAnnuncio, final int idImmobile, final String email, final Date dataCreazione, final int prezzoMinimo, final int rialzoMinimo,
            final int depositoCauzionale, final Date dataFine) {
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

    public Date getDataCreazione() {
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

    public Date getDataFine() {
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
        result = prime * result + prezzoMinimo;
        result = prime * result + rialzoMinimo;
        result = prime * result + depositoCauzionale;
        result = prime * result + ((dataFine == null) ? 0 : dataFine.hashCode());
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
        if (prezzoMinimo != other.prezzoMinimo)
            return false;
        if (rialzoMinimo != other.rialzoMinimo)
            return false;
        if (depositoCauzionale != other.depositoCauzionale)
            return false;
        if (dataFine == null) {
            if (other.dataFine != null)
                return false;
        } else if (!dataFine.equals(other.dataFine))
            return false;
        return true;
    }
}
