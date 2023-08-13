package lab.model;

public class Stato {
    
    private final String nome;
    private final int superficie;
    private final int popolazione;
    
    public Stato(String nome, int superficie, int popolazione) {
        this.nome = nome;
        this.superficie = superficie;
        this.popolazione = popolazione;
    }

    public String getNome() {
        return nome;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getPopolazione() {
        return popolazione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + superficie;
        result = prime * result + popolazione;
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
        Stato other = (Stato) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (superficie != other.superficie)
            return false;
        if (popolazione != other.popolazione)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Stato [nome=" + nome + ", superficie=" + superficie + ", popolazione=" + popolazione + "]";
    }   
}