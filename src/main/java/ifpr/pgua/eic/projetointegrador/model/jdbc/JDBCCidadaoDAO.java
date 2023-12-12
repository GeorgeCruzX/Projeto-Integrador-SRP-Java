package ifpr.pgua.eic.projetointegrador.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.CidadaoDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Cidadao;
import ifpr.pgua.eic.projetointegrador.model.entities.Reclamacao;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCCidadaoDAO implements CidadaoDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCCidadaoDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result cadastrarCidadao(Cidadao cidadao) {
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement(
                    "INSERT INTO Cidadão(nome,cpf,email,senha) VALUES (?,?,?,?)");
            pstm.setString(1, cidadao.getNome());
            pstm.setString(2, cidadao.getCpf());
            pstm.setString(3, cidadao.getEmail());
            pstm.setString(4, cidadao.getSenha());
            //pstm.setBoolean(5, true);

            int rowsAffected = pstm.executeUpdate();

            pstm.close();
            con.close();

            if (rowsAffected > 0) {
                return Result.success("Cadastro Realizado");
            } else {
                return Result.fail("Não foi possível cadastrar");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return Result.fail("Erro ao cadastrar");
        }
    }

    @Override
    public Cidadao login(String email, String senha) {
        try {
            Cidadao cidadao = null;
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM sua_tabela WHERE email = ? AND senha = ?");

            pstm.setString(1, email);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                cidadao = new Cidadao(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
            }

            rs.close();
            pstm.close();
            con.close();

            return cidadao;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reclamacao> visualizarReclamacao() {
        List<Reclamacao> listaReclamacao = new ArrayList<>();
        try {
            Connection con = fabricaConexoes.getConnection();
            String query = "SELECT reclamar, endereco, setor_reclamacao, datadareclamacao FROM sua_tabela where status_reclamacao = 1";
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Reclamacao reclamacao = new Reclamacao(rs.getString("reclamar"), rs.getString("endereco"),
                        rs.getString("setor_reclamacao"), rs.getString("datadareclamacao"));
                listaReclamacao.add(reclamacao);
            }

            rs.close();
            pstm.close();
            con.close();

            return listaReclamacao;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
