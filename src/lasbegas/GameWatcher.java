package lasbegas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWatcher extends WindowAdapter {
	
	private Menu mainMenu;
	
	public GameWatcher(Menu mm) {
		mainMenu = mm;
	}
	
	public void windowClosing(WindowEvent e) {
		mainMenu.setVisible(true);
	}
}