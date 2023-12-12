package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.entities.Cidadao;
import ifpr.pgua.eic.projetointegrador.model.entities.Reclamacao;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface CidadaoDAO {
    
    public Result cadastrarCidadao(Cidadao cidadao);

    public List<Reclamacao> visualizarReclamacao();

    public Cidadao login(String email, String senha);
}