package com.junhua.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MustacheWorker<T> {

    private final String templatePath;
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public MustacheWorker(String templatePath) {
        this.templatePath = templatePath;
    }

    public static final Map<String, Mustache> MUSTACHES = new ConcurrentHashMap<>();


    /**
     * 根据mustache模版生成字符串
     *
     * @param mustacheModel
     * @param templateName
     * @return
     */
    public String mergeMustache(MustacheModel<T> mustacheModel, String templateName) {
        StringWriter sw = new StringWriter();
        try {
            Mustache mustache = getMustache(templateName);
            mustache.execute(sw, mustacheModel).flush();
        } catch (IOException e) {
            LOG.error("exception happens while merging mustache: ", e);
        }
        return sw.toString();
    }


    /**
     * @param templateName
     * @return
     */
    public Mustache getMustache(String templateName) throws FileNotFoundException {
        if (MUSTACHES.containsKey(templateName)) {
            return MUSTACHES.get(templateName);
        } else {
            Mustache mustache = createMustache(templatePath, templateName);
            MUSTACHES.put(templateName, mustache);
            return mustache;
        }
    }

    /**
     * 根据mustache文件生成Mustache
     *
     * @param mustachePath
     * @param mustacheName
     * @return
     */
    static public Mustache createMustache(String mustachePath, String mustacheName) throws FileNotFoundException {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        MustacheFactory mf = new DefaultMustacheFactory();
        String fullPath = basePath + mustachePath + File.separator + mustacheName;
        File templateFile = new File(fullPath);

        InputStreamReader reader = new InputStreamReader(new FileInputStream(templateFile), Charset.forName("UTF-8"));
        Mustache mustache = mf.compile(reader, mustacheName);
        return mustache;
    }
}

