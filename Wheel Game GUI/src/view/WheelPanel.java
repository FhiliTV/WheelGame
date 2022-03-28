package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.wheel.Slot;
import model.wheel.Wheel;

@SuppressWarnings("serial")
public class WheelPanel extends JPanel {

	private Image wheelImage;
	private JLabel slotLabel;
	private int slotPosition;
	private String currentSlot = "";

	public WheelPanel() {

		setLayout(new BorderLayout());
		ImageIcon wheel = new ImageIcon("image/Wheel.png");
		wheelImage = wheel.getImage();
		slotLabel = new JLabel();
		add(slotLabel, BorderLayout.SOUTH);
		
	}

	public void circlePosition(Slot slot) {
		currentSlot = String.format("Current Slot Position: %s | Slot  Color: %s | Slot Number: %s", slot.getPosition(), slot.getColor(), slot.getNumber());
		slotLabel.setText(currentSlot);
		slotPosition = slot.getPosition();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
		final int currentSlot = slotPosition;
		int reSize;
		int wp = this.getWidth();
		int hp = this.getHeight();

		if (wp < hp) {
			reSize = wp;
		} else {
			reSize = hp;
		}
		reSize = reSize - 30;
		int startX = (wp / 2) - (reSize / 2);
		int startY = (hp / 2) - (reSize / 2);
		g.drawImage(wheelImage, startX, startY, reSize, reSize, null);

		double degrees = (360.0 / (double) Wheel.NUMBER_OF_SLOTS) * currentSlot - 90;
		double equationX = (wp / 2) + ((reSize * 0.93) / 2) * Math.cos(Math.toRadians(degrees));
		double equationY = (hp / 2) + ((reSize * 0.93) / 2) * Math.sin(Math.toRadians(degrees));
		g.setColor(Color.BLUE);
		int circleResize = (int) (reSize * 0.09);
		g2d.setStroke(new BasicStroke(4));
		g.drawOval((int) equationX - (circleResize / 2), (int) equationY - (circleResize / 2), circleResize,
				circleResize);

	}

}
