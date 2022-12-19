package org.team2471.frc.pathvisualizer

import javafx.scene.input.*
import javafx.scene.layout.StackPane
import javafx.scene.shape.Circle

object FieldPane : StackPane() {

    val circle = Circle(300.0, 135.0, 100.0)

    circle


    private fun onMouseClick(e: MouseEvent) {
        println("Mouse moved event")
    }

}