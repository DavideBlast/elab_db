package lab.model;

public class CittaAnno {

    private final int idCitta;
    private final int anno;
    private final int punteggioAmbiente;
    private final int punteggioTrasporto;
    private final int punteggioEconomia;
    private final int punteggioSanita;
    private final int punteggioIstruzione;
    
    public CittaAnno(int idCitta, int anno, int punteggioAmbiente, int punteggioTrasporto, int punteggioEconomia,
            int punteggioSanita, int punteggioIstruzione) {
        this.idCitta = idCitta;
        this.anno = anno;
        this.punteggioAmbiente = punteggioAmbiente;
        this.punteggioTrasporto = punteggioTrasporto;
        this.punteggioEconomia = punteggioEconomia;
        this.punteggioSanita = punteggioSanita;
        this.punteggioIstruzione = punteggioIstruzione;
    }

    public int getIdCitta() {
        return idCitta;
    }

    public int getAnno() {
        return anno;
    }

    public int getPunteggioAmbiente() {
        return punteggioAmbiente;
    }

    public int getPunteggioTrasporto() {
        return punteggioTrasporto;
    }

    public int getPunteggioEconomia() {
        return punteggioEconomia;
    }

    public int getPunteggioSanita() {
        return punteggioSanita;
    }

    public int getPunteggioIstruzione() {
        return punteggioIstruzione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idCitta;
        result = prime * result + anno;
        result = prime * result + punteggioAmbiente;
        result = prime * result + punteggioTrasporto;
        result = prime * result + punteggioEconomia;
        result = prime * result + punteggioSanita;
        result = prime * result + punteggioIstruzione;
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
        CittaAnno other = (CittaAnno) obj;
        if (idCitta != other.idCitta)
            return false;
        if (anno != other.anno)
            return false;
        if (punteggioAmbiente != other.punteggioAmbiente)
            return false;
        if (punteggioTrasporto != other.punteggioTrasporto)
            return false;
        if (punteggioEconomia != other.punteggioEconomia)
            return false;
        if (punteggioSanita != other.punteggioSanita)
            return false;
        if (punteggioIstruzione != other.punteggioIstruzione)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CittaAnno [idCitta=" + idCitta + ", anno=" + anno + ", punteggioAmbiente=" + punteggioAmbiente
                + ", punteggioTrasporto=" + punteggioTrasporto + ", punteggioEconomia=" + punteggioEconomia
                + ", punteggioSanita=" + punteggioSanita + ", punteggioIstruzione=" + punteggioIstruzione + "]";
    }
    
}