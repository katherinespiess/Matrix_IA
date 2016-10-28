package br.com.matrix.getClasses;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetClasses {

	private static final char separadorClasses = '.';

	private static final char separadorPackage = '/';

	private static final String sufixo = ".class";

	private static final String erro = "Não foi possível encontrar o caminho '%s'. Tem certeza de que a package '%s' existe?";

	public static List<Class<?>> find(String scannedPackage) {
		String scannedPath = scannedPackage.replace(separadorClasses, separadorPackage);
		URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
		if (scannedUrl == null) {
			throw new IllegalArgumentException(String.format(erro, scannedPath, scannedPackage));
		}
		File scannedDir = new File(scannedUrl.getFile());
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (File file : scannedDir.listFiles()) {
			classes.addAll(find(file, scannedPackage));
		}
		return classes;
	}

	private static List<Class<?>> find(File file, String scannedPackage) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		String resource = scannedPackage + separadorClasses + file.getName();
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				classes.addAll(find(child, resource));
			}
		} else if (resource.endsWith(sufixo)) {
			int endIndex = resource.length() - sufixo.length();
			String className = resource.substring(0, endIndex);
			try {
				classes.add(Class.forName(className));
			} catch (ClassNotFoundException ignore) {
			}
		}
		return classes;
	}

	public static List<String> getClassNamesByPackage(String packageName) {
		List<Class<?>> classes = find(packageName);
		List<String> classNames = new ArrayList<>();
		for (Class<?> myClass : classes)
			classNames.add(myClass.getName());

		return classNames;
	}

	public static List<String> getClassNamesByPackage(String packageName, String[] exclude) {
		List<Class<?>> classes = find(packageName);
		List<String> classNames = new ArrayList<>();
		for (Class<?> myClass : classes)
			for (String excluded : exclude)
				if (!myClass.getName().equals(excluded))
					classNames.add(myClass.getName());

		return classNames;
	}

}