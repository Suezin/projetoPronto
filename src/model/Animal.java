package model;
public class Animal {
private int id ;
private String nome ;
private String tipo ;
private String raca;

    public Animal() {
    }

    public Animal(int id, String nome, String tipo, String raca) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRaca() {
        return raca;
    }


}
