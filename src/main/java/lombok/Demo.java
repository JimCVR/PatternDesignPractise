package lombok;

import java.util.Set;

@Builder
@Data public class Demo {
    @Builder.Default private long created = System.currentTimeMillis();
    private String name;
    private int age;
    @Singular private Set<String> occupations;

    public static void main(String[] args) {
        Demo demo = Demo.builder().age(15).name("Jaime").occupation("Salaryman").build();
        System.out.println(demo);
    }
}



