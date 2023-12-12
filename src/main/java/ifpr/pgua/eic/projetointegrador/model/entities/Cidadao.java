package ifpr.pgua.eic.projetointegrador.model.entities;

import java.util.List;

public class Cidadao {

    private int idCidadao;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Boolean status;
    private List<Reclamacao> projetos;

    public Cidadao(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.status = true;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getIdCidadao() {
        return idCidadao;
    }

    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Reclamacao> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Reclamacao> projetos) {
        this.projetos = projetos;
    }

    public void editarPerfil() {
        // Lógica para edição do perfil
    }

    public void alternarStatus() {
        // Lógica para alternar status
    }

    public List<Reclamacao> buscarReclamacao(int idReclamacao, String nome) {
        // Lógica para buscar reclamações
        return null;
    }

    public void visualizarReclamacao() {
        // Lógica para visualizar reclamações
    }

    public void interagirComChat() {
        // Lógica para interação com chat
    }
}
