package ifpr.pgua.eic.projetointegrador.utils.Navigator;

import javafx.scene.Parent;
import javafx.util.Callback;

public class ScreenRegistryNoFXML implements ScreenRegistry {
    
    private final Callback<Object, Object> constructor;
    
    public ScreenRegistryNoFXML(Callback<Object, Object> constructor) {
        this.constructor = constructor;
    }

    public Parent getRoot() {
        Object constructedObject = constructor.call(null);
        if (constructedObject instanceof Parent) {
            return (Parent) constructedObject;
        } else {
            throw new IllegalArgumentException("O construtor não criou um elemento Parent.");
        }
    }
}
