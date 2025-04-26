package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Servicos;
import controller.GerenciadorConexao;
import model.Clientes;

public class ServicosController {
    public List<Servicos> consultarServios() {
        String sql = "SELECT * FROM servicos";
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Servicos> listaServico = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);

            resultado = comando.executeQuery();
            while (resultado.next()) {
                Servicos serv = new Servicos();

                serv.setPkServico(resultado.getInt("pkservico"));
                serv.setDescricao(resultado.getString("nomeservico"));
                serv.setPreco(resultado.getString("preco"));
                serv.setTempo(resultado.getString("tempo"));
                listaServico.add(serv);
            }
        } catch (SQLException e) {
            Logger.getLogger(ServicosController.class.getName()).log(
                    Level.SEVERE, null, e);

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaServico;
    }
    
    public boolean inserirServico(Servicos serv){
    
        String sql = "INSERT INTO servicos(nomeservico, preco, tempo) " + "VALUES (?,?,?)";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setString(1, serv.getDescricao());
            comando.setString(2, serv.getPreco());
            comando.setString(3, serv.getTempo());
 
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }
    
    public boolean alterarServico(Servicos sv) {
        String sql = "UPDATE servicos " + "SET nomeservico = ?, preco = ?, tempo = ? WHERE pkservico = ?";
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(4, sv.getPkServico());
            comando.setString(1, sv.getDescricao());
            comando.setString(2, sv.getPreco());
            comando.setString(3, sv.getTempo());
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao();
        }
        return false;
    }
    
     public boolean deletar(int pkServico) {
        Servicos serv = new Servicos();
        String sql = "DELETE FROM servicos WHERE pkservico = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkServico);
            comando.executeUpdate();
            return true;
        } catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            gerenciador.fecharConexao();
        }
        return false;
    }
     
     public List<Servicos> buscarPorPk(int pkServico) {
        String sql = "SELECT * FROM servicos " + "WHERE pkservico= ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        Servicos serv = new Servicos();
        List<Servicos> consultServico = new ArrayList<>();
        try {
            comando = gerenciador.prepararConexao(sql);
            comando.setInt(1, pkServico);
            resultado = comando.executeQuery();
            while(resultado.next()) {
                Servicos servico = new Servicos();

                servico.setPkServico(resultado.getInt("pkservico"));
                servico.setDescricao(resultado.getString("nomeservico"));
                servico.setPreco(resultado.getString("preco"));
                servico.setTempo(resultado.getString("tempo"));
                consultServico.add(serv); 
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioController.class
                    .getName()).log(
                            Level.SEVERE, null, e);
        } finally {
            gerenciador.fecharConexao();
        }
        return consultServico;
    }
}
