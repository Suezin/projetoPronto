package model;

import java.util.logging.Logger;

public class Funcionario {
    private int pkfuncionario;
    private String nome ;
    private String funcao ;

    public Funcionario() {
    }

    public Funcionario(int pkfuncionario, String nome, String funcao) {
        this.pkfuncionario = pkfuncionario;
        this.nome = nome;
        this.funcao = funcao;
    }
    
    public void setPkfuncionario(int pkfuncionario) {
        this.pkfuncionario = pkfuncionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getPkfuncionario() {
        return pkfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }

    
}
