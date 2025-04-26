package model;
public class AtendimentoProd {
private int fkProd;
private int fkAtendimento;

    public void setFkProd(int fkProd) {
        this.fkProd = fkProd;
    }

    public void setFkAtendimento(int fkAtendimento) {
        this.fkAtendimento = fkAtendimento;
    }

    public int getFkProd() {
        return fkProd;
    }

    public int getFkAtendimento() {
        return fkAtendimento;
    }

    public AtendimentoProd() {
    }

    public AtendimentoProd(int fkProd, int fkAtendimento) {
        this.fkProd = fkProd;
        this.fkAtendimento = fkAtendimento;
    }


}
