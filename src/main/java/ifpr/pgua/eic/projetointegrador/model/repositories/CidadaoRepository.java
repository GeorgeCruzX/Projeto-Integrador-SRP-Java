package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.daos.CidadaoDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Cidadao;
import ifpr.pgua.eic.projetointegrador.model.entities.Reclamacao;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class CidadaoRepository {
    private CidadaoDAO dao;

    public CidadaoRepository(CidadaoDAO dao) {
        this.dao = dao;
    }

    public Result cadastrarCidadao(Cidadao cidadao){
        return dao.cadastrarCidadao(cidadao);
    }

    public List<Reclamacao> visualizarReclamacao(){
        return dao.visualizarReclamacao();
    }

    public Cidadao loginCidadao(String email, String senha){
        return dao.login(email,senha);
    }

}