package org.team2471.frc.pathvisualizer

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.math.roundToInt


object ControlPanel : VBox() {
    private val autoComboBox = ComboBox<String>()
    private val pathListView = ListView<String>()
    private val mirroredCheckBox = CheckBox("Mirrored")
    private val pathWeaverFormatCheckBox = CheckBox("PathWeaver")
    private val robotDirectionBox = ComboBox<String>()
    private val displayOnlySelectedPath = CheckBox("")
    private val xPosText = TextField()
    private val yPosText = TextField()
    private val angleText = TextField()
    private val magnitudeText = TextField()
    private val slopeModeCombo = ComboBox<String>()
    private val pathLengthText = TextField()
    private val currentTimeText = TextField()
    private val autosTitlePane = TitledPane()
    private val pathsTitlePane = TitledPane()
    private val pointsAndTangentsTitlePane = TitledPane()
    private val easeAndHeadingTitlePane = TitledPane()
    private val headingAngleText = TextField()
    private val easePositionText = TextField()
    private val fieldWidth = TextField()
    private val fieldHeight = TextField()
    private val fieldOverlayOpacitySlider = Slider(0.0, 1.0, 0.5)
    private val curveTypeCombo = ComboBox<String>()
    private val deletePointButton = Button()

    init {

        spacing = 10.0
        padding = Insets(10.0, 10.0, 10.0, 10.0)



        // autonomous management
        val autoComboHBox = HBox()
        autoComboHBox.spacing = 10.0
        autoComboBox.isEditable = false

        val newAutoButton = Button()
        newAutoButton.setOnAction {
        }

        val renameAutoButton = Button()
        renameAutoButton.setOnAction {
        }

        val deleteAutoButton = Button()
        deleteAutoButton.setOnAction {
        }

        val playAutoButton = Button()
        playAutoButton.setOnAction {
        }


        val spacerAutoDelete = Region()
        spacerAutoDelete.prefWidth = 35.0
        val autoButtonsHBox = HBox()
        autoButtonsHBox.spacing = 10.0
        autoButtonsHBox.children.addAll(
            newAutoButton,
            renameAutoButton,
            playAutoButton,
            spacerAutoDelete,
            deleteAutoButton
        )
        autoComboHBox.alignment = Pos.CENTER_LEFT
        autoComboHBox.children.addAll(autoComboBox, mirroredCheckBox, pathWeaverFormatCheckBox)
        val autosGridPane = GridPane()
        autosGridPane.vgap = 4.0
        autosGridPane.padding = Insets(5.0, 5.0, 5.0, 5.0)
        // row 1
        autosGridPane.add(autoComboHBox, 0, 0)
        // row 2
        autosGridPane.add(autoButtonsHBox, 0, 1)

        autosTitlePane.text = "Autos - "
        autosTitlePane.content = autosGridPane


        // paths management
        pathListView.prefHeight = 180.0

        val newPathButton = Button()
        newPathButton.setOnAction {
        }

        val deletePathButton = Button()
        deletePathButton.setOnAction {

        }
        val alignPathButton = Button()
        alignPathButton.setOnAction {
        }

        val renamePathButton = Button()
        renamePathButton.setOnAction {
        }

        val spacerPathDelete = Region()
        spacerPathDelete.prefWidth = 35.0

        val pathButtonsVBox = HBox()
        pathButtonsVBox.spacing = 10.0
        pathButtonsVBox.children.addAll(
            newPathButton,
            renamePathButton,
            spacerPathDelete,
            deletePathButton,
            alignPathButton
        )

        val pathLengthLabel = Text("Length:")
        val pathLengthUnits = Text("feet")
        pathLengthText.prefWidth = 60.0
        pathLengthText.isEditable = false
        pathLengthText.styleClass.add("textfield-readonly")

//        robotDirectionBox.value = selectedPath?.robotDirection?.name?.lowercase()?.capitalize() ?: Path2D.RobotDirection.BACKWARD.name.lowercase().capitalize()
        //if (FieldPane.selectedPath == null || FieldPane.selectedPath!!.robotDirection == Path2D.RobotDirection.FORWARD) "Forward" else "Backward"


        val displayOnlySelectedPathName = Text("Hide other paths")
        displayOnlySelectedPath.setOnAction {
//            draw()
        }


        // set up Paths GridPane

        val pathsGridPane = GridPane()
        pathsGridPane.vgap = 5.0
        pathsGridPane.padding = Insets(5.0, 5.0, 5.0, 5.0)
        pathsGridPane.hgap = 5.0
        pathsGridPane.isGridLinesVisible = false

        // row 1
        pathsGridPane.add(pathListView, 0, 0, 1, 6) // spans path data rows on right
        pathsGridPane.add(pathLengthLabel, 1, 0)
        pathsGridPane.add(pathLengthText, 2, 0)
        pathsGridPane.add(pathLengthUnits, 3, 0)

        // row 2


        // row 3


        // row 4
        pathsGridPane.add(robotDirectionBox, 2, 3)

        // row 5
        pathsGridPane.add(displayOnlySelectedPathName, 1, 4)
        pathsGridPane.add(displayOnlySelectedPath, 2, 4)



        pathsGridPane.add(pathButtonsVBox, 0, 7, 4, 1)
//        pathsTitlePane.text = "Paths - " + selectedPath?.name
        pathsTitlePane.content = pathsGridPane


        // Point Management


        val posLabelX = Text("Position x:")
        xPosText.prefWidth = 100.0

        val posLabelY = Text("      y:")
        yPosText.prefWidth = 100.0

        val posUnit = Text("feet")
        deletePointButton.setOnAction {
            val alert = Alert(Alert.AlertType.CONFIRMATION)
            alert.contentText = "Are you sure you want to delete this point?"
            alert.showAndWait()
        }


        val tangentHBox = HBox()
        tangentHBox.alignment = Pos.CENTER_LEFT
        val tangentLabel = Text("Tangent:")
        angleText.prefWidth = 100.0

        magnitudeText.prefWidth = 100.0

        val angleUnit = Text("deg")
        val magnitudeUnit = Text("magnitude")
        tangentHBox.children.addAll()

        val slopeComboLabel = Text("Slope:")
        slopeModeCombo.items.addAll("Smooth", "Manual", "None")


        val pointsAndTangentsGridPane = GridPane()
        val col0 = ColumnConstraints()
        col0.hgrow = Priority.SOMETIMES
        val col1 = ColumnConstraints()
        col1.hgrow = Priority.SOMETIMES
        val col2 = ColumnConstraints()
        col2.hgrow = Priority.SOMETIMES
        val col3 = ColumnConstraints()
        col3.hgrow = Priority.SOMETIMES
        val col4 = ColumnConstraints()
        col3.hgrow = Priority.SOMETIMES
        val rightCol = ColumnConstraints()
        rightCol.hgrow = Priority.ALWAYS
        rightCol.halignment = HPos.RIGHT
        pointsAndTangentsGridPane.columnConstraints.addAll(col0, col1, col2, col3, col4, rightCol)
        pointsAndTangentsGridPane.vgap = 5.0
        pointsAndTangentsGridPane.padding = Insets(5.0, 5.0, 5.0, 5.0)
        pointsAndTangentsGridPane.hgap = 5.0
        pointsAndTangentsGridPane.isGridLinesVisible = false

        // row 1
        pointsAndTangentsGridPane.add(posLabelX, 0, 0)
        pointsAndTangentsGridPane.add(xPosText, 1, 0)
        pointsAndTangentsGridPane.add(posLabelY, 2, 0)
        pointsAndTangentsGridPane.add(yPosText, 3, 0)
        pointsAndTangentsGridPane.add(posUnit, 4, 0)
        pointsAndTangentsGridPane.add(deletePointButton, 5, 0)
        // row 2
        pointsAndTangentsGridPane.add(tangentLabel, 0, 1)
        pointsAndTangentsGridPane.add(angleText, 1, 1)
        pointsAndTangentsGridPane.add(angleUnit, 2, 1)
        pointsAndTangentsGridPane.add(magnitudeText, 3, 1)
        pointsAndTangentsGridPane.add(magnitudeUnit, 4, 1)

        pointsAndTangentsGridPane.add(slopeComboLabel, 0, 2)
        pointsAndTangentsGridPane.add(slopeModeCombo, 1, 2)


        pointsAndTangentsTitlePane.text = "Selected Point / Tangent"
        pointsAndTangentsTitlePane.content = pointsAndTangentsGridPane
        pointsAndTangentsTitlePane.isExpanded = false


        // Ease and Headings

        val currentTimeName = Text("Time:")
        currentTimeText.prefWidth = 100.0


        val easeValue = Text("Ease:")
        val headingValue = Text("Heading:")

        easePositionText.prefWidth = 100.0


        headingAngleText.prefWidth = 100.0


        val curveTypeHBox = HBox()
        val curveTypeLabel = Text("Curve Type:  ")
        curveTypeCombo.items.addAll("Ease", "Heading", "Both")
        curveTypeCombo.value = "Both"
        curveTypeHBox.children.addAll(curveTypeLabel, curveTypeCombo)

        val easeAndHeadingsGridPane = GridPane()
        easeAndHeadingsGridPane.vgap = 5.0
        easeAndHeadingsGridPane.padding = Insets(5.0, 5.0, 5.0, 5.0)
        easeAndHeadingsGridPane.hgap = 5.0
        easeAndHeadingsGridPane.isGridLinesVisible = false

        // row 1
        easeAndHeadingsGridPane.add(currentTimeName, 1, 0)
        easeAndHeadingsGridPane.add(easeValue, 2, 0)
        easeAndHeadingsGridPane.add(headingValue, 3, 0)

        // row 2
        easeAndHeadingsGridPane.add(currentTimeText, 1, 1)
        easeAndHeadingsGridPane.add(easePositionText, 2, 1)
        easeAndHeadingsGridPane.add(headingAngleText, 3, 1)

        easeAndHeadingsGridPane.add(curveTypeLabel, 0, 2)
        easeAndHeadingsGridPane.add(curveTypeHBox, 1, 2)

        easeAndHeadingTitlePane.text = "Ease and Headings"
        easeAndHeadingTitlePane.content = easeAndHeadingsGridPane
        easeAndHeadingTitlePane.isExpanded = true


        // Robot Parameters



        val maxAccelerationUnitTextFlow = TextFlow()
        val maxAccelerationUnit = Text(" ft/s")
        val maxAccelerationUnitSuper = Text("2")
        maxAccelerationUnitSuper.translateY = maxAccelerationUnit.font.size * -0.3
        val smallerFontSize = (maxAccelerationUnit.font.size * 0.6).roundToInt()
        maxAccelerationUnitSuper.style = "-fx-font-size: $smallerFontSize;"
        maxAccelerationUnitTextFlow.children.addAll(maxAccelerationUnit, maxAccelerationUnitSuper)

        val fieldWidthName = Text("Field Width:  ")
        val fieldWidthDimens = Text(" feet")
        fieldWidth.prefWidth = 60.0


        val fieldHeightName = Text("Field Height:  ")
        val fieldHeightDimens = Text(" feet")
        fieldHeight.prefWidth = 60.0


        val fieldParamsTitledPane = TitledPane()
        val fieldParamsGridPane = GridPane()
        fieldParamsGridPane.vgap = 4.0
//        robotParamsGridPane.alignment = Pos.CENTER_LEFT
        fieldParamsGridPane.padding = Insets(5.0, 5.0, 5.0, 5.0)

        // row 1


        fieldParamsGridPane.add(fieldOverlayOpacitySlider, 2, 0)
        // row 1
        fieldParamsGridPane.add(fieldWidthName, 0, 1)
        fieldParamsGridPane.add(fieldWidth, 1, 1)
        fieldParamsGridPane.add(fieldWidthDimens, 2, 1)

        // row 2
        fieldParamsGridPane.add(fieldHeightName, 0, 2)
        fieldParamsGridPane.add(fieldHeight, 1, 2)
        fieldParamsGridPane.add(fieldHeightDimens, 2, 2)

        fieldParamsTitledPane.content = fieldParamsGridPane
        fieldParamsTitledPane.text = "Field  Parameters"
        fieldParamsTitledPane.isExpanded = false


        children.addAll(
            autosTitlePane,
            pathsTitlePane,
            easeAndHeadingTitlePane,
            pointsAndTangentsTitlePane,
            fieldParamsTitledPane
        )

    }
}