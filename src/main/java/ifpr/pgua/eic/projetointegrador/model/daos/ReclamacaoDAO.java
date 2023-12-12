package ifpr.pgua.eic.projetointegrador.model.daos;

import ifpr.pgua.eic.projetointegrador.model.entities.Reclamacao;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface ReclamacaoDAO {
    public Result cadastrarCidadao(Reclamacao reclamacao);

    public Reclamacao login(String email, String senha);

    public void inativar(Boolean inativar,String string);
      
}