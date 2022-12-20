package org.team2471.frc.pathvisualizer

import javafx.scene.control.*


object ControlPanel : ButtonBar() {
    init {
        println("ControlPanel says hi!")

        val buttonOne = Button("one")
        buttonOne.setOnAction {
            println(FieldPane)
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

        ControlPanel.buttons.addAll(buttonOne, buttonTwo, buttonThree, buttonFour)
    }
}