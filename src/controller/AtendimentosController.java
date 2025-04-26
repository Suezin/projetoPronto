package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AtendimentoProd;
import model.AtendimentoServ;
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

    public boolean inserirAtendimentoProd(AtendimentoProd prod) {

        String sql = "INSERT INTO atendimentoprodutos(fkatendimento, fkproduto) VALUES (?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);

            if (comando == null) {
                System.out.println("PreparedStatement está null!");
                return false;
            }

            comando.setInt(1, prod.getFkAtendimento());
            comando.setInt(2, prod.getFkProd());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao();
        }

        return false;
    }

    public boolean inserirAtendimentoServicos(AtendimentoServ serv) {
        String sql = "INSERT INTO atendimentoservicos(fkatendimento, fkservico) VALUES (?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);

            if (comando == null) {
                System.out.println("PreparedStatement está null!");
                return false;
            }

            comando.setInt(1, serv.getFkAtendimento());
            comando.setInt(2, serv.getFkServico());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao();
        }

        return false;
    }

    public int consultarUltimo() {

        String sql = "SELECT * FROM atendimentos ORDER BY pkatendimento DESC";
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
        return codigo;
    }
   public List<Atendimentos> consultarAtendimentos() {
        String sql = "SELECT * FROM atendimentos";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atendimentos> listaAtendimentos = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);
            
            resultado = comando.executeQuery();
            while (resultado.next()) {
                Atendimentos atend = new Atendimentos();
                

                atend.setPkatendimento(resultado.getInt("pkatendimento"));
                atend.setFkcliente(resultado.getInt("fkcliente"));
                atend.setFkanimal(resultado.getInt("fkanimal"));
                listaAtendimentos.add(atend);

            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteController.class
                    .getName()).log(
                            Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaAtendimentos;
    }
}
