package spring.spring_annotation.config_anno;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.junhua.tornesol.util.spring_annotation.config_anno.White",
                "com.junhua.tornesol.util.spring_annotation.config_anno.Blue"
        };
    }
}
