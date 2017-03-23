package com.news.optional;


import java.util.Optional;

/**
 * @see http://javapitstop.com/article/fighting-with-nullpointerexception-6/
 *      http://microfork.com/whats-new-in-java-8/
 *      https://habrahabr.ru/post/225641/
 *
 * http://javahero.ru/java-8-пример-фильтрации-с-помощью-потоков/
 * https://dou.ua/lenta/articles/oracle-certified-java-8/
 */

public class Source0 {

    public static void main(String[] args) {
        Computer1 computer1 = new Computer1();

        /*
         * java.lang.NullPointerException
         */
//        String version = computer.getSoundcard().getUSB().getVersion();

        ////////////////////////////////////////////////////////////////////////////////////////
        String version = "UNKNOWN";
        Soundcard1 soundcard1 = computer1.getSoundcard();
        if( soundcard1 != null ) {
            USB1 usb = soundcard1.getUSB();
            if( usb != null && usb.getVersion() != null ) {
                version = usb.getVersion();
            }
        }

        /**
         * Попробуем применить Optional
         * ****************************
         * имеем три статических метода для инициализации
         * Optional.empty();
         * Optional.of(...);
         * Optional.ofNullable( ... );
         */
        // Инициализируем заведомо пустым значением
        Optional<Soundcard1> sc1 = Optional.empty();

        // Инициализируем заведомо НЕ пустым значением
        Optional<Soundcard1> sc2 = Optional.of( new Soundcard1() );

        // Инициализируем неизвестным значением (может null, а может и нет)
        Optional<Soundcard1> sc3 = Optional.ofNullable( soundcard1 );

        ////////////////////////////////////////////////////////////////////////////////////////
        Computer2 computer2 = new Computer2();

        // Вместо:
//        if( computer2.getSoundcard() != null ) {
//            System.out.println( computer2 );
//        }
        // Можно написать так:
        computer2.getSoundcard().ifPresent( System.out::println );

        // А можно проверить есть ли значение и достать его:
        Optional<Soundcard2> maybeSoundcard2_1 = computer2.getSoundcard();
        if( maybeSoundcard2_1.isPresent() ) {
            System.out.println( maybeSoundcard2_1.get() );
        }

        // Часто нужно вернуть некое значение по умолчанию, если нужного значения не существует:
        Optional<Soundcard2> maybeSoundcard2_2 = computer2.getSoundcard();
//        Soundcard2                soundcard2_1 = maybeSoundcard2_2.orElse( new Soundcard2("default") ); //??????????????????????

        // Или сгенерировать исключительную ситуацию:
        Optional<Soundcard2> maybeSoundcard2_3 = computer2.getSoundcard();
        Soundcard2                soundcard2_2 = maybeSoundcard2_3.orElseThrow( IllegalStateException::new );
    }

}


class Computer1 {
    private Soundcard1 soundcard;

    public Soundcard1 getSoundcard() {
        return soundcard;
    }
}

class Soundcard1 {
    private USB1 usb;

    public USB1 getUSB() {
        return usb;
    }
}

class USB1 {
    public String getVersion() {
        return "USB";
    }
}


class Computer2 {
    private Optional<Soundcard2> soundcard = Optional.of( new Soundcard2() );

    public Optional<Soundcard2> getSoundcard() {
    return soundcard;
    }
}

class Soundcard2 {
    private Optional<USB2> usb = Optional.of( new USB2() );

    public Optional<USB2> getUSB() {
    return usb;
    }
}

class USB2 {
//    public String getVersion(){
//        return "3.0";
//    }

    // Для этого у класса Optional существуют два метода: map(...) и flatMap(...)
    Computer2 computer;
    public String getVersion() {
        return computer.getSoundcard()
                .flatMap(Soundcard2::getUSB)
                .map(USB2::getVersion)
                .orElse("UNKNOWN");
    }
}
