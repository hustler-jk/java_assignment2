import java.awt.*;
import java.awt.event.*;

// AWT Drawing Application
public class DrawingApplication extends Frame implements ActionListener, MouseListener {

    private String shape = "Circle";
    private Color currentColor = Color.RED;
    private int mouseX = 100;
    private int mouseY = 100;

    Button circleButton, rectangleButton, blueButton, redButton, greenButton;

    public DrawingApplication() {
        setTitle("Java AWT Drawing Application");
        setSize(600, 500);
        setLayout(new FlowLayout());

        circleButton = new Button("Draw Circle");
        rectangleButton = new Button("Draw Rectangle");
        redButton = new Button("Red");
        blueButton = new Button("Blue");
        greenButton = new Button("Green");

        add(circleButton);
        add(rectangleButton);
        add(redButton);
        add(blueButton);
        add(greenButton);

        circleButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);

        addMouseListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == circleButton) {
            shape = "Circle";
        } else if (e.getSource() == rectangleButton) {
            shape = "Rectangle";
        } else if (e.getSource() == redButton) {
            currentColor = Color.RED;
        } else if (e.getSource() == blueButton) {
            currentColor = Color.BLUE;
        } else if (e.getSource() == greenButton) {
            currentColor = Color.GREEN;
        }

        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(currentColor);
        g.setFont(new Font("Arial", Font.BOLD, 18));

        g.drawString("Click anywhere to draw the selected shape", 120, 100);
        g.drawString("Selected Shape: " + shape, 200, 130);

        if (shape.equals("Circle")) {
            g.fillOval(mouseX, mouseY, 100, 100);
        } else if (shape.equals("Rectangle")) {
            g.fillRect(mouseX, mouseY, 140, 90);
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new DrawingApplication();
    }
}