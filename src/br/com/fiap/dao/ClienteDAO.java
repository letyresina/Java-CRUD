package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
