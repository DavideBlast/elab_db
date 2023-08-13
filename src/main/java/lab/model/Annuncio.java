package lab.model;

import java.sql.Date;
import java.util.Objects;

public class Annuncio {
    private final int idAnnuncio;
    private final int idImmobile;
    private final String email;
    private final Date dataCreazione;

    public Annuncio(final int idAnnuncio, final int idImmobile, final String email, final Date dataCreazione) {
        this.idAnnuncio = idAnnuncio;
        this.idImmobile = idImmobile;
        this.email = Objects.requireNonNull(email);
        this.dataCreazione = dataCreazione;
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

    public Date getDataCreazione() {
        return dataCreazione;
    }
}
