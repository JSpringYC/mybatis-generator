package org.mybatis.generator.view

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Cursor
import javafx.scene.Parent
import javafx.scene.control.ContentDisplay
import javafx.scene.image.Image
import javafx.scene.layout.BorderPane
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints
import tornadofx.*

class MainView : View() {

    override val root: Parent = borderpane()

    init {
        title = messages["app.title"]
        primaryStage.icons.add(Image("images/logo.png"))

        with(root as BorderPane) {
            prefWidth = 918.0
            prefHeight = 613.0

            top {
                toolbar {
                    prefWidth = 918.0
                    prefHeight = 50.0
                    minHeight = 30.0

                    label {
                        id = "connectionLabel"
                        contentDisplay = ContentDisplay.TOP
                        text = messages["database.connection"]
                        cursor = Cursor.HAND
                        paddingLeft = 10
                        paddingRight = 10
                    }

                    label {
                        id = "configsLabel"
                        contentDisplay = ContentDisplay.TOP
                        text = messages["database.configuration"]
                        cursor = Cursor.HAND
                        insets(right = 10)
                    }
                }
            }

            center {
                splitpane(Orientation.HORIZONTAL) {
                    setDividerPositions(0.15)

                    anchorpane {
                        maxWidth = 500.0
                        minWidth = 100.0
                        prefWidth = 200.0
                        prefHeight = 618.0

                        treeview<String> {
                            id = "leftDBTree"
                            layoutX = -14.0
                            maxWidth = 134.0
                            prefHeight = 503.0
                            prefWidth = 134.0
                            anchorpaneConstraints {
                                bottomAnchor = 27.0
                                leftAnchor = 0.0
                                rightAnchor = 0.0
                                topAnchor = 0.0
                            }
                        }

                        textfield {
                            id = "filterTreeBox"
                            layoutY = 504.0
                            prefHeight = 26.0
                            prefWidth = 134.0
                            promptText = messages["search"]
                            anchorpaneConstraints {
                                bottomAnchor = 0.0
                                leftAnchor = 0.0
                                rightAnchor = 0.0
                            }
                        }
                    }

                    anchorpane {
                        minWidth = 400.0

                        vbox {
                            anchorpaneConstraints {
                                bottomAnchor = 0.0
                                leftAnchor = 0.0
                                rightAnchor = 0.0
                                topAnchor = 0.0
                            }

                            gridpane {
                                alignment = Pos.TOP_RIGHT
                                layoutX = 5.0
                                layoutY = 29.0
                                prefHeight = 505.0
                                prefWidth = 766.0
                                anchorpaneConstraints {
                                    topAnchor = 0.0
                                }
                                columnConstraints.add(ColumnConstraints(132.0, 138.0, 157.0,
                                    Priority.SOMETIMES, HPos.RIGHT, false))
                                columnConstraints.add(ColumnConstraints(10.0, 222.0, 688.0,
                                    Priority.SOMETIMES, HPos.RIGHT, false))
                                columnConstraints.add(ColumnConstraints(69.0, 76.0, 688.0,
                                    Priority.SOMETIMES, HPos.RIGHT, false))
                                columnConstraints.add(ColumnConstraints(10.0, 108.0, 688.0,
                                    Priority.SOMETIMES, HPos.RIGHT, false))
                                columnConstraints.add(ColumnConstraints(10.0, 129.0, 688.0,
                                    Priority.SOMETIMES, HPos.RIGHT, false))
                                columnConstraints.add(ColumnConstraints(10.0, 95.0, 688.0,
                                    Priority.SOMETIMES, HPos.RIGHT, false))
                                rowConstraints.add(RowConstraints(10.0, 30.0, 30.0))

                                row {
                                    label(messages["table.name"])
                                    textfield {
                                        id = "tableNameField"
                                        isDisable = true
                                        isEditable = false
                                        prefHeight = 27.0
                                        prefWidth = 156.0
                                        promptText = "person"
                                        gridpaneConstraints {
                                            columnIndex = 1
                                            marginLeft = 5.0
                                            marginRight = 5.0
                                        }
                                    }
                                }
                                row {
                                    label(messages["domain.name"])
                                    hbox {
                                        alignment = Pos.CENTER_LEFT
                                        gridpaneConstraints {
                                            columnIndex = 1
                                            columnSpan = 3
                                            rowIndex = 1
                                            vAlignment = VPos.CENTER
                                        }
                                        textfield {
                                            id = "domainNameField"
                                            prefHeight = 27.0
                                            prefWidth = 154.0
                                            promptText = "Person"
                                            gridpaneConstraints {
                                                columnIndex = 1
                                                rowIndex = 2
                                                marginLeft = 5.0
                                                marginRight = 5.0
                                            }
                                            hboxConstraints {
                                                marginRight = 5.0
                                            }
                                        }
                                        button {
                                            isMnemonicParsing = false
                                            text = "定制列"
                                        }
                                        hboxConstraints {
                                            marginLeft = 5.0
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}