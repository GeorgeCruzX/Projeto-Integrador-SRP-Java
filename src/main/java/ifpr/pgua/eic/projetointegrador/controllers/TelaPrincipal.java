package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;

public class TelaPrincipal{

    public void cadastroCliente() {
        BaseAppNavigator.pushScreen("CLIENTE");
    }

    public void cadastroDev() {
        BaseAppNavigator.pushScreen("DEV");
    }

    public void login() {
        BaseAppNavigator.pushScreen("LOGIN");
    }
}