package com.example.common.web.codelist;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.reflect.ClassPath;

@Component("eh")
public class EnumCodeListHelper {
	@Value("${app.values}")
	private String values;

	@PostConstruct
	public void postConstructSetValues() throws Exception {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		valuesObjList = ClassPath.from(loader).getTopLevelClassesRecursive(values).stream().filter(classInfo -> {
			try {
				Class<?> clazz = Class.forName(classInfo.getName());
				return !clazz.equals(EnumValues.class) && EnumValues.class.isAssignableFrom(clazz);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toMap(ClassPath.ClassInfo::getSimpleName, ClassPath.ClassInfo::getName));
	}

	private Map<String, String> valuesObjList;

	private EnumCodeListHelper() {}

	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & EnumValues> String getValue(String classSimpleName, String valueName)
			throws ClassNotFoundException {
		Class<T> enumType = (Class<T>) Class.forName(this.valuesObjList.get(classSimpleName));
		T val = Enum.valueOf(enumType, valueName);
		return val.getValue();
	}

	public <T extends Enum<T> & EnumValues> String getValue(Class<T> enumType, String valueName) {
		T val = Enum.valueOf(enumType, valueName);
		return val.getValue();
	}

	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & EnumValues> String getText(String classSimpleName, String value)
			throws ClassNotFoundException {
		Class<T> enumType = (Class<T>) Class.forName(this.valuesObjList.get(classSimpleName));
		String result = "";
		for (T val : enumType.getEnumConstants()) {
			if (val.getValue().equals(value)) {
				result = val.getText();
				break;
			}
		}
		return result;
	}

	public <T extends Enum<T> & EnumValues> String getText(Class<T> enumType, String value) {
		String result = "";
		for (T val : enumType.getEnumConstants()) {
			if (val.getValue().equals(value)) {
				result = val.getText();
				break;
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & EnumValues> T[] values(String classSimpleName) throws ClassNotFoundException {
		Class<T> enumType = (Class<T>) Class.forName(this.valuesObjList.get(classSimpleName));
		return enumType.getEnumConstants();
	}

}