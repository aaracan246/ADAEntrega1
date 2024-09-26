package org.example

import java.io.BufferedReader
import java.io.File
import java.nio.file.Path
import kotlin.io.path.Path


fun main() {

    val gestorFich = GestorFich()
    val file = File("C:\\Users\\UsuarioT\\PROG\\ADA\\ADAEntrega1\\src\\main\\resources\\cotizacion.csv")
    val fileEnd = File("C:\\Users\\UsuarioT\\PROG\\ADA\\ADAEntrega1\\src\\main\\resources\\cotizacionResults.csv")
    val diccionario = gestorFich.fichReader(file)

    gestorFich.fichWriter(diccionario, fileEnd)


}