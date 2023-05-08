import javax.swing.*;
import java.awt.*;

public class RectangleExample extends JFrame {
    public RectangleExample() {
        setTitle("Rectángulo de color");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Configurar color y tamaño del rectángulo
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 300, 200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RectangleExample example = new RectangleExample();
            example.setVisible(true);
        });
    }
}
