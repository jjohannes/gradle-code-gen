package de.jjohannes.codegen

import java.io.Serializable

data class CodeGeneratorConfig(
        val projectName: String,
        val projectPackage: String,
        val initialCycleCount: Int
) : Serializable