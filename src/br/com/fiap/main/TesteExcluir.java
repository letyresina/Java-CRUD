package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;

public class TesteExcluir {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        /*
        Carro carro = new Carro();

        carro.setPlaca("JKK1900");

        CarroDAO carroDAO = new CarroDAO(con);
        System.out.println(carroDAO.excluir(carro));

         */

        Cliente cliente = new Cliente();

        cliente.setId_cliente(1);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        System.out.println(clienteDAO.excluir(cliente));

        ConnectionFactory.fecharConexao(con);
    }
}
