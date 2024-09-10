package br.com.fiap.main;

import java.sql.Connection;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

public class TesteCreate {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        /* Testando carro
        Carro carro = new Carro();
        carro.setPlaca("JKK1900");
        carro.setCor("Preto");
        carro.setDescricao("Nissan Kicks");

        CarroDAO carroDAO = new CarroDAO(con);
        System.out.println(carroDAO.inserir(carro));
        */

        Cliente cliente = new Cliente();
        cliente.setId_cliente(1);
        cliente.setNome_cliente("Gabriel");
        cliente.setPlaca("JKK1900");

        ClienteDAO clienteDAO = new ClienteDAO(con);
        System.out.println(clienteDAO.inserir(cliente));

        ConnectionFactory.fecharConexao(con);

    }
}
