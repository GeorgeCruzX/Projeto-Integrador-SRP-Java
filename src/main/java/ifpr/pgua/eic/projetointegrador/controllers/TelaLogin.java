package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.model.entities.Cidadao;
import ifpr.pgua.eic.projetointegrador.model.repositories.CidadaoRepository;
import ifpr.pgua.eic.projetointegrador.model.repositories.ReclamacaoRepository;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLogin {

    private CidadaoRepository cidadao;
    private Cidadao cidadaoR;
    @FXML
    private TextField tfEmail;
 
    @FXML
    private PasswordField pfSenha;

    public TelaLogin(CidadaoRepository cidadao, ReclamacaoRepository reclamacao) {
        this.cidadao = cidadao;
    }

    public void entrar() {
              
        Alert alerta = new Alert(Alert.AlertType.NONE);

        cidadaoR = cidadao.loginCidadao(tfEmail.getText(),pfSenha.getText());


        if(cidadaoR != null){
            alerta.setAlertType(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("LOGADO");
            alerta.showAndWait();
            BaseAppNavigator.popScreen();
        }
        else{
            alerta.setAlertType(Alert.AlertType.ERROR);
            alerta.setHeaderText("Login ou Senha incorretos");
            alerta.showAndWait();
        }

    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
    
}