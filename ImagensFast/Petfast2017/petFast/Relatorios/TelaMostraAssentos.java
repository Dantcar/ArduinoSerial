// TelaMostraAssentos Class File
//import java.awt.event.AdjustmentEvent;
//import java.awt.event.AdjustmentListener;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.*;
import javax.swing.JInternalFrame;

public class TelaMostraAssentos extends JFrame implements ActionListener
{

    // Creates an icon, attached to a label to act as a banner  for the program
    // Get resource is required for finding the image within the JAR achive once packed
    final public ImageIcon icon = (new ImageIcon(getClass().getResource("imagens/ProgramBanner.png")));
    JLabel iconHolder = new JLabel(icon);

    //Elementos GUI
    JLabel lblVooNumero = new JLabel("Voo número ");
    JLabel lblTipoDocumento = new JLabel("Passagem ");
    JLabel lblPassagemPreçoTotal = new JLabel("Preço Total: ");
    JLabel lblQuantidadePassagens = new JLabel("Quantidade de Passagens: ");
    JLabel lblAdulto = new JLabel("Adulto");
    JLabel lblCrianca = new JLabel("Criança");
    JLabel lblIdoso = new JLabel("Idosos/Especiais");
    JTextField tftPassagemQuantidade = new JTextField(1);
    JTextField tftTipoCusto = new JTextField(4);
    JInternalFrame jintP0 = new JInternalFrame();

    // GUI Buttons
    JButton btnReservaPassagem = new JButton("Reserva");
    JButton resetButton = new JButton("Delete DB");

    //Labels For Each Ticket (Do not appear until called by selecting a Ticket Type quantity)
    JLabel lblAssento01 = new JLabel ("Passagem 1");
    JLabel lblAssento02 = new JLabel ("Passagem 2");
    JLabel lblAssento03 = new JLabel ("Passagem 3");
    JLabel lblAssento04 = new JLabel ("Passagem 4");
    JLabel lblAssento05 = new JLabel ("Passagem 5");

    // Labels and ComboBoxes for for various Quantity of Tickets (Like their label, also do not appear untill called)
    JComboBox cbxAssentoCombo1 = new JComboBox();
    JComboBox cbxAssentoCombo2=  new JComboBox();
    JComboBox cbxAssentoCombo3=  new JComboBox();
    JComboBox cbxAssentoCombo4=  new JComboBox();
    JComboBox cbxAssentoCombo5=  new JComboBox();

    // Arrays for Quantity of each ticket type
    Integer[] listaQuantidadeAdultos = {0,1,2,3,4,5};
    Integer[] listaQuantidadeCriancas = {0,1,2,3,4,5};
    Integer[] listaQuantidadeIdosos = {0,1,2,3,4,5};

    // Comboboxes to hold the state of the desired quantity of each ticket type
    JComboBox cbxAdultoQuantidade = new JComboBox(listaQuantidadeAdultos);
    JComboBox cbxCriancaQuantidade = new JComboBox(listaQuantidadeCriancas);
    JComboBox cbxIdosoQuantidade = new JComboBox(listaQuantidadeIdosos);

    //fundacao321@
    //String listaVoos;
    //Original ArrayList for a Combobox that shows Film Times
    //String[] timeList = {"-", "1.00 PM", "3.00 PM", "5.00 PM", "7.00 PM", "9.00 PM"}; //buscar voo

    //buscar listas de voos no arquivo tipo txt com a relação de voos da aeronave escolhida.
    //formato do arquivo {"vooNNNN-DDMMYYYY","vooNNNN-DDMMYYYY"}
    //public String listaVoos[] ={"","VOO1004-05082016","VOO1005-06082016","VOO1006-07082016","VOO1006-07082016"}; //buscar voo
    public String listaVoosArray[] = {"","VOO1004-05082016","VOO1005-06082016","VOO1006-07082016","VOO1006-07082016"}; //buscar voo
    JComboBox cbxVooCombo = new JComboBox(listaVoosArray);

    // ArrayList that holds the vaules of seats that are available
    ArrayList<String> seatArrayList = new ArrayList<String>();
    
   
    String voo = new String();

    //Creation of JPanels to be added to the frame
    JPanel bannerPanel = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();

    //Criando as barras de rolagem hbar e vbar
    //JScrollBar hbar = new JScrollBar(JScrollBar.HORIZONTAL);
    //JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL);
    // hbar.setUnitIncrement(2);
    // hbar.setBlockIncrement(1);

    //Dados para formatação do layout dos blocos de assentos na aeronave.
    public boolean coluna = false;
    public int e;
    public int b;
    public int f;

    public int e_param;
    public int b_param;
    public int f_param;

    public int ecol;
    public int bcol;
    public int fcol;

    public int erow;
    public int brow;
    public int frow;

    public int ex;
    public int bx;
    public int fx;

    /**
     * Método para calcular o numero de linhas com a entrada de 
     * informações de total assentos e total de colunas requeridas
     * obs: confere se o divisor não está com valor zero para evitar mensagem de erros
     * @param total - número total de assentos.
     * @param col - número de colunas requeridas.
     */
    public int calcRow(int total, int col){
        int vRow = 0;
        if (col != 0){
            vRow = (total/col);

            if ((total % col) != 0){
                vRow = vRow +1;
            }
        }
        return vRow;
    }

    public int calcCol(int total, int row){
        int vCol = 0;

        if (row != 0){
            vCol = (total/row);

            if ((total % row) != 0){
                vCol = vCol +1;
            }
        }
        return vCol;
    } 

    /**
     * Método para criar tela com os assentos e classes desejadas.
     * @param
     * 
     * @return
     * 
     */
    public TelaMostraAssentos(boolean tipoLayout, int ve, int vb, int vf, int ex, int bx, int fx)   // Método construtor para a interface (GUI)
    {
        //GroupLayout layout = new GroupLayout(this);
        //FlowLayout layout;
        // layout = new FlowLayout();
        //Dados para formatação do layout dos blocos de assentos na aeronave.
        coluna = tipoLayout;
        e = ve;
        b = vb;
        f = vf;

        e_param = ex;
        b_param = bx;
        f_param = fx;

        ecol = ex;
        bcol = bx;
        fcol = fx;

        erow = ex;
        brow = bx;
        frow = fx;

        //setLayout(layout);

        setLocationRelativeTo(null);     // Centers the Frame (NOTE: Multi-monitor setups may not center correctly depending on collective resolution

        setTitle("Reserva de Assentos AeroFast versão 0.1"); // Set Title of Main Window
        setSize(775,480);                               // Set frame resolution to [x,y] pixels
        //setResizable(false);                           // Keeps Frame a constant resolution (Stops Resizing of Frame by user)
        setResizable(true);
        setLocation(100, 100);                          //
        setDefaultCloseOperation(EXIT_ON_CLOSE);        // Set frame to exit when 'CLOSE' window button is clicked

        //We specify automatic gap insertion:
        //layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);

        //Ajustando para layout nulo
        //bannerPanel.setLayout(null);
        //p1.setLayout(null);
        //p2.setLayout(null);
        //p3.setLayout(null);
        //p4.setLayout(null);
        /*
         * 
        Then, we define the groups and add the components. 
        We establish a root group for each dimension using the setHorizontalGroup and setVerticalGroup methods. 
        Groups are created via createSequentialGroup and createParallelGroup methods. 
        Components are added to groups by using the addComponent method.
         */
        /*
        layout.setHorizontalGroup(
        layout.createSequentialGroup()
        .addComponent(p1)
        .addComponent(p2)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(p3)
        .addComponent(p4))
        );
        layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(p1)
        .addComponent(p2)
        .addComponent(p3))
        .addComponent(p4)
        );
         */

        // Add Panels to the Frame and state Layout Manager constructor arguments

        add(bannerPanel, BorderLayout.NORTH );
        add(p1, BorderLayout.EAST);
        add(p2, BorderLayout.WEST);
        add(p3, BorderLayout.SOUTH);
        // add(p4, BorderLayout.SOUTH);

        // Addition of Content to respective Panel (Order determines position within panel)
        bannerPanel.add(iconHolder);
        bannerPanel.add(lblQuantidadePassagens);
        bannerPanel.add(tftPassagemQuantidade);
        bannerPanel.add(lblPassagemPreçoTotal);
        bannerPanel.add(tftTipoCusto);
        p1.add(resetButton);
        p2.add(lblVooNumero);
        p2.add(cbxVooCombo);
        p2.add(lblAdulto);
        p2.add(cbxAdultoQuantidade);
        p2.add(lblCrianca);
        p2.add(cbxCriancaQuantidade);
        p2.add(lblIdoso);
        p2.add(cbxIdosoQuantidade);

        // Set number of visible entries when a combobox is selected
        cbxAdultoQuantidade.setMaximumRowCount(4);
        cbxCriancaQuantidade.setMaximumRowCount(4);
        cbxIdosoQuantidade.setMaximumRowCount(4);
        cbxVooCombo.setMaximumRowCount(4);

        // Makes textfields non-editable, so that they can be used to display content
        tftPassagemQuantidade.setEditable(false);
        tftTipoCusto.setEditable(false);

        // Addition of Action Listeners to Objects
        //p1.addActionListener(this);
        //p2.addActionListener(this);
        //p3.addActionListener(this);
        cbxVooCombo.addActionListener(this);
        cbxAdultoQuantidade.addActionListener(this);
        cbxCriancaQuantidade.addActionListener(this);
        cbxIdosoQuantidade.addActionListener(this);
        btnReservaPassagem.addActionListener(this);
        resetButton.addActionListener(this);
        cbxAssentoCombo1.addActionListener(this);
        cbxAssentoCombo2.addActionListener(this);
        cbxAssentoCombo3.addActionListener(this);
        cbxAssentoCombo4.addActionListener(this);
        cbxAssentoCombo5.addActionListener(this);

        setVisible(true);   // Set frame to be Visible, thus updating frame with all the selected elements
        repaint();
    }

    /**
     * Metodo para interação com as ações da tela
     * 
     * 
     */
    //STARTOF ACTIONEVENTS
    public void actionPerformed (ActionEvent action)    // Method that contain all conditions where an ActionEvent is needed
    {
        /*
        if(action.getSource() == p1 ||
        action.getSource() == p2 ||
        action.getSource() == p3){
        repaint();

        }
         */

        // ActionListener for Combobox that displays Film Viewing Times
        if (action.getSource() == cbxVooCombo)
        {
            // Create New Instance of the Database class
            //FullDataBaseGenerator db = new FullDataBaseGenerator();
            VooPreencheAssentosUtil db = new VooPreencheAssentosUtil();
            // Get Name of database
            //String vooSelecionado = db.returnFileName(cbxVooCombo.getSelectedItem().toString());
            String vooSelecionado = db.retornaNomeArquivo(cbxVooCombo.getSelectedItem().toString());
            System.out.println(vooSelecionado);

            // Make Name of Database global
            voo = vooSelecionado;

            // Call DataBase Generator (will generate fresh database for that time if one does not exist)
            //db.FullDataBaseGeneration(vooSelecionado);
            db.GeraNovaBaseAssentos(vooSelecionado, 40, 30, 20);
            //Fetch array of available seats and pass it to the global ArrayList 'seatArrayList'
            //ArrayList<Integer> vooArray  = db.AvailableAssentosArrayReturn(vooSelecionado);
            ArrayList<String> vooArray  = db.RetornaAssentosDisponiveisVoo(vooSelecionado);
            seatArrayList = vooArray;

            //Reset any user selection of tickets when a new database is selected
            cbxAdultoQuantidade.setSelectedIndex(0);
            cbxCriancaQuantidade.setSelectedIndex(0);
            cbxIdosoQuantidade.setSelectedIndex(0);

            //Repaint the Frame
            repaint();

        }

        // ActionListener for all ticket type comboboxes collectively
        if (action.getSource() == cbxAdultoQuantidade || action.getSource()
        == cbxCriancaQuantidade|| action.getSource() == cbxIdosoQuantidade)

        {

            // Remove all existing items from each cb
            cbxAssentoCombo1.removeAllItems();
            cbxAssentoCombo2.removeAllItems();
            cbxAssentoCombo3.removeAllItems();
            cbxAssentoCombo4.removeAllItems();
            cbxAssentoCombo5.removeAllItems();

            // If the arraylist no longer contains a zero (default answer)
            // Add a zero at the beginning of the array
            if (seatArrayList.contains(0) != true)
            {
                seatArrayList.add(0, "000");
            }

            // Add contents of the ArrayList to each combobox that display available seats
            for (int z =0; z< seatArrayList.size(); z++)
            {
                cbxAssentoCombo1.addItem(seatArrayList.get(z));
                cbxAssentoCombo2.addItem(seatArrayList.get(z));
                cbxAssentoCombo3.addItem(seatArrayList.get(z));
                cbxAssentoCombo4.addItem(seatArrayList.get(z));
                cbxAssentoCombo5.addItem(seatArrayList.get(z));
            }

            // Get new total price as a String and affix to a Label for display on Frame
            String totalString = getTotal();
            tftTipoCusto.setText("R$" + totalString);

            // Calculate total quantity of Tickets and affix to a label for display on Frame
            Integer adultCounter = Integer.parseInt((cbxAdultoQuantidade.getSelectedItem().toString()));
            Integer childCounter = Integer.parseInt((cbxCriancaQuantidade.getSelectedItem().toString()));
            Integer oapCounter = Integer.parseInt((cbxIdosoQuantidade.getSelectedItem().toString()));
            Integer countTotal = (adultCounter + childCounter + oapCounter);
            tftPassagemQuantidade.setText(countTotal.toString());

            // Only 5 tickets can be ordered at one time. Returns error message if more are selected
            if (countTotal >5)
            {   cbxAdultoQuantidade.setSelectedIndex(0);
                cbxCriancaQuantidade.setSelectedIndex(0);
                cbxIdosoQuantidade.setSelectedIndex(0);
                tooManyTickets();
                return;
            }

            // Following 6 if statements state what labels/comboboxes should show when the ticket number changes:
            // E.G. if no tickets are selected then no labels/cbs show
            // if 3 tickets are chosen, then the labels/cbs for Ticket 1,2 and 3 are shown
            // if 1 ticket is then chosen, cb/label for Ticket 2 and 3 dissapear by 1 stays
            if (countTotal ==1 || countTotal ==2 || countTotal ==3 || countTotal ==4|| countTotal ==5 )
            {
                p3.remove(lblAssento02);
                p3.remove(cbxAssentoCombo2);
                p3.remove(lblAssento03);
                p3.remove(cbxAssentoCombo3);
                p3.remove(lblAssento04);
                p3.remove(cbxAssentoCombo4);
                p3.remove(lblAssento05);
                p3.remove(cbxAssentoCombo5);
                p3.add(lblAssento01);
                p3.add(cbxAssentoCombo1);
            }

            if (countTotal ==2 || countTotal ==3 || countTotal ==4|| countTotal ==5 )
            {
                p3.remove(lblAssento03);
                p3.remove(cbxAssentoCombo3);
                p3.remove(lblAssento04);
                p3.remove(cbxAssentoCombo4);
                p3.remove(lblAssento05);
                p3.remove(cbxAssentoCombo5);
                p3.add(lblAssento02);
                p3.add(cbxAssentoCombo2);
            }

            if (countTotal ==3 || countTotal ==4|| countTotal ==5 )
            {
                p3.remove(lblAssento04);
                p3.remove(cbxAssentoCombo4);
                p3.remove(lblAssento05);
                p3.remove(cbxAssentoCombo5);
                p3.add(lblAssento03);
                p3.add(cbxAssentoCombo3);
            }

            if (countTotal ==4|| countTotal ==5 )
            {
                p3.remove(lblAssento05);
                p3.remove(cbxAssentoCombo5);
                p3.add(lblAssento04);
                p3.add(cbxAssentoCombo4);
            }

            if (countTotal ==5 )
            {
                p3.add(lblAssento05);
                p3.add(cbxAssentoCombo5);

            }

            if (countTotal ==0 )
            {
                p3.remove(lblAssento01);
                p3.remove(cbxAssentoCombo1);
                p3.remove(lblAssento02);
                p3.remove(cbxAssentoCombo2);
                p3.remove(lblAssento03);
                p3.remove(cbxAssentoCombo3);
                p3.remove(lblAssento04);
                p3.remove(cbxAssentoCombo4);
                p3.remove(lblAssento05);
                p3.remove(cbxAssentoCombo5);
                p3.remove(btnReservaPassagem);
            }

            // if more tickets than available seats remaining is selected
            // Then an error message states this face
            if (countTotal > seatArrayList.size()-1)
            {
                notEnoughAssentos();
                return;
            }

            // if no tickets are selected, then the 'order' button does not appear
            if (countTotal >0)
            {
                p3.add(btnReservaPassagem);
            }

            // repaint();

            setVisible(true);
        }

        // ActionListener for btnReservaPassagem
        if (action.getSource() == btnReservaPassagem)
        {

            // Validation for purchase of ticket(s)
            Integer orderConfirm = JOptionPane.showConfirmDialog(getContentPane(),
                    "Are You sure you want you want to confirm this purchase?",
                    "Confirm Ticket Purchase?",
                    JOptionPane.YES_NO_OPTION);
            if (orderConfirm ==1)
            {
                return;
            }

            // Get the Values of Each Ticket Quantity ComboBox (e.g. 102, 301, etc)..
            String seat1Store = cbxAssentoCombo1.getSelectedItem().toString();
            String seat2Store = cbxAssentoCombo2.getSelectedItem().toString();
            String seat3Store = cbxAssentoCombo3.getSelectedItem().toString();
            String seat4Store = cbxAssentoCombo4.getSelectedItem().toString();
            String seat5Store = cbxAssentoCombo5.getSelectedItem().toString();

            //Create an array to hold theese values
            Integer[] proceedArray = new Integer[5];
            proceedArray[0] = Integer.parseInt(seat1Store.substring(1));
            proceedArray[1] = Integer.parseInt(seat2Store.substring(1));
            proceedArray[2] = Integer.parseInt(seat3Store.substring(1));
            proceedArray[3] = Integer.parseInt(seat4Store.substring(1));
            proceedArray[4] = Integer.parseInt(seat5Store.substring(1));

            // Repeat code to get value for number of Tickets
            Integer adultCounter = Integer.parseInt((cbxAdultoQuantidade.getSelectedItem().toString()));
            Integer childCounter = Integer.parseInt((cbxCriancaQuantidade.getSelectedItem().toString()));
            Integer oapCounter = Integer.parseInt((cbxIdosoQuantidade.getSelectedItem().toString()));
            Integer countTotal = (adultCounter + childCounter + oapCounter);

            // for the number of tickets selected
            // if that ticket number equals zero (the default value)
            // then state that not all tickets have been assined seats //128
            for (int z=0; z<countTotal; z++)
            {
                if (proceedArray[z] ==0)
                {
                    notSelectedAllAssentos();
                    return;
                }
            }

            // Create a boolean that when true carries out the database portion of this ActionEvent
            boolean proceed = false;

            // Iterates through each object of the array and compares then with each other
            for(int i = 0; i<proceedArray.length;i++)
            {
                for(int p=0; p<proceedArray.length; p++)
                {
                    if(i != p)
                    {
                        // if the two compared objects have the same seat number...
                        if(proceedArray[i].equals(proceedArray[p]))
                        {
                            //...and is not a zero (this is a default value, not a seat number)
                            // then call an error stating duplicate seats have been allocated

                            /* if (proceedArray[i] != 0 || proceedArray[p] != 0)
                            {
                            duplicateAssentos();
                            return;
                            }*/
                        }
                    }
                }

                // if no duplications are found, the rest of the event can proceed
                proceed = true;
            }

            if (proceed == true)
            {

                // Remove the send values from the array
                seatArrayList.remove(seat1Store);
                seatArrayList.remove(seat2Store);
                seatArrayList.remove(seat3Store);
                seatArrayList.remove(seat4Store);
                seatArrayList.remove(seat5Store);

                try{ // Start try/catch
                    // State dependables for reading the database
                    FileInputStream fs = new FileInputStream(voo);
                    DataInputStream in = new DataInputStream(fs);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));

                    // While there are Lines left to be read
                    String stringLine;
                    while ((stringLine = br.readLine()) != null)
                    {
                        // Create dependencies for writing to same file
                        BufferedWriter fw = new BufferedWriter(new FileWriter(voo));

                        int x=0;
                        // Iterate through the new edited array (orginal array minus selected seat)
                        while(x<seatArrayList.size())
                        {
                            // Rewrite every line of the text file with each entry in the new array
                            String line = seatArrayList.get(x).toString();
                            fw.write(line + ";");
                            x++;
                        }
                        //Close the file writing dependency
                        fw.close();

                    }

                    //try/catch end, if error- prints message to command line followed by error code
                }catch (Exception ex){ System.err.println("Error in database manipulation, code: " + ex.getMessage());}

                // Call Pop-up asking user if they want to restart the program for another transaction
                ticketBought();
            }
        }

        // ActionListener for database reset button
        if(action.getSource() == resetButton)
        {
            // When button is selected, A YES/NO messagebox displays
            Integer end = JOptionPane.showConfirmDialog(getContentPane(),
                    "(NOTE: You can only delete databases upon initially loading"+
                    " the program and before selecting any databases).\n"+
                    "If you haven't already done so, please re-run the program and"+
                    " select this option again if you wish to delete the databases.\n"+
                    "The Command will still run regardless, but will not work without"+
                    " the the above steps\n\n"+
                    "Would you like to Reset all the Databases?\n",
                    "Delete Databases?",
                    JOptionPane.YES_NO_OPTION);

            // Is selected answer is YES
            if (end == 0)
            {
                // Ask for validation of deltion
                Integer yesno1 = JOptionPane.showConfirmDialog(getContentPane(),
                        "Are You sure you want you want to delete all the databases?",
                        "Delete Database?",
                        JOptionPane.YES_NO_OPTION);

                // if selected yes
                if (yesno1 == 0)
                {
                    // Delete the current instance of the program
                    TelaMostraAssentos.this.dispose();

                    //Delete Current database
                    File fileToDelete = new File(voo);
                    fileToDelete.delete();

                    // Delete all the databases (stated by name)
                    /*
                    File file1 = new File("SEAT DATABASE 1.00 PM.txt");
                    File file2 = new File("SEAT DATABASE 3.00 PM.txt");
                    File file3 = new File("SEAT DATABASE 5.00 PM.txt");
                    File file4 = new File("SEAT DATABASE 7.00 PM.txt");
                    File file5 = new File("SEAT DATABASE 9.00 PM.txt");
                    file1.delete();
                    file2.delete();
                    file3.delete();
                    file4.delete();
                    file5.delete();
                     */
                    
                    //int size = toppings.length;
                    for (int i=0; i<listaVoosArray.length; i++){
                        File file = new File(listaVoosArray[i]+".txt");
                        file.delete();
                        System.out.println("Arquivo :"+listaVoosArray[i]+".txt"+" deletado!");
                    }

                    // Create new instance of the program (hence restart it)
                    new TelaMostraAssentos(coluna, e, b, f, e_param, b_param, f_param);
                }
            }
        }

    }

    //END OF ACTIONEVENTS

    /**
     * Método retorna o valor total da compra.
     * 
     * 
     */
    // Method that returns total price as as String
    public String getTotal()
    {
        // Get current value of each selected option that effects the price
        Integer childInput = Integer.parseInt(cbxCriancaQuantidade.getSelectedItem().toString());
        Integer oapInput = Integer.parseInt(cbxIdosoQuantidade.getSelectedItem().toString());
        Integer adultInput = Integer.parseInt(cbxAdultoQuantidade.getSelectedItem().toString());

        // Pass this value to 'Ticket.getSeatPrice' method to obtain price
        //int childTicketPrice = Ticket.getSeatPrice(childInput, "child");
        //int adultTicketPrice = Ticket.getSeatPrice(adultInput, "adult");
        //int oapTicketPrice = Ticket.getSeatPrice(oapInput, "oap");

        // Calculate total
        //int total = (childTicketPrice +adultTicketPrice+oapTicketPrice);

        //Convert this integer value to a string in the correct format
        //String totalString = Ticket.calculateStringTotal(total);

        // return totalString;
        return "0";
    }

    /**
     * Método que confirma a compra.
     * 
     * 
     */
    public void ticketBought()
    {
        // Display Message Stating the price of the ordered tickets
        JOptionPane.showMessageDialog(getContentPane(),
            "The total Cost is..£"+getTotal(), "Total Cost", JOptionPane.PLAIN_MESSAGE);

        // Ask user if they want to restart the program
        Integer a = JOptionPane.showConfirmDialog(getContentPane(),
                "Transaction complete\n Would you like to make another?",
                "Transaction Complete", JOptionPane.YES_NO_OPTION);

        // If yes, deletes current instance of program then creates a new one
        if (a == 0)
        {System.out.println("Program Restart Initiated");
            TelaMostraAssentos.this.dispose();
            new TelaMostraAssentos(coluna, e, b, f, e_param, b_param, f_param);
            System.out.println("Nova instância com os parâmetros: "+ coluna +" "+ e +" "+ b +" "+ f +" "+ e_param +" "+ b_param +" "+ f_param);
        }
        // If no, then instance of program is deleted but no new instance is created, hence ending the program
        if (a==1)
        {
            System.exit(0);
        }
    }

    // Methods for displaying error messages
    public void tooManyTickets()
    {
        JOptionPane.showMessageDialog(getContentPane(), "You cannot Process more than 5 tickets at a time!", "Ticket Quantity Error", JOptionPane.ERROR_MESSAGE);
    }

    public void notEnoughAssentos()
    {
        JOptionPane.showMessageDialog(getContentPane(), "There are not enough seats remaining to process the number of tickets selected", "Ticket Quantity Error", JOptionPane.ERROR_MESSAGE);
    }

    public void duplicateAssentos()
    {

        JOptionPane.showMessageDialog(getContentPane(), "There is a duplication of seats!", "Seat Selection Error", JOptionPane.ERROR_MESSAGE);
    }

    public void notSelectedAllAssentos()
    {
        JOptionPane.showMessageDialog(getContentPane(), "Not all seats have been Assigned!", "Seat Selection Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método gráfico que mostra visualização dos assentos reservados na aeronave.
     * 
     * 
     * 
     */
    // Drawn Graphics Method
    public void paint(Graphics g)
    {
        //ArrayList<Integer> list = new ArrayList<Integer>(array);

        super.paint(g);                 // Clears the frame when method is called
        //paint(g);
        //JScrollPane jsp = new JScrollPane(p4);
        //super.add(hbar, BorderLayout.SOUTH);
        //super.add(vbar, BorderLayout.EAST);

        int width = 30;                 // State width of each Rectangle
        int height = 25;                // State height of each Rectangle

        int classeEconomicaAssentosRow = 0;      // State number of Rows in the Left Block
        int classeEconomicaAssentosCol = 0;           // State number of Columns in the Left Block

        int classeEmpresarialAssentosRow = 0;    // State number of Rows in the Center Block
        int classeEmpresarialAssentosCol = 0;    // State number of Columns in the Center Block

        int classePrimeiraAssentosRow = 0;     // State number of Rows in the Right Block
        int classePrimeiraAssentosCol = 0;     // State number of Columns in the Right Block

        if (coluna){ //variavel boolean que informa qual calculo utilizar colunas ou linhas
            classeEconomicaAssentosRow = calcRow(e,ecol);      // State number of Rows in the Left Block
            classeEconomicaAssentosCol = ecol;           // State number of Columns in the Left Block

            classeEmpresarialAssentosRow = calcRow(b, bcol);    // State number of Rows in the Center Block
            classeEmpresarialAssentosCol = bcol;    // State number of Columns in the Center Block

            classePrimeiraAssentosRow = calcRow(f, fcol);     // State number of Rows in the Right Block
            classePrimeiraAssentosCol = fcol;     // State number of Columns in the Right Block

        }else{
            classeEconomicaAssentosRow = erow;     // State number of Rows in the Left Block
            classeEconomicaAssentosCol = calcCol(e,erow);            // State number of Columns in the Left Block

            classeEmpresarialAssentosRow = brow;    // State number of Rows in the Center Block
            classeEmpresarialAssentosCol = calcCol(b, brow);    // State number of Columns in the Center Block

            classePrimeiraAssentosRow = frow;     // State number of Rows in the Right Block
            classePrimeiraAssentosCol = calcCol(f, frow);     // State number of Columns in the Right Block 
        }

        int classeEconomicaPosX = 15;                                                     // Sets Left Block X-axis Position (in Pixels)
        int classeEconomicaPosY = 225;                                                    // Sets Left Block Y-axis Position (in Pixels)

        int classeEmpresarialPosX = (classeEconomicaPosX+(classeEconomicaAssentosCol*width)) +50;        // Sets Center Block X-axis Position (in Pixels)
        int classeEmpresarialPosY = 225;                                                  // Sets Center Block Y-axis Position (in Pixels)

        int classePrimeiraPosX = (classeEmpresarialPosX +(classeEmpresarialAssentosCol*width)) +50;    // Sets Right Block X-axis Position (in Pixels)
        int classePrimeiraPosY = 225;                                                   // Sets Right Block Y-axis Position (in Pixels)

        g.setColor(Color.black);        // Set Default Draw Color to black

        g.drawString("Bloco Esquerdo", (classeEconomicaPosX+(32*(classeEconomicaAssentosCol/2)-25)), (classeEconomicaPosY - 10));            // Title for Each Block
        g.drawString("Bloco Central", (classeEmpresarialPosX+(32*(classeEmpresarialAssentosCol/2)-30)), (classeEmpresarialPosY - 10));
        g.drawString("Bloco Direito", (classePrimeiraPosX+(32*(classePrimeiraAssentosCol/2)-25)), (classePrimeiraPosY - 10));

        //Color custom_grey = new Color(175,175,175);
        Color custom_grey = new Color(0,0,0); //alterado para black
        //DRAW LEFT BLOCK OF SEATS

        for(int i=0; i<classeEconomicaAssentosCol;i++)                                               // Loop while there are Columns..
        {
            String colString = new Integer (i+101).toString();                              // Creates an Integer of relative Seat Number and converts it to a String
            g.drawString(colString, classeEconomicaPosX+5+(i*width), classeEconomicaPosY+20);           // String is affixed to drawSring method and co-ordinates tweaked to center the text in each box.
            g.drawRect(classeEconomicaPosX+(i*width), classeEconomicaPosY, width, height);              // Draw a rectangle at the stated X and Y- Pos. The next rect = X-Pos + (width of rectangle * horizontal psotion) [hence in a sequence]

            if (seatArrayList.contains((i+101)) != true)                                        // If The Array of available seats does not contain i+101 (Seat 1 of classeEconomica is 101, Seat 2 is 102, etc)...
            {

                //g.setColor(Color.red);                                                    // Then change Draw Color to red
                g.setColor(Color.green);
                g.fillRect(classeEconomicaPosX+(i*width), classeEconomicaPosY, width, height);          // Fill in the currently iterated rectangle
                g.setColor(Color.black);                                                    // Change color back to default
                g.drawRect(classeEconomicaPosX+(i*width), classeEconomicaPosY, width, height);          // Redraw the Rectangle
                g.drawString(colString, classeEconomicaPosX+5+(i*width),classeEconomicaPosY+20);        // Redraw the number

            }
            for(int x=0; x<classeEconomicaAssentosRow; x++)                                                  // For each column, loop while there are Rows..
            {
                String rowString = new Integer((i+(classeEconomicaAssentosCol*x))+101).toString();           // [As above]
                g.drawString (rowString, classeEconomicaPosX+5+(i*width), classeEconomicaPosY+(x*height)+20);

                g.drawRect(classeEconomicaPosX+(i*width),classeEconomicaPosY+(x*height), width, height);        // Draw A rectangle exactly like before but with Y-Pos + (height * vertical postition)
                if (seatArrayList.contains((i+(classeEconomicaAssentosCol*x))+101) != true)                  // If the Array of available seats does not contain the relevent seat number...
                {
                    //g.setColor(Color.red);                                                              // Change Draw Color ot red
                    g.setColor(Color.green);
                    g.fillRect(classeEconomicaPosX+(i*width), classeEconomicaPosY+(x*height), width, height);       // Fill in the currently iterated rectangle
                    g.setColor(Color.black);                                                            // Change draw color back to default
                    g.drawRect(classeEconomicaPosX+(i*width), classeEconomicaPosY+(x*height), width, height);       // Redraw outline of rectangle
                    g.setColor(custom_grey);                                                            // Set Color to Custom
                    g.drawString (rowString, classeEconomicaPosX+5+(i*width), classeEconomicaPosY+(x*height)+20);   // Redraw number
                    g.setColor(Color.black);                                                            // Change color back to default

                }
            }
        }

        // DRAW CENTER BLOCK OF SEATS
        for(int i=0; i<classeEmpresarialAssentosCol;i++)                                                 // [Refer to Left Block Code comments]
        {
            String colString = new Integer (i+201).toString();
            g.drawString (colString, classeEmpresarialPosX+5+(i*width), classeEmpresarialPosY+20);
            g.drawRect(classeEmpresarialPosX+(i*width), classeEmpresarialPosY, width, height);

            if (seatArrayList.contains((i+201)) != true)
            {
                //g.setColor(Color.red);
                g.setColor(Color.green);
                g.fillRect(classeEmpresarialPosX+(i*width), classeEmpresarialPosY, width, height);
                g.setColor(Color.black);
                g.drawRect(classeEmpresarialPosX+(i*width), classeEmpresarialPosY, width, height);
                g.drawString(colString, classeEmpresarialPosX+5+(i*width), classeEmpresarialPosY+20);
            }

            for (int x=0; x<classeEmpresarialAssentosRow; x++)
            {
                String rowString = new Integer ((i+(classeEmpresarialAssentosCol*x))+201).toString();
                g.drawString(rowString, classeEmpresarialPosX+5+(i*width), classeEmpresarialPosY+(x*height)+20);

                g.drawRect(classeEmpresarialPosX+(i*width), classeEmpresarialPosY+(x*height), width, height);
                if (seatArrayList.contains((i+(classeEmpresarialAssentosCol*x))+201) != true)
                {
                    //g.setColor(Color.red);
                    g.setColor(Color.green);
                    g.fillRect(classeEmpresarialPosX+(i*width), classeEmpresarialPosY+(x*height), width, height);
                    g.setColor(Color.black);
                    g.drawRect(classeEmpresarialPosX+(i*width), classeEmpresarialPosY+(x*height), width, height);
                    g.setColor(custom_grey);
                    g.drawString (rowString, classeEmpresarialPosX+5+(i*width), classeEmpresarialPosY+(x*height)+20);
                    g.setColor(Color.black);
                }
            }
        }

        //DRAW RIGHT BLOCK OF SEATS

        for (int i=0; i<classePrimeiraAssentosCol;i++)                                                 // [Refer to Left Block Code comments]
        {
            String colString = new Integer (i+301).toString();
            //String colString = "?";
            g.drawString(colString, classePrimeiraPosX+5+(i*width), classePrimeiraPosY+20);

            g.drawRect(classePrimeiraPosX+(i*width), classePrimeiraPosY, width, height);
            if (seatArrayList.contains((i+301)) != true)
            {
                g.setColor(Color.red);
                //g.setColor(Color.green);
                g.fillRect(classePrimeiraPosX+(i*width),classePrimeiraPosY,width,height);
                g.setColor(Color.black);
                g.drawRect(classePrimeiraPosX+(i*width), classePrimeiraPosY, width, height);
                g.drawString (colString, classePrimeiraPosX+5+(i*width), classePrimeiraPosY+20);
            }

            for(int x=0; x<classePrimeiraAssentosRow; x++)
            {
                String rowString = new Integer ((i+(classePrimeiraAssentosCol*x))+301).toString();
                //String rowString = "?";

                g.drawString (rowString, classePrimeiraPosX+5+(i*width), classePrimeiraPosY+(x*height)+20);

                g.drawRect(classePrimeiraPosX+(i*width), classePrimeiraPosY+(x*height), width, height);
                if (seatArrayList.contains((i+(classePrimeiraAssentosCol*x))+301) != true)
                {
                    g.setColor(Color.red);
                    //g.setColor(Color.green);
                    g.fillRect(classePrimeiraPosX+(i*width), classePrimeiraPosY+(x*height), width, height);
                    g.setColor(Color.black);
                    g.drawRect(classePrimeiraPosX+(i*width), classePrimeiraPosY+(x*height), width, height);
                    g.setColor(custom_grey);
                    g.drawString (rowString, classePrimeiraPosX+5+(i*width), classePrimeiraPosY+(x*height)+20);
                    g.setColor(Color.black);
                }
            }
        }

    }

    public static void main (String[] args)     // Main Method Declaration
    {
        new TelaMostraAssentos(true, 60, 50, 10, 3, 4, 5);                             // Cria uma nova instância de TelaMostraAssentos.
    }
}