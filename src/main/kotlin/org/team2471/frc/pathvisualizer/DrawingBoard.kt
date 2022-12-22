package org.team2471.frc.pathvisualizer

import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color


object DrawingBoard : Group() {
    val canvas = Canvas(740.0, 740.0)
    val gc = canvas.graphicsContext2D

    init {
        gc.setFill(Color.LIGHTGRAY)
        gc.fillRect(0.0, 0.0, 740.0, 740.0)

        DrawingBoard.getChildren().add(canvas)


        canvas.setOnMousePressed {event -> click(event.x, event.y)}
    }
    fun click(x: Any?, y: Any?) {
        println("Click cords... x:$x  y:$y")
    }
}