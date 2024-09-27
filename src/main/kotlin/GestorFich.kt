package org.example

import java.io.*

class GestorFich {

    fun fichReader(file: File): MutableMap<String, MutableList<Any>>? {
        val diccionarioDatos = mutableMapOf(
            "Nombre" to mutableListOf<Any>(),
            "Final" to mutableListOf<Any>(),
            "Máximo" to mutableListOf<Any>(),
            "Mínimo" to mutableListOf<Any>(),
            "Volumen" to mutableListOf<Any>(),
            "Efectivo" to mutableListOf<Any>())


        // Comprobamos si existe el archivo, de no existir lo creamos:
        if (file.exists()){

            val br = BufferedReader(FileReader(file))
            val brSplitted = br.readLine().split(";")
            println(brSplitted)
            println("______")
            br.forEachLine { linea ->
                val valor = linea.split(";")

                diccionarioDatos["Nombre"]?.add(valor[0])
                diccionarioDatos["Final"]?.add(valor[1].replace(",", ".").toDoubleOrNull() ?: 0.0)
                diccionarioDatos["Máximo"]?.add(valor[2].replace(",", ".").toDoubleOrNull() ?: 0.0)
                diccionarioDatos["Mínimo"]?.add(valor[3].replace(",", ".").toDoubleOrNull() ?: 0.0)
                diccionarioDatos["Volumen"]?.add(valor[4].replace(",", ".").toDoubleOrNull() ?: 0.0)
                diccionarioDatos["Efectivo"]?.add(valor[5].replace(",", ".").toDoubleOrNull() ?: 0.0)
            }
            br.close()

            return diccionarioDatos

        }
        else {
            println("File not found.")
            return null
        }
    }


    // Creamos una función para calcular los distintos requisitos:
    private fun calcularStats(column: MutableList<Any>?): Triple<Double?, Double?, Double?>{
        val nums = column?.filterIsInstance<Double>() // filterIsInstance<R>()  <-- devuelve una lista conteniendo todos los elementos de un tipo concreto dentro de un contenedor
        val min = nums?.minOrNull()
        val max = nums?.maxOrNull()
        val avg = nums?.average()

        return Triple(min, max, avg)
    }

    // Creamos una función para escribir en el fichero nuevo utilizando la funcion anterior para colocar los datos:
    fun fichWriter(diccionario: MutableMap<String, MutableList<Any>>?, file: File) {
        if (diccionario == null) {
            return
        }

        BufferedWriter(FileWriter(file)).use { bw ->

            if (!file.exists()) {
                println("File not found. Making a new one. . .")
                file.createNewFile()

                bw.write("Final; Mínimo; Máximo; Media\n")
            }


            val columns = listOf("Final", "Mínimo", "Máximo", "Efectivo")
                for (column in columns){
                    val (min, max, avg) = calcularStats(diccionario[column] ?: mutableListOf())
                    val line = buildString {
                        append(column)
                        append(";")
                        append(min?.toString() ?: "")
                        append(";")
                        append(max?.toString() ?: "")
                        append(";")
                        append(avg?.toString() ?: "")
                        append("\n")
                    }
                    bw.write(line)
                }
            }
        }
    }
