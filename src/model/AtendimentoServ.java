package model;
public class AtendimentoServ {
private int fkServico;
private int fkAtendimento;

    public AtendimentoServ() {
    }

    public AtendimentoServ(int fkServico, int fkAtendimento) {
        this.fkServico = fkServico;
        this.fkAtendimento = fkAtendimento;
    }

    public void setFkServico(int fkServico) {
        this.fkServico = fkServico;
    }

    public void setFkAtendimento(int fkAtendimento) {
        this.fkAtendimento = fkAtendimento;
    }

    public int getFkServico() {
        return fkServico;
    }

    public int getFkAtendimento() {
        return fkAtendimento;
    }


}
