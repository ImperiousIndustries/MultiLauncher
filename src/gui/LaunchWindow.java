package gui;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LaunchWindow extends JFrame {
	public JPanel panel;
	public ArrayList<AppButton> apps;

	public LaunchWindow() {
		super("Launch");

		apps = new ArrayList<AppButton>();
		// add apps.

		for (int i = 0; i < apps.size(); i++) {
			panel.add(apps.get(i));
		}
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(new AppButton("FTB", "/Users/pjk/The Minecraft Keeper/Minecraft Backups and Stuff/Applications/FTB_Launcher.jar", "logo_ftb.png", "selected_logo_ftb.png"));
		panel.add(new AppButton("Minecraft", "/Applications/Minecraft.app", "/Users/pjk/Noah/MinecraftImage2.png", "/Users/pjk/Noah/MinecraftImage2.png"));
		panel.add(new AppButton("Technic Launcher", "/Users/pjk/The Minecraft Keeper/Minecraft Backups and Stuff/Applications/TechnicLauncher.jar", "/Users/pjk/Noah/TechnicLauncerImage2.png", "/Users/pjk/Noah/TechnicLauncerImage2.png"));
		add(panel);

		try {
			System.out.println(Inet4Address.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	class LaunchAction extends AbstractAction {
		String path;

		public LaunchAction(String path, String app) {
			super("Launch " + app);
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
