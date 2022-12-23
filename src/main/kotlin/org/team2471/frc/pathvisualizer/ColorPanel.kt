package org.team2471.frc.pathvisualizer

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color


object ColorPanel : VBox(2.5) {
    val buttonRed = Button("Red")
    val buttonOrange = Button("Orange")
    val buttonYellow = Button("Yellow")
    val buttonGreen = Button("Green")
    val buttonBlue = Button("Blue")
    val buttonPurple = Button("Purple")
    val buttonBlack = Button("Black")
    val buttonGray = Button("Gray")
    init {
        println("ColorPanel says hi!")

        buttonRed.style = "-fx-background-color: #ff0000"
        buttonRed.setMinSize(100.0, 94.0)
        buttonRed.setOnAction {
            changeSelectedColor(Color.RED)
            changeButtonColor(Color.RED)
            BrushPanel.updatePreview()
        }
        buttonOrange.style = "-fx-background-color: #FFA500"
        buttonOrange.setMinSize(100.0, 94.0)
        buttonOrange.setOnAction {
            changeSelectedColor(Color.ORANGE)
            changeButtonColor(Color.ORANGE)
            BrushPanel.updatePreview()
        }
        buttonYellow.style = "-fx-background-color: #FFFF00"
        buttonYellow.setMinSize(100.0, 94.0)
        buttonYellow.setOnAction {
            changeSelectedColor(Color.YELLOW)
            changeButtonColor(Color.YELLOW)
            BrushPanel.updatePreview()
        }
        buttonGreen.style = "-fx-background-color: #008000"
        buttonGreen.setMinSize(100.0, 94.0)
        buttonGreen.setOnAction {
            changeSelectedColor(Color.GREEN)
            changeButtonColor(Color.GREEN)
            BrushPanel.updatePreview()
        }
        buttonBlue.style = "-fx-background-color: #0000FF"
        buttonBlue.setMinSize(100.0, 94.0)
        buttonBlue.setOnAction {
            changeSelectedColor(Color.BLUE)
            changeButtonColor(Color.BLUE)
            BrushPanel.updatePreview()
        }
        buttonPurple.style = "-fx-background-color: #800080"
        buttonPurple.setMinSize(100.0, 94.0)
        buttonPurple.setOnAction {
            changeSelectedColor(Color.PURPLE)
            changeButtonColor(Color.PURPLE)
            BrushPanel.updatePreview()
        }
        buttonBlack.style = "-fx-background-color: #000000"
        buttonBlack.setMinSize(100.0, 94.0)
        buttonBlack.setOnAction {
            changeSelectedColor(Color.BLACK)
            changeButtonColor(Color.BLACK)
            BrushPanel.updatePreview()
        }
        buttonGray.style = "-fx-background-color: #D3D3D3"
        buttonGray.setMinSize(100.0, 94.0)
        buttonGray.setOnAction {
            changeSelectedColor(Color.LIGHTGRAY)
            changeButtonColor(Color.LIGHTGRAY)
            BrushPanel.updatePreview()
        }

        ColorPanel.children.addAll(buttonRed, buttonOrange, buttonYellow, buttonGreen, buttonBlue, buttonPurple, buttonBlack, buttonGray)
    }
    fun changeSelectedColor(e: Color) {
        PathVisualizer.SELECTED_COLOR = e
    }
    fun changeButtonColor(e: Color) {
        if (e == Color.RED) { PathVisualizer.BUTTON_COLOR = "#FF0000"}
        if (e == Color.ORANGE) { PathVisualizer.BUTTON_COLOR = "#FFA500"}
        if (e == Color.YELLOW) { PathVisualizer.BUTTON_COLOR = "#FFFF00"}
        if (e == Color.GREEN) { PathVisualizer.BUTTON_COLOR = "#008000"}
        if (e == Color.BLUE) { PathVisualizer.BUTTON_COLOR = "#0000FF"}
        if (e == Color.PURPLE) { PathVisualizer.BUTTON_COLOR = "#800080"}
        if (e == Color.BLACK) { PathVisualizer.BUTTON_COLOR = "#000000"}
        if (e == Color.LIGHTGRAY) { PathVisualizer.BUTTON_COLOR = "#D3D3D3"}
        if (PathVisualizer.SELECTED_SHAPE == "Rectangle") { BrushPanel.buttonRec.style = "-fx-background-color: ${PathVisualizer.BUTTON_COLOR}"}
        if (PathVisualizer.SELECTED_SHAPE == "Oval") { BrushPanel.buttonCir.style = "-fx-background-color: ${PathVisualizer.BUTTON_COLOR}"}
    }
}