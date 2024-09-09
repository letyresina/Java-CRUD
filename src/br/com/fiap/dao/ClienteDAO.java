package br.com.fiap.dao;

import java.sql.Connection;

import br.com.fiap.dto.Cliente;


public class ClienteDAO {
    private Connection con;

    public ClienteDAO(Connection con){
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }


}
