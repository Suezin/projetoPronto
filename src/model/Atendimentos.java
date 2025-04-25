package model;
public class Atendimentos {
    private int pkatendimento;
    private int fkcliente;
    private int fkanimal;
    private int fkatendimento;
    private int fkproduto;
    private int fkservico;

    public int getFkatendimento() {
        return fkatendimento;
    }

    public int getFkproduto() {
        return fkproduto;
    }

    public int getFkservico() {
        return fkservico;
    }

    public void setFkatendimento(int fkatendimento) {
        this.fkatendimento = fkatendimento;
    }

    public void setFkproduto(int fkproduto) {
        this.fkproduto = fkproduto;
    }

    public void setFkservico(int fkservico) {
        this.fkservico = fkservico;
    }

    public void setPkatendimento(int pkatendimento) {
        this.pkatendimento = pkatendimento;
    }

    public void setFkcliente(int fkcliente) {
        this.fkcliente = fkcliente;
    }

    public void setFkanimal(int fkanimal) {
        this.fkanimal = fkanimal;
    }

    public int getPkatendimento() {
        return pkatendimento;
    }

    public int getFkcliente() {
        return fkcliente;
    }

    public int getFkanimal() {
        return fkanimal;
    }

    public Atendimentos(int pkatendimento, int fkcliente, int fkanimal, int fkatendimento, int fkproduto, int fkservico) {
        this.pkatendimento = pkatendimento;
        this.fkcliente = fkcliente;
        this.fkanimal = fkanimal;
        this.fkatendimento = fkatendimento;
        this.fkproduto = fkproduto;
        this.fkservico = fkservico;
    }



    public Atendimentos() {
    }
    
    
}
