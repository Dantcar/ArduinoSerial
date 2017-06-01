/*
 * Este Software tem Objetivo Educacional
 * Para fins de TCC
 * do Curso de Analise de Sistemas da Fatec - Ipiranga
 * Ano 2016 - Julho a Dezembro  
 * Aluno Decio Antonio de Carvalho  * 
 * ultima revisao : 01-junho-2017
 */

/**
 * Métodos desta classe
 *
 *  01 - receberAnimalNome() // retorna objeto Animal
 *  02 - receberAnimalNomeIdCliente() // retorna objeto Animal
 *  03 - receberIdAnimalAtual() // retorna idAnimal
 *  04 - receberListaAnimaisCliente() // retorna lista
 *  05 - receberAnimalByIdAnimal() // retorna verdadeiro se existir o Animal
 *  06 - receberAnimaId() // retorna objeto Animal
 *  07 - cInserirAnimal() // envia um objeto Animal para inserir/cadastrar
 *  08 - cAlterarAnimal() // envia um objeto Animal alteracao cadastro
 *  09 - cDelerarAnimal() // deleta um Animal enviando o seu nomeAnimal e id
 *  10 - chamarTelaAnimal() // retorna uma instancia da tela cadastro de Animal
 *  11 - receberArrayListAnimaisCliente() // retorna lista de Animais do Cliente
 *  12 - populaComboAnimaisCliente() // retorna Arraylist de animais do Cliente
 *  13 - ReceberContarAnimaisCliente() // retorna quantidade de animais do Cliente
 *  14 - listaAnimaisNome() // retorna lista de Animais informando nome animal
 * 
 */
package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Animal;
import modelo.AnimalDAO;
import visao.EntradaSistemaPetFast;

public class AnimalCtrl {

    public AnimalCtrl() {
    }
   
    /**
     * 01 - receberAnimalNome
     * Método controle receber um Animal informando o nome
     * @param nomeAnimal
     * @return Animal
     */
    public Animal receberAnimalNome(String nomeAnimal){
        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = animalDAO.buscarAnimalNome(nomeAnimal);
        return animal;  
    }
    
    /**
     * 02 - receberAnimalNomeIdCliente()
     * Método controle receber um objeto Animal informando o nome e idCliente
     * @param nomeAnimal
     * @param IdCliente
     * @return 
     */
    public Animal receberAnimalNomeIdCliente(String nomeAnimal, int IdCliente){
        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = animalDAO.buscarAnimalNome(nomeAnimal);
        return animal;  
    }
    
    /**
     * 03 - receberIdAnimalAtual()
     * Método controle receber o id do último animal cadastrado.
     * se não existir o id atual será 0
     * @return ultimo id do animal cadastrado.
     */
    public int receberIdAnimalAtual(){
        AnimalDAO animalDAO = new AnimalDAO();
        int idAnimal= animalDAO.buscarIdPetAtual();
        return idAnimal; 
    }
    
    /**
     * 04 - receberListaAnimaisCliente()
     * Método controle receber lista de animais pertencentes a um cliente 
     * informando o id do cliente.
     * @param idCliente
     * @return Lista de animais do cliente
     */
    public List<Animal> receberListaAnimaisCliente(int idCliente){
        AnimalDAO animalDAO = new AnimalDAO();
        List<Animal> lista = animalDAO.listarAnimaisCliente(idCliente);
        return lista;
    }
    
    /**
     * 05 - receberAnimalByIdAnimal()
     * Método controle receber resposta se existe o animal informando o seu id
     * @param idAnimal
     * @return resposta true or false
     */
    public boolean receberAnimalByIdAnimal(int idAnimal){
       AnimalDAO animalDAO = new AnimalDAO();
       Boolean resposta = animalDAO.buscarAnimalByIdAnimal(idAnimal);
       return resposta;
    }
    
    /**
     * 06 - receberAnimaId()
     * Método controle receber objeto Animal informando o id do animal
     * @param idAnimal
     * @return Animal
     */
    public Animal receberAnimaId(int idAnimal){
       AnimalDAO animalDAO = new AnimalDAO();
       Animal animal = animalDAO.buscarAnimalId(idAnimal);
       return animal; 
    }
    
    /**
     * 07 - cInserirAnimal()
     * Método controle enviar animal para cadastro
     * @param animal 
     */
    public void cInserirAnimal(Animal animal){
        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.inserirAnimal(animal);        
    }//Final método cInserirAnimal
    
    /**
     * 08 - cAlterarAnimal()
     * Método controle para enviar alteração de animal cadastrado
     * @param animal 
     */
    public void cAlterarAnimal(Animal animal, String id){
        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.alterarAnimal(animal, id);        
    }//Final método cAlterarAnimal
    
    /**
     * 09 - cDelerarAnimal()
     * Método controle para enviar remoção de animal cadastrado
     * @param animal 
     */
    public void cDelerarAnimal(String nomeAnimal, int id){
        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.deletarAnimal(nomeAnimal, id);        
    }//Final método cDeletarAnimal
    
    /**
     * 10 - chamarTelaAnimal()
     * método controle para chamar uma instância de tela de cadastro de Animal
     */
    public void chamarTelaAnimal(){
        System.out.println("Estou no método: chamarTelaAnimal");
        
        EntradaSistemaPetFast telaPrincipal = new EntradaSistemaPetFast();
        telaPrincipal.chamarTelaAnimal();
    }//Final método chamarTelaAnimal
    
     /**
     * 11 - receberArrayListAnimaisCliente()
     * Método controle receber lista de animais pertencentes a um cliente 
     * informando o id do cliente.
     * @param idCliente
     * @return Lista de animais do cliente
     */
    public ArrayList<Animal> receberArrayListAnimaisCliente(int idCliente){
        AnimalDAO animalDAO = new AnimalDAO();
        ArrayList<Animal> lista = animalDAO.ArraylistAnimaisCliente(idCliente);
        return lista;
    }
    
    /**
     * 12 - populaComboAnimaisCliente()
     * Método populaComboAnimaisCliente
     * @param id
     * @return 
     */
    public ArrayList populaComboAnimaisCliente(int id) {
       ArrayList lista;
        AnimalDAO animalDAO = new AnimalDAO();
        return lista = animalDAO.findComboAnimalNome(id);
        //return lista = aeronaveDAO.findComboAeronave();
   
    }
    
    /**
     * 13 - ReceberContarAnimaisCliente()
     * Método controle para contar a quantidade de animais do cliente
     * @param cliente
     * @return 
     */
    public int ReceberContarAnimaisCliente(int cliente) {
    AnimalDAO animalDAO = new AnimalDAO();
    int resposta = animalDAO.contarAnimaisCliente(cliente);
    return resposta;
    }

    /**
     * 14 - listaAnimaisNome()
     * Método retorna uma lista com os animais que contem no nome a string 
     * passada no parametro
     * @param nomeAnimal
     * @return 
     */
    public List listaAnimaisNome(String nomeAnimal) {
       AnimalDAO animalDAO = new AnimalDAO();
       List<Animal> lista = animalDAO.listarAnimaisNome(nomeAnimal);
       return lista;
        
    }
}//Final classe AnimalCtrl
