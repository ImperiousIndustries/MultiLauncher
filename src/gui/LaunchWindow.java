package gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LaunchWindow extends JFrame {
	public JPanel panel;

	public LaunchWindow() {
		super("Launch");

		panel = new JPanel();

		panel.add(new JButton(new LaunchAction("FTB_Launcher.jar", "Minecraft")));
		add(panel);
		try {
			System.out.println(Inet4Address.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	class LaunchAction extends AbstractAction {
		String path;

		public LaunchAction(String path, String app) {
			super("Launch" + app);
			this.path = path;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Desktop.getDesktop().open(new File(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
