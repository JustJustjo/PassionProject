package org.team2471.frc.pathvisualizer

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.control.ChoiceBox
import javafx.scene.paint.Color



object ControlPanel : HBox(5.0) {
    val colorSelector = ChoiceBox<String>()
    init {
        println("ControlPanel says hi!")


        colorSelector.items.addAll("RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "BLACK")
        colorSelector.setOnAction {
            if (colorSelector.value == "RED") { changeSelectedColor(Color.RED)}
            if (colorSelector.value == "ORANGE") { changeSelectedColor(Color.ORANGE)}
            if (colorSelector.value == "YELLOW") { changeSelectedColor(Color.YELLOW)}
            if (colorSelector.value == "GREEN") { changeSelectedColor(Color.GREEN)}
            if (colorSelector.value == "BLUE") { changeSelectedColor(Color.BLUE)}
            if (colorSelector.value == "PURPLE") { changeSelectedColor(Color.PURPLE)}
            if (colorSelector.value == "BLACK") { changeSelectedColor(Color.BLACK)}
        }

        val buttonTwo = Button("two")
        buttonTwo.setOnAction {
            println("two")
        }

        val buttonThree = Button("three")
        buttonThree.setOnAction {
            println("three")
        }

        val buttonFour = Button("four")
        buttonFour.setOnAction {
            println("four")
        }
        ControlPanel.children.addAll(colorSelector, buttonTwo, buttonThree, buttonFour)

//        ControlPanel.buttons.addAll(buttonOne, buttonTwo, buttonThree, buttonFour)
    }
    fun changeSelectedColor(e: Color) {
        PathVisualizer.SELECTED_COLOR = e
    }
}

/* TODO: color (dropdown), size (TextField), shape (dropdown) */