package org.team2471.frc.pathvisualizer

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color



object ColorPanel : VBox(5.0) {
    init {
        println("ColorPanel says hi!")

        val buttonRed = Button("Red")
        buttonRed.style = "-fx-background-color: #ff0000"
        buttonRed.setMinSize(100.0, 100.0)
        buttonRed.setOnAction { changeSelectedColor(Color.RED) }

        val buttonOrange = Button("Orange")
        buttonOrange.style = "-fx-background-color: #FFA500"
        buttonOrange.setMinSize(100.0, 100.0)
        buttonOrange.setOnAction { changeSelectedColor(Color.ORANGE) }

        val buttonYellow = Button("Yellow")
        buttonYellow.style = "-fx-background-color: #FFFF00"
        buttonYellow.setMinSize(100.0, 100.0)
        buttonYellow.setOnAction { changeSelectedColor(Color.YELLOW) }

        val buttonGreen = Button("Green")
        buttonGreen.style = "-fx-background-color: #008000"
        buttonGreen.setMinSize(100.0, 100.0)
        buttonGreen.setOnAction { changeSelectedColor(Color.GREEN) }

        val buttonBlue = Button("Blue")
        buttonBlue.style = "-fx-background-color: #0000FF"
        buttonBlue.setMinSize(100.0, 100.0)
        buttonBlue.setOnAction { changeSelectedColor(Color.BLUE) }

        val buttonPurple = Button("Purple")
        buttonPurple.style = "-fx-background-color: #800080"
        buttonPurple.setMinSize(100.0, 100.0)
        buttonPurple.setOnAction { changeSelectedColor(Color.PURPLE) }

        val buttonBlack = Button("Black")
        buttonBlack.style = "-fx-background-color: #000000"
        buttonBlack.setMinSize(100.0, 100.0)
        buttonBlack.setOnAction { changeSelectedColor(Color.BLACK) }

        ColorPanel.children.addAll(buttonRed, buttonOrange, buttonYellow, buttonGreen, buttonBlue, buttonPurple, buttonBlack)
    }
    fun changeSelectedColor(e: Color) {
        PathVisualizer.SELECTED_COLOR = e
    }
}

/* TODO: color (dropdown), size (TextField), shape (dropdown) */