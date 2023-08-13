package lab.model;

import java.util.Objects;

public class Asta {
    private final int idAnnuncio;
    private final int idImmobile;
    private final String email;
    private final int dataCreazione;
    private final int prezzoMinimo;
    private final int rialzoMinimo;
    private final int depositoCauzionale;
    private final int dataFine;

    public Asta(final int idAnnuncio, final int idImmobile, final String email, final int dataCreazione, final int prezzoMinimo, final int rialzoMinimo,
            final int depositoCauzionale, final int dataFine) {
        this.idAnnuncio = idAnnuncio;
        this.idImmobile = idImmobile;
        this.email = Objects.requireNonNull(email);
        this.dataCreazione = dataCreazione;
        this.prezzoMinimo = prezzoMinimo;
        this.rialzoMinimo = rialzoMinimo;
        this.depositoCauzionale = depositoCauzionale;
        this.dataFine = dataFine;
    }

    public int getIdAnnuncio() {
        return idAnnuncio;
    }

    public int getIdImmobile() {
        return idImmobile;
    }

    public String getEmail() {
        return email;
    }

    public int getDataCreazione() {
        return dataCreazione;
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
        return "Asta [idAnnuncio=" + idAnnuncio + ", idImmobile=" + idImmobile + ", email=" + email + ", dataCreazione="
                + dataCreazione + ", prezzoMinimo=" + prezzoMinimo + ", rialzoMinimo=" + rialzoMinimo
                + ", depositoCauzionale=" + depositoCauzionale + ", dataFine=" + dataFine + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idAnnuncio;
        result = prime * result + idImmobile;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + dataCreazione;
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
        if (idAnnuncio != other.idAnnuncio)
            return false;
        if (idImmobile != other.idImmobile)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (dataCreazione != other.dataCreazione)
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
