package com.wjs.util.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertyUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtil.class);

	public static void copyProperties(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			LOGGER.error("bean copy error:", e);
		} 
		
	}
	
	/**
	 * 从集合元素中获取对应字段的值作为一个list返回，集合元素必须是JavaBean
	 *
	 * @param collection
	 * @param fieldName JavaBean对象的filed name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T,S> List<S> fetchFieldList(Collection<T> collection, String fieldName) {

		List<S> fields = new ArrayList<S>();

		if (CollectionUtils.isEmpty(collection) || StringUtils.isEmpty(fieldName)) {
			return fields;
		}

		String fieldValue;
		try {
			for (T t : collection) {
				if (t == null) {
					continue;
				}
				fieldValue = BeanUtils.getProperty(t, fieldName);
				if(fieldValue != null){
					
					fields.add((S)fieldValue);
				}
			}
		} catch (Exception e) {
			LOGGER.warn("Get property '" + fieldName + "' from  collection [" + collection + "] error", e);
		}

		return fields;
	}
	
	 /**
     * 抽取JavaBean集合collection中的对应的T的field集合, 并将field集合转换为目标T类型, 类型一般为JavaBean fieldName对应的原始类型
     *
     * @param collection S集合
     * @param fieldName  需要抽取的S JavaBean对应的field
     * @param clazz      将field转换为的目标类型
     * @param <S>        collection集合的component type,一般是JavaBean
     * @param <T>
     * @return
     */
    public static <S, T> List<T> fetchFieldList(Collection<S> collection, String fieldName, Class<T> clazz) {
        List<Object> fieldObjList = fetchFieldList(collection, fieldName);
        List<T> fieldTypedList = fieldObjList == null ? Collections.<T> emptyList() : convertTo(fieldObjList, clazz);
        return CollectionUtils.isEmpty(fieldTypedList) ? Collections.<T> emptyList() : new ArrayList<T>(fieldTypedList);
    }

    /**
     * 集合元素类型转换，只支持基本类型的包装类型、String
     *
     * @param collection  待转换数据集合
     * @param targetClazz 目标类型class
     * @param <T>         目标类型 基本类型的包装类型
     * @param <S>         源类型
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T, S> List<T> convertTo(Collection<S> collection, Class<T> targetClazz) {
        List<T> destList = new ArrayList<T>();

        if (CollectionUtils.isEmpty(collection)) {
            return destList;
        }

        try {
            Method method = getConvertMethod(targetClazz);

            if (method == null) {
                LOGGER.warn("Not support convert to {}", targetClazz.getName());
                return destList;
            }

            T target;
            for (S from : collection) {
                if (from == null) {
                    continue;
                }
                target = (T) method.invoke(null, from);
                destList.add(target);
            }

        } catch (Exception e) {
            LOGGER.warn("Convert to {} error using reflection", targetClazz.getName(), e);
        }

        return destList;
    }


    /**
     * 类型转换获取对应Method
     *
     * @param targetClazz 目前除void.class外的基本类型及其包装类型以及String
     * @param <T>
     * @return Method实例，对于不支持的类型返回null
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static <T> Method getConvertMethod(Class<T> targetClazz) {
        try {
            String className = targetClazz.getSimpleName();
            String methodName;
            Method method = null;

            if (Void.class.equals(targetClazz) || Void.TYPE.equals(targetClazz)) {
                LOGGER.warn("Not support 'void.class' or 'Void.class'");
                return method;
            }

            // convert primitive type to corresponse wrapper type
            if (targetClazz.isPrimitive()) {
                targetClazz = (Class) ClassUtils.primitiveToWrapper(targetClazz);
            }
            // Numberic or Boolean使用对应的parseTargetClass
            if (Number.class.isAssignableFrom(targetClazz) || Boolean.class.isAssignableFrom(targetClazz)) {
                if (targetClazz.equals(Integer.class) || targetClazz.equals(int.class)) {
                    methodName = "parseInt";
                } else {
                    methodName = "parse" + className.substring(0, 1).toUpperCase() + className.substring(1);
                }
                method = targetClazz.getMethod(methodName, String.class);
            } else if (String.class.equals(targetClazz)) {
                method = targetClazz.getMethod("valueOf", Object.class);
            }

            return method;
        } catch (Exception e) {
            LOGGER.warn("Get convertMehod on '" + targetClazz.getName() + "' error using reflection", e);
            return null;
        }
    }
}
