package ifpr.pgua.eic.projetointegrador.model.jdbc;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Cidadao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCLoginDAO {
    private FabricaConexoes fabricaConexoes;

    public JDBCLoginDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    public Cidadao login(Cidadao cidadao){
        try {
            Connection con = fabricaConexoes.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT email , senha from XXXXXXXXXXXXXX where email = ? and senha = ?");
            PreparedStatement pstm2 = con.prepareStatement("SELECT email , senha from XXXXXXXXXXXXXX where email = ? and senha = ?");
            
            pstm.setString(1, cidadao.getEmail());
            pstm.setString(2, cidadao.getSenha());
            pstm2.setString(1, cidadao.getEmail());
            pstm2.setString(2, cidadao.getSenha());

            ResultSet rs = pstm.executeQuery();
            ResultSet rs2 = pstm2.executeQuery();        

            if(rs == null && rs2 == null){
                pstm.close();
                pstm2.close();
                con.close();
                return null;
            }else{
                rs.close();
                rs2.close();
                pstm.close();
                pstm2.close();
                con.close();
                return cidadao;
            }
        
        }catch (Exception e){
            return null;
        }

    }
}