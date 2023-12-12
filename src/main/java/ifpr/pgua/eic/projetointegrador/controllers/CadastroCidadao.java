package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.model.entities.Cidadao;
import ifpr.pgua.eic.projetointegrador.model.repositories.CidadaoRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.FailResult;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroCidadao {

    private final CidadaoRepository cidadaoRepository;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    public CadastroCidadao(CidadaoRepository cidadaoRepository) {
        this.cidadaoRepository = cidadaoRepository;
    }

    @FXML
    private void cadastrar() {
        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regx);
        Alert alert = new Alert(AlertType.NONE);

        String email = tfEmail.getText();
        Matcher matcher = pattern.matcher(email);

        Result erro;

        if (matcher.matches() && email.contains(".")) {
            Cidadao cidadao = new Cidadao(tfNome.getText(), tfCPF.getText(), email, tfSenha.getText());
            erro = cidadaoRepository.cadastrarCidadao(cidadao);
        } else {
            erro = Result.fail("Email inválido");
            alert.setAlertType(AlertType.ERROR);
            alert.setHeaderText(erro.getMsg());
            alert.show();
            return;
        }

        if (erro instanceof FailResult) {
            alert.setAlertType(AlertType.ERROR);
        } else {
            alert.setAlertType(AlertType.INFORMATION);
            alert.setHeaderText(erro.getMsg());
            alert.showAndWait();

            BaseAppNavigator.popScreen();
            BaseAppNavigator.pushScreen("LOGIN");
        }
    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
