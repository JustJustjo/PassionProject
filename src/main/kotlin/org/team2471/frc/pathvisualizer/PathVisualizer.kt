package org.team2471.frc.pathvisualizer

import javafx.application.Application
import javafx.application.Platform
import javafx.geometry.Orientation
import javafx.geometry.Rectangle2D
import javafx.scene.Scene
import javafx.scene.control.ScrollPane
import javafx.scene.control.SplitPane
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import javafx.stage.Screen
import javafx.stage.Stage

class PathVisualizer : Application() {

    companion object {
        // drawing
        lateinit var stage: Stage
        var windowResizing = false
        val verticalSplitPane = SplitPane()
        @JvmStatic
        fun main(args: Array<String>) {
            launch(PathVisualizer::class.java, *args)
        }
    }


    override fun start(stage: Stage) {
        stage.title = "Path Visualizer"
        PathVisualizer.stage = stage

        verticalSplitPane.items.addAll(FieldPane)
        verticalSplitPane.orientation = Orientation.VERTICAL
        verticalSplitPane.setDividerPositions(0.85)

        val pathScrollPane = ScrollPane(ControlPanel)
        pathScrollPane.hbarPolicy = ScrollPane.ScrollBarPolicy.AS_NEEDED
        pathScrollPane.vbarPolicy = ScrollPane.ScrollBarPolicy.AS_NEEDED


        val tabPane = TabPane()
        val tabScroll = Tab("Path Editing")
        tabScroll.content = pathScrollPane
        tabScroll.isClosable = false


//        tabPane.tabs.addAll(tabScroll)


        val horizontalSplitPane = SplitPane(verticalSplitPane, tabPane)

        val borderPane = BorderPane(horizontalSplitPane)
        borderPane.top = TopBar

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