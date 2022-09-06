package study.example.core1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.example.core1.member.MemberRepository;
import study.example.core1.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        basePackages = "study.example.core1.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository") // 수동 등록 Bean이 우선권을 가짐 -> 수동 Bean이 자동BEan을 오버라이딩
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
