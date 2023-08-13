package lab.model;

import java.util.Optional;

public class Annuncio {
    private final int idAnnuncio;
    private final int idImmobile;
    private final String email;
    private final StatoAnnuncio statoAnnuncio;
    private final int dataCreazione;
    private final TipoAnnuncio tipoAnnuncio;
    private final Optional<Integer> costoMensile;
    private final Optional<Integer> prezzo;

    public Annuncio(final int idAnnuncio, final int idImmobile, final String email, final StatoAnnuncio statoAnnuncio, final int dataCreazione,
            final TipoAnnuncio tipoAnnuncio, final Optional<Integer> costoMensile, final Optional<Integer> prezzo) {
        this.idAnnuncio = idAnnuncio;
        this.idImmobile = idImmobile;
        this.email = email;
        this.statoAnnuncio = statoAnnuncio;
        this.dataCreazione = dataCreazione;
        this.tipoAnnuncio = tipoAnnuncio;
        this.costoMensile = costoMensile;
        this.prezzo = prezzo;
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

    public StatoAnnuncio getStatoAnnuncio() {
        return statoAnnuncio;
    }

    public int getDataCreazione() {
        return dataCreazione;
    }

    public TipoAnnuncio getTipoAnnuncio() {
        return tipoAnnuncio;
    }

    public Optional<Integer> getCostoMensile() {
        return costoMensile;
    }

    public Optional<Integer> getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Annuncio [idAnnuncio=" + idAnnuncio + ", idImmobile=" + idImmobile + ", email=" + email
                + ", statoAnnuncio=" + statoAnnuncio + ", dataCreazione=" + dataCreazione + ", tipoAnnuncio="
                + tipoAnnuncio + ", costoMensile=" + costoMensile + ", prezzo=" + prezzo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idAnnuncio;
        result = prime * result + idImmobile;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((statoAnnuncio == null) ? 0 : statoAnnuncio.hashCode());
        result = prime * result + dataCreazione;
        result = prime * result + ((tipoAnnuncio == null) ? 0 : tipoAnnuncio.hashCode());
        result = prime * result + ((costoMensile == null) ? 0 : costoMensile.hashCode());
        result = prime * result + ((prezzo == null) ? 0 : prezzo.hashCode());
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
        Annuncio other = (Annuncio) obj;
        if (idAnnuncio != other.idAnnuncio)
            return false;
        if (idImmobile != other.idImmobile)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (statoAnnuncio != other.statoAnnuncio)
            return false;
        if (dataCreazione != other.dataCreazione)
            return false;
        if (tipoAnnuncio != other.tipoAnnuncio)
            return false;
        if (costoMensile == null) {
            if (other.costoMensile != null)
                return false;
        } else if (!costoMensile.equals(other.costoMensile))
            return false;
        if (prezzo == null) {
            if (other.prezzo != null)
                return false;
        } else if (!prezzo.equals(other.prezzo))
            return false;
        return true;
    }

    private enum StatoAnnuncio {
        ATTIVO(true),
        INATTIVO(false);

        private boolean attivo;

        private StatoAnnuncio(final boolean attivo) {
            this.attivo = attivo;
        }

        public boolean isAttivo() {
            return this.attivo;
        }
    }

    private enum TipoAnnuncio {
        VENDITA(true),
        AFFITTO(false);

        private boolean vendita;

        private TipoAnnuncio(final boolean vendita) {
            this.vendita = vendita;
        }

        public boolean isVendita() {
            return this.vendita;
        }
    }
}
