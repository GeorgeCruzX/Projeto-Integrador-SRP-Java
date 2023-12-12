package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;

import javafx.fxml.FXML;

public class PerfilCidadao {
    
    @FXML
    public void sair(){
        BaseAppNavigator.popScreen();
        BaseAppNavigator.popScreen();

    }

    @FXML
    public void voltar(){
        BaseAppNavigator.popScreen();

    }
}