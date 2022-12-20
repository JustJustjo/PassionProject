package org.team2471.frc.pathvisualizer

import javafx.application.Application
import javafx.geometry.Rectangle2D
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color
import javafx.stage.Screen
import javafx.stage.Stage

class PathVisualizer : Application() {

    companion object {
        // drawing
        lateinit var stage: Stage
        @JvmStatic
        fun main(args: Array<String>) {
            launch(PathVisualizer::class.java, *args)
        }
    }


    override fun start(stage: Stage) {
        stage.title = "Path Visualizer"
        PathVisualizer.stage = stage


        val screen = Screen.getPrimary()

        val borderPane = BorderPane(FieldPane)
        borderPane.top = TopBar
        borderPane.top = ControlPanel


        val bounds = Rectangle2D(screen.visualBounds.minX, screen.visualBounds.minY, screen.visualBounds.width, screen.visualBounds.height - 30)
        stage.scene = Scene(borderPane, bounds.width, bounds.height)
        stage.sizeToScene()
        stage.show()
    }
}