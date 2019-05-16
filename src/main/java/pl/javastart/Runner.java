package pl.javastart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public static void main(String[] args) {

        StringBuilder forbiddenWord = createForbiddenWord();

        Class[] constructor = new Class[]{String.class};
        String name = "JavaStart";

        Object[] constructorArgs = new Object[]{name};
        try {
            Class<Object> cls = (Class<Object>) Class.forName("pl.javastart.".concat(String.valueOf(forbiddenWord)));
            Constructor externalConstructor = cls.getConstructor(constructor);
            externalConstructor.setAccessible(true); // nie działa dla konstruktora private
            Object newInstanceConstructor = externalConstructor.newInstance(constructorArgs);

            Class[] noParams = {};

            Method method = cls.getDeclaredMethod("show", noParams);
            method.invoke(newInstanceConstructor, noParams);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder createForbiddenWord() {
        int[] forbiddenWordInAsciiArray = {84, 114, 105, 99, 107, 121};

        StringBuilder forbiddenWord = new StringBuilder();
        for (int ch : forbiddenWordInAsciiArray) {
            forbiddenWord.append((char) ch);
        }
        return forbiddenWord;
    }
}