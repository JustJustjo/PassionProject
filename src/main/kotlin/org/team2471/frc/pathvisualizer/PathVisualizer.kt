package org.team2471.frc.pathvisualizer

import javafx.application.Application
import javafx.geometry.Rectangle2D
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.layout.BorderPane
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

        val hellobutton = Button()
        hellobutton.setOnAction {
            println("HELLO")
        }
        hellobutton.height + 10
        hellobutton.width + 10
        hellobutton.contentDisplay


        val borderPane = BorderPane()
        borderPane.top = TopBar
        borderPane.top = ControlPanel

        val screen = Screen.getPrimary()

        val bounds = Rectangle2D(screen.visualBounds.minX, screen.visualBounds.minY, screen.visualBounds.width, screen.visualBounds.height - 30)
        stage.scene = Scene(borderPane, bounds.width, bounds.height)
        stage.scene.stylesheets.add("assets/theme.css")
        stage.sizeToScene()
//        stage.isMaximized = true
        stage.show()
    }
}