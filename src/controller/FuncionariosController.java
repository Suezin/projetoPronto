package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Clientes;
import model.Funcionario;
import model.Usuario;

public class FuncionariosController {

    public boolean inserirFuncionario(Funcionario fc) {
        String sql = "INSERT INTO funcionario(nome, funcao) " + "VALUES (?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, fc.getNome());
            comando.setString(2, fc.getFuncao());
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;

    }

    public boolean alterarFuncionario(Funcionario fc) {
        String sql = "UPDATE funcionario " + "SET nome = ?, funcao = ? WHERE pkfuncionario = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(3, fc.getPkfuncionario());
            comando.setString(1, fc.getNome());
            comando.setString(2, fc.getFuncao());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }

    public Funcionario buscarPorPk(int pkFuncionario) {
        String sql = "SELECT * FROM funcionario " + "WHERE pkfuncionario = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Funcionario fc = new Funcionario();

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkFuncionario);
            resultado = comando.executeQuery();
            if (resultado.next()) {
                fc.setPkfuncionario(resultado.getInt("pkfuncionario"));
                fc.setNome(resultado.getString("nome"));
                fc.setFuncao(resultado.getString("funcao"));
            }

        } catch (SQLException e) {
            Logger.getLogger(controller.UsuarioController.class.getName()).log(
                    Level.SEVERE, null, e);
        } finally {
            gerenciador.fecharConexao();
        }
        return fc;
    }

    public List<Funcionario> consultar() {
        String sql = "SELECT * FROM funcionario";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Funcionario> listaFuncionario = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                Funcionario fc = new Funcionario();

                fc.setPkfuncionario(resultado.getInt("pkfuncionario"));
                fc.setNome(resultado.getString("nome"));
                fc.setFuncao(resultado.getString("funcao"));
                listaFuncionario.add(fc);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteController.class.getName()).log(
                    Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaFuncionario;
    }

    public boolean deletar(int pkFuncionario) {
        Funcionario fc = new Funcionario();
        String sql = "DELETE FROM funcionario WHERE pkfuncionario = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkFuncionario);
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
