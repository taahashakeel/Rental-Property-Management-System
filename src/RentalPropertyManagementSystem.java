import gui.GUI;
import gui.WindowListener;

public class RentalPropertyManagementSystem{
  GUI gui;

  public static void main(String[] args){
    System.out.println("Running program...");

    RentalPropertyManagementSystem app = new RentalPropertyManagementSystem();
    app.createWindow();
  }

  private void createWindow(){
    gui = new GUI();
    WindowListener guiListener = new WindowListener();

    gui.addWindowListener(guiListener);

    gui.setVisible(true);
  }
}
