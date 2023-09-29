package abstractFactory.app;

import abstractFactory.buttons.Button;
import abstractFactory.checkboxes.Checkbox;
import abstractFactory.factories.GUIFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckBox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
