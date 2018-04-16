import de.jjohannes.codegen.CodeGeneratorConfig
import de.jjohannes.codegen.GenerateCodeTask

task<GenerateCodeTask>("generateCode") {
    conf = CodeGeneratorConfig(
            projectName = "FunThings",
            projectPackage = "org.example",
            initialCycleCount = 99
    )
    targetDir = file("../fun-things")
}