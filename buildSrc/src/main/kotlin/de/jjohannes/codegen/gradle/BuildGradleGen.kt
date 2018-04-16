package de.jjohannes.codegen.gradle

import de.jjohannes.codegen.CodeGenerator
import de.jjohannes.codegen.CodeGeneratorConfig

object BuildGradleGen : CodeGenerator {

    override fun fileName(conf: CodeGeneratorConfig) = with(conf) {
        "build.gradle.kts"
    }

    override fun generateContent(conf: CodeGeneratorConfig) = with(conf) {
        """
            plugins {
                application
            }

            repositories {
                jcenter()
            }

            dependencies {
                implementation("org.jdom:jdom2:2.0.6")
            }

            application {
                mainClassName = "$projectPackage.${projectName}App"
            }
        """
    }
}