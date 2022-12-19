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
import javafx.scene.input.DragEvent
import javafx.scene.input.KeyEvent
import javafx.scene.layout.BorderPane
import javafx.scene.text.Font
import javafx.stage.Screen
import javafx.stage.Stage
import java.util.prefs.Preferences

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

    enum class MouseMode {
        EDIT, PAN, ADD, DRAG_TIME
    }

    override fun start(stage: Stage) {
        stage.title = "Path Visualizer"
        PathVisualizer.stage = stage

        // setup the layout
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


        tabPane.tabs.addAll(tabScroll)


        val horizontalSplitPane = SplitPane(verticalSplitPane, tabPane)
        horizontalSplitPane.dividers[0].positionProperty().addListener {  _, oldPos, newPos -> dividerResized(oldPos, newPos) }

        val borderPane = BorderPane(horizontalSplitPane)
        borderPane.top = TopBar

        val screen = Screen.getPrimary()

        //There is a bug where the default height of the stage leaks under the tool bar in windows 10
        val bounds = Rectangle2D(screen.visualBounds.minX, screen.visualBounds.minY, screen.visualBounds.width, screen.visualBounds.height - 30)
        stage.scene = Scene(borderPane, bounds.width, bounds.height)
        stage.scene.stylesheets.add("assets/theme.css");
        stage.scene.addPreLayoutPulseListener {
            windowResizing = true
            Platform.runLater {
                windowResizing = false
            }
        }
//        FieldPane.draw()
        stage.sizeToScene()
        stage.isMaximized = true
        stage.show()
        ControlPanel.refresh()
//        LivePanel.refresh()
//        FieldPane.zoomFit()
    }
    private fun dividerResized(
        oldPos: Number,
        newPos: Number
    ) {
        if (windowResizing) {
            return
        }
    }
    private fun horizontalSplitDone(dragEvent: DragEvent?) {
        println("drag is done")
        println(dragEvent?.sceneX)
    }

}