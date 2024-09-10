package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;
import java.util.ArrayList;

public class TesteLeitura {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        /* Testando carro
        CarroDAO carroDAO = new CarroDAO(con);

        ArrayList<Carro> resultado = carroDAO.listarTodos();
        if (resultado != null){
            for (Carro carro : resultado) {
                System.out.println("Placa: " + carro.getPlaca());
                System.out.println("Cor: " + carro.getCor());
                System.out.println("Descrição: " + carro.getDescricao());
            }
        }
         */

        ClienteDAO clienteDAO = new ClienteDAO(con);
        ArrayList<Cliente> resultado = clienteDAO.listarTodos();
        if (resultado != null){
            for (Cliente cliente : resultado){
                System.out.println("ID: " + cliente.getId_cliente());
                System.out.println("Nome: " + cliente.getNome_cliente());
                System.out.println("Placa do carro: " + cliente.getPlaca());
            }
        }

        ConnectionFactory.fecharConexao(con);
    }
}
