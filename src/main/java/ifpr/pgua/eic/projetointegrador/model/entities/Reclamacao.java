package ifpr.pgua.eic.projetointegrador.model.entities;

import java.time.LocalDate;

public class Reclamacao {

    private int idReclamacao;
    private String reclamar;
    private String endereco;
    private String setor;
    private LocalDate dataDaReclamacao;
    private Boolean status;

    public Reclamacao(String reclamar, String endereco, String setor, LocalDate dataDaReclamacao) {
        this.reclamar = reclamar;
        this.endereco = endereco;
        this.setor = setor;
        this.dataDaReclamacao = dataDaReclamacao;
        this.status = true;
    }

    public Reclamacao(String reclamar, String endereco, String setor, String setorReclamacao) {
        this.reclamar = reclamar;
        this.endereco = endereco;
        this.setor = setor;
        // Lógica para inicializar outros atributos, se necessário
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getIdReclamacao() {
        return idReclamacao;
    }

    public void setIdReclamacao(int idReclamacao) {
        this.idReclamacao = idReclamacao;
    }

    public LocalDate getDataDaReclamacao() {
        return dataDaReclamacao;
    }

    public void setDataDaReclamacao(LocalDate dataDaReclamacao) {
        this.dataDaReclamacao = dataDaReclamacao;
    }

    public void alternarStatusPerfil(Boolean status) {
        this.status = status;
    }

    public void editarReclamacao(Reclamacao reclamacao) {
        // Lógica para editar uma reclamação
    }

    @Override
    public String toString() {
        String msg = "Id: " + idReclamacao;
        msg += "\nReclamar: " + reclamar;
        msg += "\nEndereco: " + endereco;
        msg += "\nSetor: " + setor;
        msg += "\nData da Reclamacao: " + dataDaReclamacao;
        msg += "\nStatus: " + status + "\n\n";

        return msg;
    }

    // Getters e Setters
    public String getReclamar() {
        return reclamar;
    }

    public void setReclamar(String reclamar) {
        this.reclamar = reclamar;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
