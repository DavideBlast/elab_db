package lab.model;

import java.util.Objects;

public class Messaggio {
    private final int timestamp;
    private final int idAnnuncio;
    private final String email;
    private final String testo;
    private final Ruolo mittente;    
    
    public Messaggio(final int timestamp, final int idAnnuncio, final String email, final String testo, final Ruolo mittente) {
        this.timestamp = timestamp;
        this.idAnnuncio = idAnnuncio;
        this.email = Objects.requireNonNull(email);
        this.testo = Objects.requireNonNull(testo);
        this.mittente = Objects.requireNonNull(mittente);
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getIdAnnuncio() {
        return idAnnuncio;
    }

    public String getEmail() {
        return email;
    }

    public String getTesto() {
        return testo;
    }

    public Ruolo getMittente() {
        return mittente;
    }

    @Override
    public String toString() {
        return "Messaggio [timestamp=" + timestamp + ", idAnnuncio=" + idAnnuncio + ", email=" + email + ", testo="
                + testo + ", mittente=" + mittente + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + timestamp;
        result = prime * result + idAnnuncio;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((testo == null) ? 0 : testo.hashCode());
        result = prime * result + ((mittente == null) ? 0 : mittente.hashCode());
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
        Messaggio other = (Messaggio) obj;
        if (timestamp != other.timestamp)
            return false;
        if (idAnnuncio != other.idAnnuncio)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (testo == null) {
            if (other.testo != null)
                return false;
        } else if (!testo.equals(other.testo))
            return false;
        if (mittente != other.mittente)
            return false;
        return true;
    }

    private enum Ruolo {
        ACQUIRENTE(true),
        VENDITORE(false);
        
        private final boolean acquirente;
        
        private Ruolo(final boolean acquirente) {
            this.acquirente = acquirente;
        }

        public boolean isAcquirente() {
            return this.acquirente;
        }
    }
}
