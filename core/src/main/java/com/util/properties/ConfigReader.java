package com.util.properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：读取配置文件
 * 类名称：com.uflowertv.util.ConfigReader     
 * 创建人：liguoliang 
 * 创建时间：2016年9月27日 下午2:20:47   
 * 修改人：
 * 修改时间：2016年9月27日 下午2:20:47   
 * 修改备注：   
 * @version   V1.0
 */
public class ConfigReader {
	private Logger log = LoggerFactory.getLogger(getClass());
	
    private Map<String, String> confs = new LinkedHashMap<String, String>();

    public ConfigReader(String path) {
        this.load(path);
    }

    protected synchronized void load(String path) {
        if (log.isDebugEnabled()) {
            log.debug( path);
        }
        InputStream is = null;
        BufferedReader br = null;
        Properties p = new Properties();
        try {
            is = this.getClass().getResourceAsStream(path);
            br = new BufferedReader(new InputStreamReader(is));
            p.load(br);
        }
        catch (Exception e) {
          log.error(e.getMessage());
        }
        finally {
        	try {
				is.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        putAll(p);
    }

    @SuppressWarnings({
                       "unchecked", "rawtypes"
    })
    protected void putAll(Map p) {
        confs.putAll(p);
    }

    public synchronized void clear() {
        confs.clear();
    }

    protected void valid(String key) {
        if (StringUtils.isBlank(key)) {
            throw new NullPointerException("Key can't not be NULL or empty value.");
        }
    }

    public void put(String key, String value) {
        confs.put(key, value);
    }

    public List<String> keys() {
        return new ArrayList<String>(confs.keySet());
    }

    public Collection<String> values() {
        return confs.values();
    }

    public String get(String key) {
        valid(key);
        return confs.get(key);
    }

    public int getInt(String key) {
        valid(key);
        return Integer.parseInt(get(key));
    }

    public long getLong(String key) {
        valid(key);
        return Long.valueOf(get(key)).longValue();
    }

    public boolean getBoolean(String key) {
        valid(key);
        return Boolean.valueOf(get(key));
    }
}
