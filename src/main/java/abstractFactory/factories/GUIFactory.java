package abstractFactory.factories;

import abstractFactory.buttons.Button;
import abstractFactory.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckBox();
}
