package org.example

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class GestorFich {

    fun fichReader(file: File){
        val diccionarioDatos = mutableMapOf(
            "Nombre" to mutableListOf<Any>(),
            "Final" to mutableListOf<Any>(),
            "Máximo" to mutableListOf<Any>(),
            "Mínimo" to mutableListOf<Any>(),
            "Volumen" to mutableListOf<Any>(),
            "Efectivo" to mutableListOf<Any>())

        if (file.exists()){

            val br = BufferedReader(FileReader(file))
            val brSplitted = br.readLine().split(";")
            println(brSplitted)
            println("______")
            br.forEachLine { linea ->
                val valor = linea.split(";")

                diccionarioDatos["Nombre"]?.add(valor[0])
                diccionarioDatos["Final"]?.add(valor[1])
                diccionarioDatos["Máximo"]?.add(valor[2])
                diccionarioDatos["Mínimo"]?.add(valor[3])
                diccionarioDatos["Volumen"]?.add(valor[4])
                diccionarioDatos["Efectivo"]?.add(valor[5])
            }
            br.close()

            println(diccionarioDatos)




        }
        else {
            println("File not found.")
        }
    }



}