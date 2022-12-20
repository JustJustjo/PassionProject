package org.team2471.frc.pathvisualizer

import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color


object FieldPane : Group() {
    init {

        val canvas = Canvas(740.0,740.0)
        val gc = canvas.graphicsContext2D
        gc.setFill(Color.LIGHTGRAY)
//        gc.fillOval(0.0, 0.0, 740.0, 740.0)
        gc.fillRect(0.0,0.0,740.0,740.0)

        FieldPane.getChildren().add(canvas)
    }

}