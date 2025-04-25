package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Animal;
import model.Clientes;

public class AnimalController {


public boolean inserirAnimal(Animal animal) {
        String sql = "INSERT INTO animais(nome, tipo, raca) VALUES (?,?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, animal.getNome());
            comando.setString(2, animal.getTipo());
            comando.setString(3, animal.getRaca());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao();
        }

        return false;
    }

    public boolean alterarAnimal(Animal animal) {
        String sql = "UPDATE animais " + "SET nome = ?, tipo = ?, raca = ? WHERE pkanimal = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(4, animal.getId());
            comando.setString(1, animal.getNome());
            comando.setString(2, animal.getTipo());
            comando.setString(3, animal.getRaca());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }

    public Animal buscarPorPk(int pkAnimal) {
        String sql = "SELECT * FROM animais " + "WHERE pkanimal = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Animal animal = new Animal();

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkAnimal);
            resultado = comando.executeQuery();
            if (resultado.next()) {
                animal.setId(resultado.getInt("pkanimal"));
                animal.setNome(resultado.getString("nome"));
                animal.setTipo(resultado.getString("tipo"));
                animal.setRaca(resultado.getString("raca"));

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioController.class
                    .getName()).log(
                            Level.SEVERE, null, e);
        } finally {
            gerenciador.fecharConexao();
        }
        return animal;
    }

    public List<Animal> consultar() {
        String sql = "SELECT * FROM animais";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Animal> listaAnimais = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                Animal animal = new Animal();

                animal.setId(resultado.getInt("pkanimal"));
                animal.setNome(resultado.getString("nome"));
                animal.setTipo(resultado.getString("tipo"));
                animal.setRaca(resultado.getString("raca"));
                listaAnimais.add(animal);

            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteController.class
                    .getName()).log(
                            Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaAnimais;
    }

    public boolean deletar(int pkAnimal) {
        Animal animal = new Animal();
        String sql = "DELETE FROM animais WHERE pkanimal = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkAnimal);
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            gerenciador.fecharConexao();
        }
        return false;
        
}
    
}
