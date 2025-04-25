package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Atendimentos;
import model.Clientes;

public class AtendimentosController {


public boolean inserirAtendimento(Atendimentos atend) {
        
        String sql = "INSERT INTO atendimentos(fkcliente, fkanimal) VALUES (?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);

            if (comando == null) {
                System.out.println("PreparedStatement está null!");
                return false;
            }

            comando.setInt(1, atend.getFkcliente());
            comando.setInt(2, atend.getFkanimal());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao();
        }

        return false;
    }


public boolean inserirAtendimentoProd(Atendimentos atend) {

        String sql = "INSERT INTO clientes(fkatendimento, fkproduto) VALUES (?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);

            if (comando == null) {
                System.out.println("PreparedStatement está null!");
                return false;
            }

            comando.setInt(1, atend.getFkatendimento());
            comando.setInt(2, atend.getFkproduto());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao();
        }

        return false;
    }

public boolean inserirAtendimentoServicos(Atendimentos atend) {
        String sql = "INSERT INTO atendimentoservicos(fkatendimento, fkservico) VALUES (?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);

            if (comando == null) {
                System.out.println("PreparedStatement está null!");
                return false;
            }

            comando.setInt(1, atend.getFkatendimento());
            comando.setInt(2, atend.getFkservico());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao();
        }

        return false;
    }

public int consultar() {
        
        String sql = "SELECT * FROM atendimentos ORDER BY pkantendimento DESC";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        int codigo = 0;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            if (resultado.next()) {
               codigo = resultado.getInt("pkatendimento");
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteController.class
                    .getName()).log(
                            Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
return codigo ;
    }
}
