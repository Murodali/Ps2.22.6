package ps2_22_9;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

import java.security.SecureRandom;

public class Controller_22_9 {
    @FXML Pane pane;
    private SecureRandom random = new SecureRandom();
    private int n;
    private int[] dx;
    private int[] dy;
    public void initialize() {
        n = random.nextInt(50) + 10;
        dx = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            Ellipse ellipse = new Ellipse();
            ellipse.setCenterX(random.nextInt(500) + 201);
            ellipse.setCenterY(random.nextInt(300) + 201);
            ellipse.setRadiusX(random.nextInt(50));
            ellipse.setRadiusX(random.nextInt(100));
            ellipse.setFill(randomColor());
            ellipse.setStrokeWidth(random.nextInt(20));
            ellipse.setStroke(randomColor());
            pane.getChildren().add(ellipse);
            dx[i] = 1 + random.nextInt(5);
            dy[i] = 1 + random.nextInt(5);
            int temp = i;
            Timeline timelineAnimation = new Timeline(
                    new KeyFrame(Duration.millis(10), e -> moveCircles(ellipse, temp))
            );
            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
            timelineAnimation.play();
        }
    }
    private void moveCircles(Ellipse c, int i) {
        c.setCenterX(c.getCenterX() + dx[i]);
        c.setCenterY(c.getCenterY() + dy[i]);
        if (c.getCenterX() + c.getRadiusX() > pane.getWidth() || c.getCenterX() - c.getRadiusX() < 0) dx[i] = -dx[i];
        if (c.getCenterY() + c.getRadiusY() > pane.getHeight() || c.getCenterY() - c.getRadiusY() < 0) dy[i] = -dy[i];
    }
    private Color randomColor(){
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                (double) random.nextInt(101) / 100);
    }
}
