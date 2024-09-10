package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;

public class TesteUpdate {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        /* Testando Carro
        Carro carro = new Carro();

        carro.setPlaca("JKK1900");
        carro.setCor("Preto");
        carro.setDescricao("Nissan March");

        CarroDAO carroDAO = new CarroDAO(con);
        System.out.println(carroDAO.alterar(carro));
         */

        Cliente cliente = new Cliente();

        cliente.setId_cliente(1);
        cliente.setNome_cliente("Talon");
        cliente.setPlaca("JKK1900");

        ClienteDAO clienteDAO = new ClienteDAO(con);
        System.out.println(clienteDAO.alterar(cliente));

        ConnectionFactory.fecharConexao(con);
    }
}
