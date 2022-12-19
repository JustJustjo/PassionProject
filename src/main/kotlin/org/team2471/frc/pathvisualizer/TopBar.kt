package org.team2471.frc.pathvisualizer

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.input.KeyCombination


object TopBar : MenuBar() {
    init {
        val menuFile = Menu("File")

        val openMenuItem = MenuItem("Open...")
        openMenuItem.accelerator = KeyCombination.keyCombination("Ctrl + O")
        openMenuItem.setOnAction {
            println("Open...")
        }
        val saveAsMenuItem = MenuItem("Save As...")
        saveAsMenuItem.accelerator = KeyCombination.keyCombination("Ctrl + Shift + S")
        saveAsMenuItem.setOnAction {
            println("Save As...")
        }
        val saveMenuItem = MenuItem("Save")
        saveMenuItem.accelerator = KeyCombination.keyCombination("Ctrl + S")
        saveMenuItem.setOnAction {
            println("Save...")
        }

        menuFile.items.addAll(openMenuItem, saveAsMenuItem, saveMenuItem)

        menus.addAll(menuFile)
    }
}