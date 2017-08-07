//        List<String> sample = new ArrayList<>();
//
//        for (int i = 0; i < 5000000; i++) {
//          sample.add("element");
//        }

        // 90397ms
//        for (String str : sample) {
//            System.out.println(str.toUpperCase());
//        }




        Stream<String> sample3 = Stream.generate(() -> "element")
                                        .limit(5000000);

        // 94822ms
//        sample3.forEach(str -> System.out.println(str.toUpperCase()));

        // 124735ms
        sample3.parallel()
                .forEach(str -> System.out.println(str.toUpperCase()));

        // ============================================================================================================
//
//        // 358ms
//        for (String str : sample) {
//            System.out.println(str.toUpperCase());
//        }
//
//        // 809ms
//        sample.stream()
//                .forEach(s -> System.out.println(s.toUpperCase()));
//
//
//        // 798ms
//        sample.stream()
//                .parallel()
//                .forEach(s -> System.out.println(s.toUpperCase()));

//        Stream<String> sample2 = Stream.of("hi","bye","what","no", "who");
//        System.currentTimeMillis()
//        sample2.forEach(s -> System.out.println(s.toUpperCase()));
