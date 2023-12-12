package ifpr.pgua.eic.projetointegrador.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ifpr.pgua.eic.projetointegrador.utils.Env;

public class FabricaConexoes {
    private static final int MAX_CONEXOES=5;

    private final String URL_DB;
    private final String DB_NAME;
    private final String USER;
    private final String PASSWORD;
    private final String CON_STRING;

    private static FabricaConexoes instance;

    private Connection[] conexoes;

    private FabricaConexoes(){
        conexoes = new Connection[MAX_CONEXOES];

        URL_DB = Env.get("URL_DB");
        DB_NAME = Env.get("DB_NAME");
        CON_STRING = URL_DB+"/"+DB_NAME;
        USER = Env.get("DB_USER");
        PASSWORD = Env.get("DB_PASSWORD");
    }

    public static FabricaConexoes getInstance(){
        if(instance == null){
            instance = new FabricaConexoes();
            return instance;
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{

        for(int i=0;i<MAX_CONEXOES;i++){
            if (instance.conexoes[i] == null || instance.conexoes[i].isClosed()) {
                instance.conexoes[i] = DriverManager.getConnection(CON_STRING, USER, PASSWORD);
                return instance.conexoes[i];
                
            }
        }
        throw new SQLException("Não há conexões disponíveis! Esqueceu de fechar?");
    }
}
