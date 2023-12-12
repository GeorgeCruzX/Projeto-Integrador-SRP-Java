package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.time.LocalDate;

import ifpr.pgua.eic.projetointegrador.model.daos.ReclamacaoDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Reclamacao;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class ReclamacaoRepository {
    private ReclamacaoDAO dao;

    public ReclamacaoRepository(ReclamacaoDAO dao) {
        this.dao = dao;
    }

    public Result cadastrarReclamacao(Reclamacao reclamacao) {
        return dao.cadastrarCidadao(reclamacao);

    }

    public Reclamacao loginReclamacao(String email, String senha){
        return dao.login(email, senha);
    }

    public void inativar(Boolean inativar,String string){
        
        dao.inativar(inativar,string);
        
    }

    public Result cadastrarReclamacao(String reclamacao, String endereco, String setor, LocalDate value) {
        return null;
    }

}
