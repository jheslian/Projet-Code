package Fenetres;

import objects.BaseClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Bienvenue extends JFrame {
    BaseClient baseClient = new BaseClient();

    public Bienvenue(){
        super("Bienvenue");

        this.setSize( 700, 500 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );


/******************     creation des panels   ********************/
        /*
        JPanel panel = (JPanel)this.getContentPane();
        panel.setLayout( new FlowLayout() );

         */
        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(new GridLayout(5, 2));

        JPanel panel1 = new JPanel();
        panel1.setLayout( new FlowLayout() );
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel1);
        this.getContentPane().add(split, BorderLayout.CENTER);
/*******************************************     creation de compte client    *****************************************************/

        /******************     Nom   ********************/
        JLabel nvNomLabel = new JLabel("Nom"); //  nom
        JTextField nvNomTextField = new JTextField();
        nvNomTextField.setPreferredSize( new Dimension(100,30) );
        panel.add( nvNomLabel );
        panel.add( nvNomTextField );

        /******************     Prenom   ********************/
        JLabel nvPrenomLabel = new JLabel("Prenom"); //prenom
        JTextField nvPrenomTextField = new JTextField();
        nvPrenomTextField.setPreferredSize( new Dimension(100,30) );
        panel.add( nvPrenomLabel );
        panel.add( nvPrenomTextField );

        /******************     Email    ********************/
        JLabel nvEmailLabel = new JLabel("Email"); // email
        JTextField nvEmailTextField = new JTextField();
        nvEmailTextField.setPreferredSize( new Dimension(100,30) );
        panel.add( nvEmailLabel );
        panel.add( nvEmailTextField );

        /******************     Mot de passe    ********************/

        JLabel nvMotDePasseLabel = new JLabel("Mot De Passe"); // mot de passe
        JPasswordField nvMotDePasseTextField = new JPasswordField();
        nvEmailTextField.setPreferredSize( new Dimension(200,30) );
        panel.add( nvMotDePasseLabel );
        panel.add( nvMotDePasseTextField );

        /******************     Valider creation de compte   ********************/

        JButton validerBouton = new JButton("Valider");
        panel.add( validerBouton );

        validerBouton.addActionListener( e -> {
            if (baseClient.isClientExist( (nvEmailTextField.getText()).trim(), (nvMotDePasseTextField.getText()).trim() )) {
                JOptionPane.showMessageDialog( null, "Le compte existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE );
            }else
                baseClient.creeClient( (nvNomTextField.getText()).trim(), (nvPrenomTextField.getText()).trim(), (nvEmailTextField.getText()).trim(), (nvMotDePasseTextField.getText()).trim() );

                nvNomTextField.setText( "" );
                nvPrenomTextField.setText( "" );
                nvEmailTextField.setText( "" );
                nvMotDePasseTextField.setText( "" );
            });

/*******************************************     Connexion    *****************************************************/


        /******************     identifiant (email)   ********************/
        JLabel idLabel = new JLabel("Identifiant");
        panel1.add( idLabel );

        JTextField idTextField = new JTextField();
        idTextField.setToolTipText( "Email: email@sample.com" );
        idTextField.setPreferredSize( new Dimension(150,30));
        panel1.add( idTextField );

        /******************     Mot de passe    ********************/
        JLabel motDePasseLabel = new JLabel("Mot De Passe");  //mot de passe
        panel1.add( motDePasseLabel );

        JPasswordField motDePasseField = new JPasswordField();
        motDePasseField.setPreferredSize( new Dimension(150,30) );
        panel1.add( motDePasseField );


        /******************     Connexion client    ********************/
        JButton clientBouton = new JButton("Client"); // client
        panel1.add( clientBouton );

        clientBouton.addActionListener( e-> {
            if (baseClient.isClientExist( nvEmailTextField.getText().trim(), nvMotDePasseTextField.getText().trim() )){
                this.setVisible( false );
            }else
                JOptionPane.showMessageDialog( null, "Erreur de saisie ou compte n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE );

        } );

        /******************     Administrateur    ********************/
        JButton administrateurBouton = new JButton("Administrateur"); // administrateur
        panel1.add( administrateurBouton );

        /******************     Quitter    ********************/
        JButton quitterBouton = new JButton("Quitter"); // quitter
        panel1.add( quitterBouton );



    }

}
