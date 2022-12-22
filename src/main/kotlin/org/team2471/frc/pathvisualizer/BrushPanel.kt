package org.team2471.frc.pathvisualizer

import javafx.scene.canvas.Canvas
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.layout.VBox
import javafx.scene.paint.Color


object BrushPanel: VBox(5.0) {
    val buttonCir = Button("Circle")
    val buttonRec = Button("Rectangle")
    val buttonCle = Button("Clear Drawing")
    val hSlider = Slider(5.0, 300.0, 5.0)
    val wSlider = Slider(5.0, 300.0, 5.0)
    val hLabel = Label("Height")
    val wLabel = Label("Width")
    val canvas = Canvas(300.0, 300.0)
    val gc = canvas.graphicsContext2D

    init{
        println("BrushPanel says hi!")

        gc.setFill(Color.LIGHTGRAY)
        gc.fillRect(0.0, 0.0, 300.0, 300.0)

        buttonRec.setMinSize(100.0, 100.0)
        buttonRec.style = "-fx-background-color: #000000"
        buttonRec.setOnAction {
            changeSelectedShape("Rectangle")
            buttonRec.style = "-fx-background-color: ${PathVisualizer.BUTTON_COLOR}"
            buttonCir.style = "-fx-background-color: #D3D3D3"
            updatePreview()
        }
        buttonCir.setMinSize(100.0, 100.0)
        buttonCir.setOnAction {
            changeSelectedShape("Oval")
            buttonCir.style = "-fx-background-color: ${PathVisualizer.BUTTON_COLOR}"
            buttonRec.style = "-fx-background-color: #D3D3D3"
            updatePreview()
        }
        buttonCle.setMinSize(100.0, 100.0)
        buttonCle.setOnAction {
            DrawingBoard.clear()
        }

        hSlider.setOnMouseReleased { PathVisualizer.SELECTED_HEIGHT = hSlider.value; updatePreview() }
        wSlider.setOnMouseReleased { PathVisualizer.SELECTED_WIDTH = wSlider.value; updatePreview() }

        BrushPanel.children.addAll(buttonRec, buttonCir, hLabel, hSlider, wLabel, wSlider, canvas, buttonCle)
        updatePreview()
    }
    fun changeSelectedShape(s: String) {
        PathVisualizer.SELECTED_SHAPE = s
    }
    fun updatePreview() {
        gc.setFill(Color.LIGHTGRAY)
        gc.fillRect(0.0, 0.0, 999.9, 999.9)
        gc.setFill(PathVisualizer.SELECTED_COLOR)
        if (PathVisualizer.SELECTED_SHAPE == "Rectangle") {
            gc.fillRect(150.0 - PathVisualizer.SELECTED_WIDTH/2, 150.0- PathVisualizer.SELECTED_HEIGHT/2, PathVisualizer.SELECTED_WIDTH, PathVisualizer.SELECTED_HEIGHT)
        }
        if (PathVisualizer.SELECTED_SHAPE == "Oval") {
            gc.fillOval(150.0 - PathVisualizer.SELECTED_WIDTH/2, 150.0- PathVisualizer.SELECTED_HEIGHT/2, PathVisualizer.SELECTED_WIDTH, PathVisualizer.SELECTED_HEIGHT)
        }
    }
}