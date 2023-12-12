package ifpr.pgua.eic.projetointegrador.utils.Navigator;

import javafx.scene.Parent;
import javafx.util.Callback;

public class ScreenRegistryFXML implements ScreenRegistry {
    
    private final Class<?> classe;
    private final String fxml;
    private final Callback<Class<?>, Object> controllerMaker;
    
    public ScreenRegistryFXML(Class<?> classe, String fxml, Callback<Class<?>, Object> controllerMaker) {
        this.classe = classe;
        this.fxml = fxml;
        this.controllerMaker = controllerMaker;
    }

    public Parent getRoot() {
        return LoaderFXML.loadFxml(classe.getResource(fxml), controllerMaker);
    }
    
}
