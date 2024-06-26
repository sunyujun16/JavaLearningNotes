package chap23_annotations.ifx;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;

// javac -processor chap23_annotations.ifx.IfaceExtractorProcessor chap23_annotations/ifx/Multiplier.java
// 提取公共方法, 并用这些公共方法生成一个接口.
@SupportedAnnotationTypes(
        "chap23_annotations.ifx.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_15)
public class IfaceExtractorProcessor extends AbstractProcessor {
    private ArrayList<Element> interfaceMethods = new ArrayList<>();
    Elements elementUtils;
    private ProcessingEnvironment processingEnv;

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment env) {
        for (Element elem : env.getElementsAnnotatedWith(
                ExtractInterface.class)) {
            String interfaceName = elem.getAnnotation(
                    ExtractInterface.class).interfaceName();
            for (Element enclosed :
                    elem.getEnclosedElements()) {
                if (enclosed.getKind()
                        .equals(ElementKind.METHOD) &&
                        enclosed.getModifiers()
                                .contains(Modifier.PUBLIC) &&
                        !enclosed.getModifiers()
                                .contains(Modifier.STATIC)) {
                    interfaceMethods.add(enclosed);
                }
            }
            if (interfaceMethods.size() > 0)
                writeInterfaceFile(interfaceName);
        }
        return false;
    }

    private void writeInterfaceFile(String interfaceName) {
        try (
                // 加的路径没用... 又忘了编译了草, 马拉卡!
                Writer writer = processingEnv.getFiler()
                        .createSourceFile("chap23_annotations.ifx."
                                +interfaceName)
                        .openWriter()
        ) {
            String packageName = elementUtils
                    .getPackageOf(interfaceMethods
                            .get(0)).toString();
            writer.write(
                    "package " + packageName + ";\n");
            writer.write("public interface " +
                    interfaceName + " {\n");
            for (Element elem : interfaceMethods) {
                ExecutableElement method =
                        (ExecutableElement) elem;
                String signature = " public ";
                signature += method.getReturnType() + " ";
                signature += method.getSimpleName();
                signature += createArgList(
                        method.getParameters());
                System.out.println(signature);
                writer.write(signature + ";\n");
            }
            writer.write("}");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String createArgList(
            List<? extends VariableElement> parameters) {
        String args = parameters.stream()
                .map(p -> p.asType() + " " + p.getSimpleName())
                .collect(Collectors.joining(", "));
        return "(" + args + ")";
    }
}
