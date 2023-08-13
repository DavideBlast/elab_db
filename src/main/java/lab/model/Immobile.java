package lab.model;

import java.util.Optional;

public class Immobile {

    private final int idImmobile;
    private final int idZona;
    private final int metriQuadri;
    private final ClasseEnergetica classe;
    private final int annoCostruzione;
    private final String via;
    private final int numeroCivico;
    private final TipoImmobile tipo;
    private final Optional<Integer> numeroInterno;
    private final Optional<Integer> piano;
    private final int numeroStanze;
    private final Optional<Integer> numeroCoinquilini;

    public Immobile(int idImmobile, int idZona, int metriQuadri, ClasseEnergetica classe, int annoCostruzione,
            String via, int numeroCivico, TipoImmobile tipo, Optional<Integer> numeroInterno, Optional<Integer> piano,
            int numeroStanze, Optional<Integer> numeroCoinquilini) {
        this.idImmobile = idImmobile;
        this.idZona = idZona;
        this.metriQuadri = metriQuadri;
        this.classe = classe;
        this.annoCostruzione = annoCostruzione;
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.tipo = tipo;
        this.numeroInterno = numeroInterno;
        this.piano = piano;
        this.numeroStanze = numeroStanze;
        this.numeroCoinquilini = numeroCoinquilini;
    }

    public int getIdImmobile() {
        return idImmobile;
    }
    
    public int getIdZona() {
        return idZona;
    }
    
    public int getMetriQuadri() {
        return metriQuadri;
    }
    
    public ClasseEnergetica getClasse() {
        return classe;
    }
    
    public int getAnnoCostruzione() {
        return annoCostruzione;
    }
    
    public String getVia() {
        return via;
    }
    
    public int getNumeroCivico() {
        return numeroCivico;
    }
    
    public TipoImmobile getTipo() {
        return tipo;
    }
    
    public Optional<Integer> getNumeroInterno() {
        return numeroInterno;
    }
    
    public Optional<Integer> getPiano() {
        return piano;
    }
    
    public int getNumeroStanze() {
        return numeroStanze;
    }
    
    public Optional<Integer> getNumeroCoinquilini() {
        return numeroCoinquilini;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idImmobile;
        result = prime * result + idZona;
        result = prime * result + metriQuadri;
        result = prime * result + ((classe == null) ? 0 : classe.hashCode());
        result = prime * result + annoCostruzione;
        result = prime * result + ((via == null) ? 0 : via.hashCode());
        result = prime * result + numeroCivico;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((numeroInterno == null) ? 0 : numeroInterno.hashCode());
        result = prime * result + ((piano == null) ? 0 : piano.hashCode());
        result = prime * result + numeroStanze;
        result = prime * result + ((numeroCoinquilini == null) ? 0 : numeroCoinquilini.hashCode());
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
        Immobile other = (Immobile) obj;
        if (idImmobile != other.idImmobile)
        return false;
        if (idZona != other.idZona)
        return false;
        if (metriQuadri != other.metriQuadri)
        return false;
        if (classe != other.classe)
        return false;
        if (annoCostruzione != other.annoCostruzione)
        return false;
        if (via == null) {
            if (other.via != null)
            return false;
        } else if (!via.equals(other.via))
        return false;
        if (numeroCivico != other.numeroCivico)
        return false;
        if (tipo != other.tipo)
        return false;
        if (numeroInterno == null) {
            if (other.numeroInterno != null)
            return false;
        } else if (!numeroInterno.equals(other.numeroInterno))
        return false;
        if (piano == null) {
            if (other.piano != null)
            return false;
        } else if (!piano.equals(other.piano))
        return false;
        if (numeroStanze != other.numeroStanze)
        return false;
        if (numeroCoinquilini == null) {
            if (other.numeroCoinquilini != null)
            return false;
        } else if (!numeroCoinquilini.equals(other.numeroCoinquilini))
        return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Immobile [idImmobile=" + idImmobile + ", idZona=" + idZona + ", metriQuadri=" + metriQuadri
        + ", classe=" + classe + ", annoCostruzione=" + annoCostruzione + ", via=" + via + ", numeroCivico="
        + numeroCivico + ", tipo=" + tipo + ", numeroInterno=" + numeroInterno + ", piano=" + piano
        + ", numeroStanze=" + numeroStanze + ", numeroCoinquilini=" + numeroCoinquilini + "]";
    }

    public enum ClasseEnergetica {
        Apiu, A, B, C, D, E, F, G;
    }
    
    public enum TipoImmobile {
        Appartamento, Villa, Stanza;
    }
}