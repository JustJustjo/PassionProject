package org.team2471.frc.pathvisualizer

import javafx.scene.input.*
import javafx.scene.layout.StackPane

object FieldPane : StackPane() {


    private fun onMouseMoved(e: MouseEvent) {
        println("Mouse moved event")
    }

    private fun onMouseExited(e: MouseEvent) {
        println("Mouse exited event")
    }
}