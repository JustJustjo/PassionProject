package org.team2471.frc.pathvisualizer

import javafx.application.Application
import javafx.application.Platform
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
        var windowResizing = false
        val buttonBar = ButtonBar()
        @JvmStatic
        fun main(args: Array<String>) {
            launch(PathVisualizer::class.java, *args)
        }
    }


    override fun start(stage: Stage) {
        stage.title = "Path Visualizer"
        PathVisualizer.stage = stage

//        verticalSplitPane.items.addAll(FieldPane)
//        verticalSplitPane.orientation = Orientation.VERTICAL
//        verticalSplitPane.setDividerPositions(0.85)

//        val toolBar = ToolBar(ControlPanel)





//        val horizontalSplitPane = SplitPane(toolBar)


//        buttonOne.setOnAction {
//            println("one")
//        }
        val buttonBar = ButtonBar()
        val buttonOne = Button("one")
        buttonOne.setOnAction {
            println("Button ONE!!")
        }
        buttonBar.buttons.addAll(buttonOne)



        val borderPane = BorderPane()
        borderPane.top = TopBar
        borderPane.center = buttonBar

        val screen = Screen.getPrimary()

        val bounds = Rectangle2D(screen.visualBounds.minX, screen.visualBounds.minY, screen.visualBounds.width, screen.visualBounds.height - 30)
        stage.scene = Scene(borderPane, bounds.width, bounds.height)
        stage.scene.stylesheets.add("assets/theme.css")
        stage.scene.addPreLayoutPulseListener {
            windowResizing = true
            Platform.runLater {
                windowResizing = false
            }
        }
        stage.sizeToScene()
        stage.isMaximized = true
        stage.show()
    }
}