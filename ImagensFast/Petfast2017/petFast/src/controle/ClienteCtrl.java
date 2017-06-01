/*
 * Este Software tem Objetivo Educacional
 * Para fins de aprendizagem e avaliacao na
 * Na Disciplina de Laboratório Engenharia
 * do Curso de Analise de Sistemas da Fatec - Ipiranga
 * Ano 2016 - julho a Dezembro 2016 
 * Aluno Decio Antonio de Carvalho  * 
 * ultima revisao : 01-junho-2017
 */
/**
 * Métodos desta classe
 *
 *  01 - receberCliente() //  Metodo controle enviar Cliente para cadastro
 *  02 - receberClienteCPF() // Metodo controle receber um Cliente enviando seu
 *  CPF
 *  03 - receberPesquisarClienteCPF() // Metodo controle receber verdadeiro se o
 *  Cliente existe informando o CPF
 *  04 - alterarClienteCtrl() // Metodo controle enviar Cliente para alterar 
 *  dados cadastro
 *  05 - deletarClienteCtrl() // Metodo controle para enviar Cliente para 
 *  remocao no cadastro informando objeto cliente e cpf
 *  06 - populaComboClienteNome() // Metodo controle recebe ArrayList de clientes
 *  07 - listarClientes() // Método Controle para receber uma lista de clientes
 *  08 - listaClientesNome() // Método Controle para receber a busca de uma 
 *  lista de clientes informando
 *  09 - receberClienteNome() // Metodo Controle para receber cliente 
 *  enviando o nome
 *  10 - receberClienteTelefone() // Metodo Controle para receber a busca de 
 *  um cliente enviando o telefone
 *  11 - listaClientesPorNome() // Metodo Controle para receber a 
 *  busca de uma lista de clientes
 *  12 - buscarClientesPorNome() // Metodo controle para receber um Cliente 
 *  enviando o nome
 *  13 - buscarNomeId() // Metodo controle para receber o nome do 
 *  cliente informando seu id
 *  14 - buscarNomeIdInt() // Metodo controle para receber cliente 
 *  informando seu id
 *  15 - buscarRGCliente() Metodo controle para receber cliente 
 * informando seu RG
 */

package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.ClienteDAO;

/**
 *
 * @author Dac
 */
public class ClienteCtrl {
    private Object CliDAO;
    
    /**
     * 01 - receberCliente()
     * Metodo controle enviar Cliente para cadastro
     * @param cliente
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void receberCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.inserirNovoCliente(cliente);
    }
    
    /**
     * 02 - receberClienteCPF()
     * Metodo controle receber um Cliente enviando seu CPF
     * @param cpf
     * @return objeto Cliente
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Cliente receberClienteCPF(String cpf) throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = cliDAO.buscarClienteCPF(cpf);
        return cliente;
    }
    
    /**
     * 03 - receberPesquisarClienteCPF()
     * Metodo controle receber verdadeiro se o Cliente existe informando o CPF
     * @param cpf
     * @return boolean
     */
    public static boolean receberPesquisarClienteCPF(String cpf){
         boolean resposta = false;
         ClienteDAO cliente = new ClienteDAO();
         resposta = cliente.buscarExisteClienteCPF(cpf);
        return resposta;
    }
    
    /**
     * 04 - alterarClienteCtrl()
     * Metodo controle enviar Cliente para alterar dados cadastro
     * @param cliente
     * @param cpf
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void alterarClienteCtrl(Cliente cliente, String cpf) throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.alterarCliente(cliente, cpf);
    } 
    
    /**
     * 05 - deletarClienteCtrl()
     * Metodo controle para enviar Cliente para remocao no cadastro informando
     * objeto cliente e cpf
     * @param cliente
     * @param cpf
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void deletarClienteCtrl(Cliente cliente, String cpf) throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.deletarCliente(cliente, cpf);
    } 

    /**
     * 06 - populaComboClienteNome()
     * Metodo controle recebe ArrayList de clientes
     * @return ArrayList cliente
     */
    public ArrayList populaComboClienteNome() {
       ArrayList lista;
       ClienteDAO clienteDAO = new ClienteDAO();
       return lista = clienteDAO.findComboClienteNome();
    
    }
    
    /**
     * 07 - listarClientes()
     * Método Controle para receber uma lista de clientes
     * @return List<Cliente>
     */
    public List<Cliente> listarClientes() {
       ClienteDAO clienteDAO = new ClienteDAO();
       List<Cliente> lista = clienteDAO.listarClientes();
       return lista;
    
    }

    /**
     * 08 - listaClientesNome()
     * Método Controle para receber a busca de uma lista de clientes informando
     * o nome cliente
     * enviando o nome
     * @param nomeCliente
     * @return List<Cliente>
     */
    public List<Cliente> listaClientesNome(String nomeCliente) {
       ClienteDAO clienteDAO = new ClienteDAO();
       List<Cliente> lista = clienteDAO.listarClienteNome(nomeCliente);
       return lista;
    
    }
    
    /**
     * 09 - receberClienteNome()
     * Metodo Controle para receber cliente enviando o nome
     * @param nomeCliente
     * @return objeto Cliente
     */
    public static Cliente receberClienteNome(String nomeCliente){
        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = cliDAO.buscarClienteNome(nomeCliente);
        return cliente;   
        
    }
    
    /**
     * 10 - receberClienteTelefone()
     * Metodo Controle para receber a busca de um cliente enviando o telefone
     * @param telefoneCliente
     * @return objeto Cliente
     */
     public static Cliente receberClienteTelefone(String telefoneCliente){
        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = cliDAO.buscarClienteTelefone(telefoneCliente);
        return cliente;   
        
    }
     
     /**
     * 11 - listaClientesPorNome()
     * Metodo Controle para receber a busca de uma lista de clientes
     * enviando o nome
     * @param nomeCliente
     * @return List<Cliente>
     */
    public List<Cliente> listaClientesPorNome(String nomeCliente) {
       ClienteDAO clienteDAO = new ClienteDAO();
       List<Cliente> lista = clienteDAO.listarClienteNome(nomeCliente);
       return lista;
    
    }
    
    /**
     * 12 - buscarClientesPorNome()
     * Metodo controle para receber um Cliente enviando o nome
     * @param nomeCliente
     * @return objeto Cliente
     */
     public Cliente buscarClientesPorNome(String nomeCliente) {
       ClienteDAO clienteDAO = new ClienteDAO();
       Cliente cli = clienteDAO.buscarClientePorNome(nomeCliente);
       return cli;
    
    }

     /**
      * 13 - buscarNomeId()
      * Metodo controle para receber o nome do cliente informando seu id
      * @param idCliente
      * @return String nome
      */
    public String buscarNomeId(String idCliente) {
        String cli;
        ClienteDAO clienteDAO = new ClienteDAO();
        cli = clienteDAO.buscarClientePorId(idCliente);
       return cli;   
    }
    
    /**
     * 14 - buscarNomeIdInt()
     * Metodo controle para receber cliente informando seu id
     * @param idCliente
     * @return objeto cliente
     */
    public Cliente buscarNomeIdInt(int idCliente) {
        Cliente cli;
        ClienteDAO clienteDAO = new ClienteDAO();
        cli = clienteDAO.buscarClientePorIdInt(idCliente);
       return cli;   
    }
    
    /**
     * 15 - receberClienteRG()
     * Metodo controle para receber cliente informando seu RG
     * @param vRG
     * @return 
     */
    public static Cliente receberClienteRG(String vRG) throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = cliDAO.buscarClienteRG(vRG);
        return cliente;
    }
        
}//final Classe ClienteCtrl
