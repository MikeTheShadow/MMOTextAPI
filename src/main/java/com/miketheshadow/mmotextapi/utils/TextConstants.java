package com.miketheshadow.mmotextapi.utils;

public class TextConstants {

    public static class Wood {
        public static final String WOOD_START_PIECE = register(0x2309);
        public static final String WOOD_END_PIECE = register(0x230a);
        public static final String WOOD_MIDDLE_PIECE = register(0x2308);
    }

    /*
    Spacing is in pixels
     */
    public static class Spacing {
        public static final String NEGATIVE_SPACE_1 = register(0xF801);
        public static final String NEGATIVE_SPACE_2 = register(0xF802);
        public static final String NEGATIVE_SPACE_3 = register(0xF803);
        public static final String NEGATIVE_SPACE_4 = register(0xF804);
        public static final String NEGATIVE_SPACE_5 = register(0xF805);
        public static final String NEGATIVE_SPACE_6 = register(0xF806);
        public static final String NEGATIVE_SPACE_7 = register(0xF807);
        public static final String NEGATIVE_SPACE_8 = register(0xF808);
        public static final String NEGATIVE_SPACE_16 = register(0xF809);
        public static final String NEGATIVE_SPACE_32 = register(0xF80A);
        public static final String NEGATIVE_SPACE_64 = register(0xF80B);
        public static final String NEGATIVE_SPACE_128 = register(0xF80C);
        public static final String NEGATIVE_SPACE_512 = register(0xF80D);
        public static final String NEGATIVE_SPACE_1024 = register(0xF80E);

        public static final String POSITIVE_SPACE_1 = register(0xF821);
        public static final String POSITIVE_SPACE_2 = register(0xF822);
        public static final String POSITIVE_SPACE_3 = register(0xF823);
        public static final String POSITIVE_SPACE_4 = register(0xF824);
        public static final String POSITIVE_SPACE_5 = register(0xF825);
        public static final String POSITIVE_SPACE_6 = register(0xF826);
        public static final String POSITIVE_SPACE_7 = register(0xF827);
        public static final String POSITIVE_SPACE_8 = register(0xF828);
        public static final String POSITIVE_SPACE_16 = register(0xF829);
        public static final String POSITIVE_SPACE_32 = register(0xF82A);
        public static final String POSITIVE_SPACE_64 = register(0xF82B);
        public static final String POSITIVE_SPACE_128 = register(0xF82C);
        public static final String POSITIVE_SPACE_512 = register(0xF82D);
        public static final String POSITIVE_SPACE_1024 = register(0xF82E);

        public static final String NEGATIVE_CUSTOM = register(0x230B);


        public static final String POSITIVE_SPACE_0_5 = register(0x230c);

        public static String fromInt(int id) {
            switch (id) {
                case 1 -> {
                    return POSITIVE_SPACE_1;
                }
                case 2 -> {
                    return POSITIVE_SPACE_2;
                }
                case 3 -> {
                    return POSITIVE_SPACE_3;
                }
                case 4 -> {
                    return POSITIVE_SPACE_4;
                }
                case 5 -> {
                    return POSITIVE_SPACE_5;
                }
                case 6 -> {
                    return POSITIVE_SPACE_6;
                }
                case 7 -> {
                    return POSITIVE_SPACE_7;
                }
                case 8 -> {
                    return POSITIVE_SPACE_8;
                }
                case 16 -> {
                    return POSITIVE_SPACE_16;
                }
                case 32 -> {
                    return POSITIVE_SPACE_32;
                }
                case 64 -> {
                    return POSITIVE_SPACE_64;
                }
                case 128 -> {
                    return POSITIVE_SPACE_128;
                }
                case 512 -> {
                    return POSITIVE_SPACE_512;
                }
                case 1024 -> {
                    return POSITIVE_SPACE_1024;
                }
                case -1 -> {
                    return NEGATIVE_SPACE_1;
                }
                case -2 -> {
                    return NEGATIVE_SPACE_2;
                }
                case -3 -> {
                    return NEGATIVE_SPACE_3;
                }
                case -4 -> {
                    return NEGATIVE_SPACE_4;
                }
                case -5 -> {
                    return NEGATIVE_SPACE_5;
                }
                case -6 -> {
                    return NEGATIVE_SPACE_6;
                }
                case -7 -> {
                    return NEGATIVE_SPACE_7;
                }
                case -8 -> {
                    return NEGATIVE_SPACE_8;
                }
                case -16 -> {
                    return NEGATIVE_SPACE_16;
                }
                case -32 -> {
                    return NEGATIVE_SPACE_32;
                }
                case -64 -> {
                    return NEGATIVE_SPACE_64;
                }
                case -128 -> {
                    return NEGATIVE_SPACE_128;
                }
                case -512 -> {
                    return NEGATIVE_SPACE_512;
                }
                case -1024 -> {
                    return NEGATIVE_SPACE_1024;
                }
            }

            return "UNKNOWN VALUE: " + id;
        }
    }


    public static class AlphabetToHex {
        public static final String NUM_0 = "\u0030";
        public static final String NUM_1 = "\u0031";
    }


    private static String register(int value) {
        return String.valueOf((char) value);
    }
}
