/**
 * @projectName jxjs-tdhgd
 * @package com.thunisoft.jxjs.jxjstdhgd.util
 * @className com.thunisoft.jxjs.jxjstdhgd.util.XmlUtil
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.studies.study.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * ClassName: JaxbXmlUtil
 *
 * @author zhangyunfan
 * @version 1.0
 * @description Jaxb的工具
 * @date 2020年2月14日
 */
public final class JaxbXmlUtil {

    /**
     * 实体转xml，默认编码 {@code UTF-8}.
     *
     * @param entity 实体
     * @return xml
     */
    public static String entity2Xml(Object entity) {
        return entityConvert2Xml(entity, "utf-8");
    }

    /**
     * Description: 实体转换成xml
     *
     * @param entity 实体
     * @param charsetName 编码
     * @return xml字符串
     * @author zhangyunfan
     * @date 2020年2月26日
     */
    public static String entityConvert2Xml(Object entity, String charsetName) {
        try {
            return new String(entityConvert2XmlBytes(entity, charsetName), charsetName);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Description: xml转换为实体
     *
     * @param xmlStr xml字符串
     * @param entityClass 实体类型
     * @return T
     * @author zhangyunfan
     * @date 2020年2月15日
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlConvert2Entity(String xmlStr, Class<T> entityClass) {
        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(entityClass).createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (JAXBException e) {
            return (T) "";
        }

    }

    /**
     * 将 xml文件 解析为 Javabean.
     *
     * @param file xml文件
     * @param entityClass 对象
     * @param <T> JavaBean
     * @return t
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlConvert2Entity(File file, Class<T> entityClass) {
        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(entityClass).createUnmarshaller();
            return (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            return (T) "";
        }
    }


    /**
     * Description: 将对象转换为xml，返回xml的字节数组
     *
     * @param entity 实体
     * @param charsetName 编码
     * @return 返回字符串数组
     * @throws JAXBException byte[]
     * @author zhangyunfan
     * @date 2020年2月26日
     */
    public static byte[] entityConvert2XmlBytes(Object entity, String charsetName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, charsetName);
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        marshaller.marshal(entity, byteOutputStream);
        return byteOutputStream.toByteArray();
    }

    /**
     * JaxbUtils
     * @description 对象转xml字符串
     * @param obj 对象
     * @return java.lang.String
     * @author yangzhicheng
     * @date 2020/2/26 18:04
     * @version 1.0
     */
    public static String entityConvert2XmlString(Object obj){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //编码格式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //去掉默认报文头
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
