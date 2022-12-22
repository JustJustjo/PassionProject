package org.team2471.frc.pathvisualizer

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.control.ChoiceBox
class BrushPanel: VBox() {
    val colorSelector = ChoiceBox<String>()
    init{
        println("BrushPanel says hi!")

        colorSelector.items.addAll("Rectangle", "Oval", "Polygon", "Arc")
        colorSelector.setOnAction {
            if (colorSelector.value == "Rectangle") {}
        }
    }

}