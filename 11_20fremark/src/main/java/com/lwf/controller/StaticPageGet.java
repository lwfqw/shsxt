package com.lwf.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: StaticPageGet
 * @projectName 11_20fremark
 * @description: TODO
 * @date 2020/11/2017:07
 */
@WebServlet("/staticPage")
public class StaticPageGet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setServletContextForTemplateLoading(getServletContext(), "/template");
        Template template=configuration.getTemplate("temp.ftl");
        String name=System.currentTimeMillis()+".html";
        String path=getServletContext().getRealPath("/")+"/staticPage/"+name;
        Map<String,Object> map=new HashMap<>();
        map.put("title","maven");
        map.put("content","# maven\n" +
                "\n" +
                "## 简介\n" +
                "\n" +
                "> \u200B     Maven【[ˈmevən]】这个词可以翻译为\"专家\",\"内⾏\"。 作为Apache组织中的⼀个颇为成功的开源项 ⽬，Maven主要服务于基于java平台的项⽬构建，依赖管理和项⽬信息管理。 ⽆论是⼩型的开源类库项⽬，还是⼤型的企业级应⽤； ⽆论是传统的瀑布式开发，还是流⾏的敏捷开 发，Maven都能⼤显身⼿。\n" +
                "\n" +
                "## 项目构建\n" +
                "\n" +
                "> \u200B        不管你是否意识到，构建（build）是每⼀位程序员每天都在做的⼯作。早上来到公司，我们做的第⼀ 件事就是从源码库签出最新的代码，然后进⾏单元测试，如果测试失败，会找相关的同事⼀起调试，修 复错误代码。 接着回到⾃⼰的⼯作上来，编写⾃⼰的单元测试及产品代码。 \n" +
                ">\n" +
                "> \u200B        仔细总结⼀下，我们会发现，除了编写源代码，我们每天有相当⼀部分时间花在了编译，运⾏单元测 试，⽣成⽂档，打包和部署等繁琐且不起眼的⼯作上，这就是构建。 如果我们现在还⼿⼯这样做，那成 本也太⾼了，于是有⼈⽤软件的⽅法让这⼀系列⼯作完全⾃动化，使得软件的构建可以像全⾃动流⽔线 ⼀样，只需要⼀条简单的命令，所有繁琐的步骤都能够⾃动完成，很快就能得到最终结果。\n" +
                "\n" +
                "## 项目构建工具\n" +
                "\n" +
                "**Ant构建** \n" +
                "\n" +
                "> 最早的构建⼯具，基于IDE, ⼤概是2000年有的，当时是最流⾏java构建⼯具，不过它的XML脚本编写 格式让XML⽂件特别⼤。对⼯程构建过程中的过程控制特别好 \n" +
                "\n" +
                "**Maven【JAVA】**\n" +
                "\n" +
                ">  项⽬对象模型，通过其描述信息来管理项⽬的构建，报告和⽂档的软件项⽬管理⼯具。它填补了Ant 缺点，Maven第⼀次⽀持了从⽹络上下载的功能，仍然采⽤xml作为配置⽂件格式。Maven专注的是依 赖管理，使⽤Java编写。 \n" +
                "\n" +
                " **Gradle**\n" +
                "\n" +
                "> 属于结合以上两个的优点，它继承了Ant的灵活和Maven的⽣命周期管理，它最后被google作为了 Android御⽤管理⼯具。它最⼤的区别是不⽤XML作为配置⽂件格式，采⽤了DSL格式，使得脚本更加 简洁。 ⽬前市⾯上Ant⽐较⽼, 所以⼀般是⼀些⽐较传统的软件企业公司使⽤, Maven使⽤Java编写, 是当下⼤ 多数互联⽹公司会使⽤的⼀个构建⼯具, 中⽂⽂档也⽐较⻬全, gradle是⽤groovy编写, ⽬前⽐较新型的 构建⼯具⼀些初创互联⽹公司会使⽤, 以后会有很⼤的使⽤空间.\n" +
                "\n" +
                "## maven四大特性\n" +
                "\n" +
                "***1.依赖管理系统***\n" +
                "\n" +
                "> 将每一个jar包以<组织名，项目名，版本号>区分开，任何基于Maven构建的项⽬⾃身也必须定义这三项属性，⽣成的包可以是Jar包，也可以是war包或者 jar包。\n" +
                "\n" +
                "***2.多模块构建***\n" +
                "\n" +
                "> 项⽬复查时 dao service controller 层分离将⼀个项⽬分解为多个模块已经是很通⽤的⼀种⽅式。 在Maven中需要定义⼀个parent POM作为⼀组module的聚合POM。在该POM中可以使⽤ 标签来 定义⼀组⼦模块。parent POM不会有什么实际构建产出。⽽parent POM中的build配置以及依赖配置 都会⾃动继承给⼦module。\n" +
                "\n" +
                "***3.项目结构一致***\n" +
                "\n" +
                "> Ant时代⼤家创建Java项⽬⽬录时⽐较随意，然后通过Ant配置指定哪些属于source，那些属于 testSource等。⽽Maven在设计之初的理念就是Conversion over configuration（约定⼤于配置）。其 制定了⼀套项⽬⽬录结构作为标准的Java项⽬结构,解决不同ide 带来的⽂件⽬录不⼀致问题。\n" +
                "\n" +
                "***4.⼀致的构建模型和插件机制***");
        map.put("from","lwf");
        map.put("date", new Date());
        template.process(map, new FileWriter(path));
        System.out.println(path);
        resp.sendRedirect("/staticPage/"+name);
    }
}
