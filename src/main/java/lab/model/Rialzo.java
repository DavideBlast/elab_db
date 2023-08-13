package lab.model;

import java.util.Objects;

public class Rialzo {
    private final int prezzoAttuale;
    private final int idAnnuncio;
    private final String email;
    private final int dataRialzo;

    public Rialzo(int prezzoAttuale, int idAnnuncio, String email, int dataRialzo) {
        this.prezzoAttuale = prezzoAttuale;
        this.idAnnuncio = idAnnuncio;
        this.email = email;
        this.dataRialzo = Objects.requireNonNull(dataRialzo);
    }

    public int getPrezzoAttuale() {
        return prezzoAttuale;
    }

    public int getIdAnnuncio() {
        return idAnnuncio;
    }

    public String getEmail() {
        return email;
    }

    public int getDataRialzo() {
        return dataRialzo;
    }

    @Override
    public String toString() {
        return "Rialzo [prezzoAttuale=" + prezzoAttuale + ", idAnnuncio=" + idAnnuncio + ", email=" + email
                + ", dataRialzo=" + dataRialzo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + prezzoAttuale;
        result = prime * result + idAnnuncio;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + dataRialzo;
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
        Rialzo other = (Rialzo) obj;
        if (prezzoAttuale != other.prezzoAttuale)
            return false;
        if (idAnnuncio != other.idAnnuncio)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (dataRialzo != other.dataRialzo)
            return false;
        return true;
    }

}
