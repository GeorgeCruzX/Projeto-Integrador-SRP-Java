package ifpr.pgua.eic.projetointegrador.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.time.LocalDate;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.ReclamacaoDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Reclamacao;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCReclamacaoDAO implements ReclamacaoDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCReclamacaoDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

//    @Override
//    public Result cadastrarReclamacao(Reclamacao reclamacao) {
//        try {
//            Connection con = fabricaConexoes.getConnection();
//            PreparedStatement pstm = con.prepareStatement(
//                    "INSERT INTO sua_tabela(reclamar, endereco, setor_reclamacao, data_da_reclamacao, status_reclamaacao) VALUES (?, ?, ?, ?, ?)");
//            pstm.setString(1, reclamacao.getReclamar());
//            pstm.setString(2, reclamacao.getEndereco());
//            pstm.setString(3, reclamacao.getSetor());
//            pstm.setObject(4, reclamacao.getDataDaReclamacao());
//            pstm.setBoolean(5, true);
//
//            int rowsAffected = pstm.executeUpdate();
//
//            pstm.close();
//            con.close();
//
//            if (rowsAffected > 0) {
//                return Result.success("Cadastro Realizado");
//            } else {
//                return Result.fail("Não foi possível cadastrar");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Result.fail("Erro ao cadastrar");
//        }
//    }

    @Override
    public Reclamacao login(String email, String senha) {
        try {
            Reclamacao reclamacao = null;
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM sua_tabela WHERE email = ? AND senha = ?");

            pstm.setString(1, email);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                reclamacao = new Reclamacao(rs.getString("reclamar"), rs.getString("endereco"), rs.getString("setor_reclamacao"), LocalDate.parse(rs.getString("data_da_reclamacao")));
            }

            rs.close();
            pstm.close();
            con.close();

            return reclamacao;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public void inativar(Boolean inativar, int codigo) {
//        try {
//            Connection con = fabricaConexoes.getConnection();
//            PreparedStatement pstm = con.prepareStatement("UPDATE sua_tabela SET status_reclamacao = ? WHERE idReclamacao = ?");
//
//            pstm.setBoolean(1, inativar);
//            pstm.setInt(2, codigo);
//            pstm.executeUpdate();
//
//            pstm.close();
//            con.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void inativar(Boolean inativar, String string) {
        // Implementação necessária para a interface, caso seja utilizada.
    }

    // Este método não deve ser implementado na interface, removendo a exceção
    @Override
    public Result cadastrarCidadao(Reclamacao reclamacao) {
        return Result.fail("Método não suportado neste DAO");
    }
}
