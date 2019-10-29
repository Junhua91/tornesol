package spring.spring_annotation.config_anno;


import spring.spring_annotation.filter.MyTypeFilter;
import org.springframework.context.annotation.*;


@Configuration//相当于以前的配置文件
@ComponentScan(
        basePackages = {"spring.spring_annotation"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
        useDefaultFilters = false
)
@Import({Red.class, MyImportSelector.class, MyImportBeanDefinition.class})
public class MainConfig {
    @Scope(scopeName = "prototype")
    @Bean(name = {"person"})//容器中该bean的id默认是方法的名字
    public Person person1() {
        return new Person("junhua", 20);
    }

    @Bean
    public MyFactoryBean getFactoryBean() {
        return new MyFactoryBean();
    }

}

//    @Conditional(WindowsCondition.class)
//    @Bean(name = "bill")
//    public Person person2() {
//        return new Person("Bill", 62);
//    }
//
//    //    @Conditional(LinuxCondition.class)
//    @Bean(name = "linus")
//    public Person person3() {
//        return new Person("Linus", 50);
//    }