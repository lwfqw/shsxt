import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Util implements Comparator {

    public static void main(String[] args) throws Exception {
        Integer a=126;
        System.out.println(a.equals(126));
        Consumer
//        List<String> warnings = new ArrayList<>();
//        boolean overwrite = true;
//        try {
//            //指定 逆向工程配置文件
//            File configFile = new File("resources/generatorConfig.xml");
//            ConfigurationParser cp = new ConfigurationParser(warnings);
//            Configuration config = cp.parseConfiguration(configFile);
//            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
//                    callback, warnings);
//            myBatisGenerator.generate(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
