package lab.model;

import java.util.Objects;
import java.util.Optional;

public class Utente {
    private final String email;
    private final Optional<Integer> telefono;
    private final String nome;

    public Utente(String email, Optional<Integer> telefono, String nome) {
        this.email = email;
        this.telefono = Objects.requireNonNull(telefono);
        this.nome = Objects.requireNonNull(nome);
    }

    public Utente(final String email, final String nome) {
        this(email, Optional.empty(), nome);
    }

    public String getEmail() {
        return email;
    }

    public Optional<Integer> getTelefono() {
        return telefono;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Utente [email=" + email + ", telefono=" + telefono + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Utente other = (Utente) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
    
}