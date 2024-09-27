package org.example

import java.io.BufferedReader
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path


fun main() {

    val gestorFich = GestorFich()
    val file = File("ficheros/cotizacion.csv")
    val fileEnd = File("ficheros/cotizacion2.csv")
    val diccionario = gestorFich.fichReader(file)

    gestorFich.fichWriter(diccionario, fileEnd)


}