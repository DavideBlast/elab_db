package lab.model;

import java.util.Optional;

public class Citta {

    private final int idCitta;
    private final String nomeStato;
    private final String nome;
    private final int popolazione;
    private final int superficie;
    private final Optional<String> regione;
    
    public Citta(int idCitta, String nomeStato, String nome, int popolazione, int superficie,
            Optional<String> regione) {
        this.idCitta = idCitta;
        this.nomeStato = nomeStato;
        this.nome = nome;
        this.popolazione = popolazione;
        this.superficie = superficie;
        this.regione = regione;
    }

    public int getIdCitta() {
        return idCitta;
    }

    public String getNomeStato() {
        return nomeStato;
    }

    public String getNome() {
        return nome;
    }

    public int getPopolazione() {
        return popolazione;
    }

    public int getSuperficie() {
        return superficie;
    }

    public Optional<String> getRegione() {
        return regione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idCitta;
        result = prime * result + ((nomeStato == null) ? 0 : nomeStato.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + popolazione;
        result = prime * result + superficie;
        result = prime * result + ((regione == null) ? 0 : regione.hashCode());
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
        Citta other = (Citta) obj;
        if (idCitta != other.idCitta)
            return false;
        if (nomeStato == null) {
            if (other.nomeStato != null)
                return false;
        } else if (!nomeStato.equals(other.nomeStato))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (popolazione != other.popolazione)
            return false;
        if (superficie != other.superficie)
            return false;
        if (regione == null) {
            if (other.regione != null)
                return false;
        } else if (!regione.equals(other.regione))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Citta [idCitta=" + idCitta + ", nomeStato=" + nomeStato + ", nome=" + nome + ", popolazione="
                + popolazione + ", superficie=" + superficie + ", regione=" + regione + "]";
    }
}