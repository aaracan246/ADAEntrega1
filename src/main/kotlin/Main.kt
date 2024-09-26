package org.example

import java.io.BufferedReader
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path


fun main() {

    val gestorFich = GestorFich()
    val file = File("D:\\Repositorio\\ADAT01-01\\ficheros\\cotizacion.csv")

    gestorFich.fichReader(file)


}