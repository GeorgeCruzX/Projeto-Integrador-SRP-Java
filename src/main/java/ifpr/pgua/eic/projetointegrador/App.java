package ifpr.pgua.eic.projetointegrador;


import ifpr.pgua.eic.projetointegrador.controllers.TelaLogin;
import ifpr.pgua.eic.projetointegrador.controllers.CadastroCidadao;
import ifpr.pgua.eic.projetointegrador.controllers.CadastroReclamacao;
import ifpr.pgua.eic.projetointegrador.controllers.PerfilCidadao;
import ifpr.pgua.eic.projetointegrador.controllers.PerfilReclamacao;
import ifpr.pgua.eic.projetointegrador.controllers.TelaPrincipal;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.CidadaoDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.ReclamacaoDAO;
import ifpr.pgua.eic.projetointegrador.model.jdbc.JDBCCidadaoDAO;
import ifpr.pgua.eic.projetointegrador.model.jdbc.JDBCReclamacaoDAO;
import ifpr.pgua.eic.projetointegrador.model.repositories.CidadaoRepository;
import ifpr.pgua.eic.projetointegrador.model.repositories.ReclamacaoRepository;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {


    //DEFINIR A FABRICA DE CONEXÕES, DAOS e REPOSITÓRIOS

    private FabricaConexoes fabricaConexoes;
    private CidadaoDAO clienteDao;
    private CidadaoRepository clienteRepository;

    private ReclamacaoRepository devRepository;
    private ReclamacaoDAO devDAO;

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();
        
        //INSTANCIAR FABRICA, DAOS E REPOSITÓRIOS

        fabricaConexoes = FabricaConexoes.getInstance();

        clienteDao = new JDBCCidadaoDAO(fabricaConexoes);

        clienteRepository = new CidadaoRepository(clienteDao);

        devDAO = new JDBCReclamacaoDAO(fabricaConexoes);

        devRepository = new ReclamacaoRepository(devDAO);
    
    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }



    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "SRP - Sistema de Reclamação Popular";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(getClass(), "fxml/telaprincipal.fxml", (o)->new TelaPrincipal()));
        registraTela("CLIENTE", new ScreenRegistryFXML(getClass(), "fxml/cadastrocidadao.fxml", (o)->new CadastroCidadao(clienteRepository)));
        registraTela("DEV", new ScreenRegistryFXML(getClass(), "fxml/cadastroreclamacao.fxml", (o->new CadastroReclamacao(devRepository))));
        registraTela("LOGIN", new ScreenRegistryFXML(getClass(), "fxml/login.fxml", (o->new TelaLogin(clienteRepository,devRepository))));
        registraTela("PC", new ScreenRegistryFXML(getClass(), "fxml/perfilCliente.fxml", o->new PerfilCidadao()));
        registraTela("PD", new ScreenRegistryFXML(getClass(), "fxml/perfilDev.fxml", o->new PerfilReclamacao(devRepository)));



        

        
        //REGISTRAR AS OUTRAS TELAS

    }


}