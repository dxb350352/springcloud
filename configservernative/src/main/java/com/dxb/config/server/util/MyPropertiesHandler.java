package com.dxb.config.server.util;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MyPropertiesHandler implements PropertySourceLoader {


    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        Properties properties = getProperties(resource);
        if (properties.isEmpty()) {
            return Collections.emptyList();
        }
        System.out.println("自定义PropertySourceLoader来自定义配置加载:");
        for (Map.Entry me : properties.entrySet()) {
            System.out.println(me.getKey() + "=" + me.getValue());
        }
        return Collections
                .singletonList(new OriginTrackedMapPropertySource(name, properties));
    }


    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, "utf-8"));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}