package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.model.repositories.ReclamacaoRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroReclamacao {

    private final ReclamacaoRepository reclamacaoRepository;

    @FXML
    private TextField tfReclamar;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfSetor;

    @FXML
    private DatePicker datePicker;

    public CadastroReclamacao(ReclamacaoRepository reclamacaoRepository) {
        this.reclamacaoRepository = reclamacaoRepository;
    }

    @FXML
    private void cadastrar() {
        String reclamacao = tfReclamar.getText();
        String endereco = tfEndereco.getText();
        String setor = tfSetor.getText();
        // Supondo que você precise da data selecionada do DatePicker
        // DatePicker possui um método getValue() que retorna um LocalDate

        // Tenta cadastrar a reclamação
        Result resultadoCadastro = reclamacaoRepository.cadastrarReclamacao(reclamacao, endereco, setor, datePicker.getValue());

        // Verifica se houve algum erro no cadastro da reclamação
        if (resultadoCadastro.isSuccess()) {
            exibirAlerta(Alert.AlertType.INFORMATION, resultadoCadastro.getMsg());
            BaseAppNavigator.popScreen();
            BaseAppNavigator.pushScreen("LOGIN");
        } else {
            exibirAlerta(Alert.AlertType.ERROR, resultadoCadastro.getMsg());
        }
    }

    private void exibirAlerta(Alert.AlertType tipoAlerta, String mensagem) {
        Alert alert = new Alert(tipoAlerta);
        alert.setHeaderText(mensagem);
        alert.showAndWait();
    }

    public void voltar() {
        BaseAppNavigator.popScreen();
    }
}
