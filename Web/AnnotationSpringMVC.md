## Annotation开发Spring MVC 

1. 使用Maven构建好project（maven项目选择web项目）

2. 把项目的文件系统构建好，少的文件夹自己新建（比如src/main/java）

3. 按需求在pom.xml中配置依赖(servlet depandecy等)

4. 新建一个**SpringMVCInitializer.java**相当于web.xml

   ```java
   public class SpringMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
     //或者 implements WebApplicationInitializer
     //1.按照具体需求实现里面的method
     //2.配置Root WebApplicationContext、Servlet WebApplicationContext和ServletMapping
   ```

5. Configuring Spring MVC，相当于[servletname]-servlet.xml，实际上是根据上面SpringMVCInitializer中方法，这个可以按情况认为：Root WebApplicationContext 或者Servlet WebApplicationContext

   ```java
   @Configuration
   @EnableWebMvc
   public class EclipseDebugConfiguration extends WebMvcConfigurerAdapter
     //或者实现WebMvcConfigurer接口
     //按具体需求重写里面的方法
   ```

   ​