package src;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Décio
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDerby {
 
    /**
     *con
     */
  public Connection con;
  private String url;
  private String usuario;
  private String senha;
  public static boolean acesso;
  public DBDerby(){
  
      url ="jdbc:derby://localhost:1527/Tutor1";
      usuario ="root";
      senha = "admin";
      
      try{
          System.out.println("Tentativa de conexao");
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          con = DriverManager.getConnection(url, usuario, senha);
          System.out.println("Ok conexao com o banco: "+url +" estabelecida");
          acesso=true;
      }catch (ClassNotFoundException e){ 
      
      }catch (SQLException e){
      System.out.println("Falhou conexao");
            acesso=false;
      }
   
  }
  /**
   * método para inclusao de registros no Banco Tutor1
     * @param nome
     * @param nasc
     * @param ende
     * @param email
     * @param rg
     * @param cpf
     * @throws java.sql.SQLException
   */
  public void incluirDados(String nome, String nasc, String ende, String email, String rg, String cpf) throws SQLException{
     // url ="INSERT INTO ROOT.Cliente VALUES('"+nome+"','"+nasc+"','"+ende+"','"+email+"','"+rg+"','"+cpf+"')";  
      Statement stm = con.createStatement();
      stm.executeUpdate("INSERT INTO ROOT.Clientes VALUES('"+nome+"','"+nasc+"','"+ende+"','"+email+"','"+rg+"','"+cpf+"')");
  }
  
  /**
   * método para criar tabelas no banco
   */
  public void criaTabelas(){
     /*Statement stm = con.createStatement();
     stm.executeUpdate("CREATE TABLE ROOT.Clientes ("
      +""
      +""
      +")"); */
      
  }
    
}
