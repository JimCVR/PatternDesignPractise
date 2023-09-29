package abstractFactory.factories;

import abstractFactory.buttons.Button;
import abstractFactory.buttons.WindowsButton;
import abstractFactory.checkboxes.Checkbox;
import abstractFactory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new WindowsCheckbox();
    }
}
