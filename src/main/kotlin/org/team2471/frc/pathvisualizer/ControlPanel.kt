package org.team2471.frc.pathvisualizer

import javafx.scene.control.*


object ControlPanel : Button() {
    init {
        println("ControlPanel says hi!")

        val buttonOne = Button("one")
        buttonOne.setOnAction {
            println("one")
        }

        val buttonTwo = Button("two")
        buttonTwo.setOnAction {
            println("two")
        }

        val buttonThree = Button("three")
        buttonThree.setOnAction {
            println("three")
        }
    }
}