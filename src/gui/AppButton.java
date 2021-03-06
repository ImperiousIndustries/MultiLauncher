package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AppButton extends JPanel {

	String name, filePath, imagePath, imageSelectedPath, currentImage;

	public AppButton(String name, String filePath, String imagePath,
			String imageSelectedPath) {
		this.name = name;
		this.filePath = filePath;
		this.imagePath = imagePath;
		currentImage = imagePath;
		this.imageSelectedPath = imageSelectedPath;
		setPreferredSize(new Dimension(100, 100));
		setMinimumSize(new Dimension(100, 100));
		setMaximumSize(new Dimension(100, 100));
		setBackground(Color.blue);
		addMouseListener(new MouseListening());
	}

	@Override
	public void paintComponent(Graphics g) {
		BufferedImage icon = null;
		try {
			icon = ImageIO.read(new File(currentImage));
		} catch (IOException e) {
			System.out.println("Unable to find " + this.name + " Image.");
			e.printStackTrace();
		}
		g.drawImage(icon, 0, 0, null);
	}

	class MouseListening implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				Desktop.getDesktop().open(new File(filePath));
			} catch (IOException e) {
				System.out.println("Poops");
				e.printStackTrace();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			System.out.println("HERE WE ARE");
			currentImage = imageSelectedPath;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			currentImage = imagePath;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
