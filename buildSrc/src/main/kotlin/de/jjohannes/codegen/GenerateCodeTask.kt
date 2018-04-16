package de.jjohannes.codegen

import de.jjohannes.codegen.gradle.BuildGradleGen
import de.jjohannes.codegen.java.AppJavaGen
import de.jjohannes.codegen.xml.ConfigXmlGen
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateCodeTask: DefaultTask() {

    private val generators = listOf(AppJavaGen, ConfigXmlGen, BuildGradleGen)

    @Input
    lateinit var conf: CodeGeneratorConfig

    @OutputDirectory
    lateinit var targetDir: File

    @TaskAction
    fun generate() {
        with(conf) {
            generators.forEach { generator ->
                with(File(targetDir, generator.fileName(conf))) {
                    parentFile.mkdirs()
                    writeText(generator.generateContent(conf).trimIndent())
                }
            }
        }
    }
}