package CommandPatternExample;
public class CommandPatternTest {
    public static void main(String[] args) {
        // Create the receiver object
        Light light = new Light();

        // Create command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create the invoker
        RemoteControl remote = new RemoteControl();

        // Set command and execute
        remote.setCommand(lightOn);
        System.out.println("Pressing button to turn on the light:");
        remote.pressButton();

        remote.setCommand(lightOff);
        System.out.println("Pressing button to turn off the light:");
        remote.pressButton();
    }
}