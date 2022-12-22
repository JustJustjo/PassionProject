package org.team2471.frc.pathvisualizer

import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color


object DrawingBoard : Group() {
    val canvas = Canvas(740.0, 740.0)
    val gc = canvas.graphicsContext2D

    init {
        println("DrawingBoard says hi!")
        gc.setFill(Color.LIGHTGRAY)
        gc.fillRect(0.0, 0.0, 740.0, 740.0)

        DrawingBoard.getChildren().add(canvas)


        canvas.setOnMousePressed {event -> click(event.x, event.y)}
    }
    fun click(x: Double, y: Double) {
//        println("Click cords... x:$x  y:$y")
        gc.setFill(PathVisualizer.SELECTED_COLOR)
        gc.fillRect(x - PathVisualizer.SELECTED_WIDTH/2, y- PathVisualizer.SELECTED_HEIGHT/2, PathVisualizer.SELECTED_WIDTH, PathVisualizer.SELECTED_HEIGHT)
        gc.fill
    }
}