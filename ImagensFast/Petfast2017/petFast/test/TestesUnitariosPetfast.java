/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import modelo.AnimalDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Décio
 */
public class TestesUnitariosPetfast {

    public TestesUnitariosPetfast() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     *
     */
        
    public void testeBuscarIdPetAtual(){
    AnimalDAO animal;
    animal = new AnimalDAO();
    int resultado  = animal.buscarIdPetAtual();

    if (resultado==0){
    System.out.println("não existe Pet cadastrado");
    }else{
    System.out.println("o ultimo idPet é: " + resultado);
    }
    }

}
