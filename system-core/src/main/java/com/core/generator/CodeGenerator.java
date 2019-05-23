package com.core.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * @author LUJAIWEI931
 * @date 2019-05-23
 */
public class CodeGenerator {

    public static Map<String, String[]> configMap = new HashMap<>();

    static {
        configMap.put("1", new String[]{"system-business", "com.business"});
        configMap.put("2", new String[]{"system-core", "com.core"});
        configMap.put("3", new String[]{"system-run", "com.pad"});
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if("1".equals(ipt.trim())){
                return "";
            }else{
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * create by: LUJIAWEI931
     * description:
     * create time: 2019/5/23
     *
     * @return: projectPath
     */
    public static String[] getGlobalConfig(AutoGenerator mpg) {
        GlobalConfig gc = new GlobalConfig();
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder();
        message.append("请选择模块:");
        Set<Map.Entry<String, String[]>> entries = configMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            message.append(entry.getKey()).append(".").append(entry.getValue()[0]).append(";");
        }
        System.out.println(message);
        String inputStr = "";
        if (scanner.hasNext()) {
            inputStr = scanner.next();
        }
        String[] values = configMap.get(inputStr);
        if (ArrayUtils.isEmpty(values)) {
            throw new MybatisPlusException("输入的模块不存在!");
        }
        String path = System.getProperty("user.dir");
        String projectPath = path + "/" + values[0];
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("LUJIAWEI931");
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        return values;
    }

    /**
     * create by: LUJIAWEI931
     * description: 数据源获取
     * create time: 23:45 2019/5/23
     *
     * @return DataSourceConfig
     */
    public static DataSourceConfig getDataSourceConfig() {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@127.0.0.1:32769:ORCLCDB");
        dsc.setDriverName("oracle.jdbc.OracleDriver");
        dsc.setUsername("c##louis");
        dsc.setPassword("123456");
        return dsc;
    }


    public static PackageConfig getPackageConfig(String packageName) {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("业务模块名"));
        pc.setParent(packageName);
        return pc;
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String path = System.getProperty("user.dir");
        // 全局配置
        String[] globalConfig = getGlobalConfig(mpg);
        mpg.setDataSource(getDataSourceConfig());
        //包配置
        String projectPath = path + "/" + globalConfig[0];
        String packagePath = globalConfig[1];
        PackageConfig pc = getPackageConfig(packagePath);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";


        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass("com.pad.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // strategy.setSuperControllerClass("com.pad.ant.common.BaseController");
        strategy.setInclude(scanner("表名称"));
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
