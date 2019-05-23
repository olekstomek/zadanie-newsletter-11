package pl.javastart;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Runner {

    public static void main(String[] args) {

        StringBuilder forbiddenWord = createForbiddenWord();

        Class[] constructor = new Class[]{String.class};
        String name = "JavaStart";

        Object[] constructorArgs = new Object[]{name};
        try {
            Class<?> cls = Class.forName("pl.javastart.".concat(String.valueOf(forbiddenWord)));
            Constructor externalConstructor = cls.getDeclaredConstructor(constructor);
            externalConstructor.setAccessible(true);
            Object newInstanceConstructor = externalConstructor.newInstance(constructorArgs);

            Method method = cls.getDeclaredMethod("show");
            method.invoke(newInstanceConstructor);

        } catch (Exception e) {
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