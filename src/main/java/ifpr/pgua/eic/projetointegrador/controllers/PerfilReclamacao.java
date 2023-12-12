package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.model.entities.Reclamacao;
import ifpr.pgua.eic.projetointegrador.model.repositories.ReclamacaoRepository;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PerfilReclamacao implements Initializable{

    static private Reclamacao reclamacao;

    @FXML
    private Button inativarButton;

    public static void setReclamacao(Reclamacao reclamacao) {
        PerfilReclamacao.reclamacao = reclamacao;
    }

    private Boolean inativar;

    public PerfilReclamacao(ReclamacaoRepository reclamacaoR) {
    }

    @FXML
    public void sair(){
        BaseAppNavigator.popScreen();
        BaseAppNavigator.popScreen();

    }

    @FXML
    public void voltar(){
        BaseAppNavigator.popScreen();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        inativar = reclamacao.getStatus();
       
        if(inativar){
           
            inativarButton.setText("DESATIVAR");
        }else{
            
            inativarButton.setText("ATIVAR");

        }
        
    }
    
}