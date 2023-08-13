package lab.model;

public class Anno {

    private final int anno;

    public Anno(int anno) {
        this.anno = anno;
    }
    
    public int getAnno() {
        return anno;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + anno;
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
        Anno other = (Anno) obj;
        if (anno != other.anno)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Anno [anno=" + anno + "]";
    }
}