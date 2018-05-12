package designPatternsNew.creational.abstractFactoryNew;

/**
 * Created by aditya.dalal on 10/03/18.
 */
public class Client {
    public static void main(String[] args) {
        Application application = new Application(new MacGUIFactory());
        application.paint();
    }
}

interface Button {
    void paint();
}

class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button");
    }
}

class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows button");
    }
}

interface Textbox {
    void paint();
}

class MacTexbox implements Textbox {

    @Override
    public void paint() {
        System.out.println("Mac textbox");
    }
}

class WinTextbox implements Textbox {

    @Override
    public void paint() {
        System.out.println("Win textbox");
    }
}

interface GUIFactory {
    Button createButton();
    Textbox createTextBox();
}

class WinGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Textbox createTextBox() {
        return new WinTextbox();
    }
}

class MacGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Textbox createTextBox() {
        return new MacTexbox();
    }
}

class Application {
    Button button;
    Textbox textbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        textbox = factory.createTextBox();
    }

    public void paint() {
        button.paint();
        textbox.paint();
    }
}