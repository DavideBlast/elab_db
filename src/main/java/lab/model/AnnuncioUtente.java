package lab.model;

import java.util.Objects;
import java.util.Optional;

public class AnnuncioUtente extends Annuncio {
    private final StatoAnnuncio statoAnnuncio;
    private final TipoAnnuncio tipoAnnuncio;
    private final Optional<Integer> costoMensile;
    private final Optional<Integer> prezzo;

    public AnnuncioUtente(final int idAnnuncio, final int idImmobile, final String email, final StatoAnnuncio statoAnnuncio, final int dataCreazione,
            final TipoAnnuncio tipoAnnuncio, final Optional<Integer> costoMensile, final Optional<Integer> prezzo) {
        super(idAnnuncio, idImmobile, email, dataCreazione);
        this.statoAnnuncio = Objects.requireNonNull(statoAnnuncio);
        this.tipoAnnuncio = Objects.requireNonNull(tipoAnnuncio);
        this.costoMensile = Objects.requireNonNull(costoMensile);
        this.prezzo = Objects.requireNonNull(prezzo);
    }

    public int getIdAnnuncio() {
        return super.getIdAnnuncio();
    }

    public int getIdImmobile() {
        return super.getIdImmobile();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public StatoAnnuncio getStatoAnnuncio() {
        return statoAnnuncio;
    }

    public int getDataCreazione() {
        return super.getDataCreazione();
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
        return "Annuncio [idAnnuncio=" + getIdAnnuncio() + ", idImmobile=" + getIdImmobile() + ", email=" + getEmail()
                + ", statoAnnuncio=" + statoAnnuncio + ", dataCreazione=" + getDataCreazione() + ", tipoAnnuncio="
                + tipoAnnuncio + ", costoMensile=" + costoMensile + ", prezzo=" + prezzo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getIdAnnuncio();
        result = prime * result + getIdImmobile();
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((statoAnnuncio == null) ? 0 : statoAnnuncio.hashCode());
        result = prime * result + getDataCreazione();
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
        AnnuncioUtente other = (AnnuncioUtente) obj;
        if (getIdAnnuncio() != other.getIdAnnuncio())
            return false;
        if (getIdImmobile() != other.getIdImmobile())
            return false;
        if (getEmail() == null) {
            if (other.getEmail() != null)
                return false;
        } else if (!getEmail().equals(other.getEmail()))
            return false;
        if (statoAnnuncio != other.statoAnnuncio)
            return false;
        if (getDataCreazione() != other.getDataCreazione())
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
