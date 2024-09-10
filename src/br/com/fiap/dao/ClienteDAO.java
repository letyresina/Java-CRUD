package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.dto.Cliente;


public class ClienteDAO {
    private Connection con;

    public ClienteDAO(Connection con){
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Cliente cliente){
        String sql = "Insert into DDD_cliente(id_cliente, nome_cliente, placa) values(?,?,?)";

        // try-with-resources
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNome_cliente());
            ps.setString(3, cliente.getPlaca());

            if(ps.executeUpdate() > 0){
                return "Inserido com sucesso!";
            }else{
                return "Falha ao inserir!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Cliente cliente){
        String sql = "update DDD_cliente set nome_cliente=?, placa=? where id_cliente=?";

        // try-with-resources
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, cliente.getNome_cliente());
            ps.setString(2, cliente.getPlaca());
            ps.setInt(3, cliente.getId_cliente());

            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso!";
            }else{
                return "Falha ao alterar!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluir(Cliente cliente){
        String sql = "delete from ddd_cliente where id_cliente=?";

        // try-with-resources
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setInt(1, cliente.getId_cliente());

            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso!";
            }else{
                return "Falha ao excluir!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<Cliente> listarTodos(){
        String sql = "select * from ddd_cliente order by nome_cliente";
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

        // try-with-resources
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            if (rs != null){
                while (rs.next()) {
                    Cliente cliente = new Cliente();

                    cliente.setId_cliente((rs.getInt(1)));
                    cliente.setNome_cliente(rs.getString(2));
                    cliente.setPlaca(rs.getString(3));

                    listaCliente.add(cliente);
                }
                return listaCliente;
            } else {
                return null;
            }

        } catch (SQLException e) {
            return null;
        }
    }

}
