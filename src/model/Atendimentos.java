package model;
public class Atendimentos {
    private int pkatendimento;
    private int fkcliente;
    private int fkanimal;
    private int fkatendimento;
    

    public int getFkatendimento() {
        return fkatendimento;
    }

    
    public void setFkatendimento(int fkatendimento) {
        this.fkatendimento = fkatendimento;
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

    public Atendimentos(int pkatendimento, int fkcliente, int fkanimal, int fkatendimento) {
        this.pkatendimento = pkatendimento;
        this.fkcliente = fkcliente;
        this.fkanimal = fkanimal;
        this.fkatendimento = fkatendimento;
    }



    public Atendimentos() {
    }
    
    
}
