package com.lambda;

/**
 * Created by alexandr on 19.05.15.
 * ***************************************************************************************************
 * java.util.Stream
 */
public class Source2 {

    public static void main(String[] args) {

    }

//    public void printGroups (List<People > people ) {
//        Set<Group> groups = new HashSet< >();
//        for ( People p:people ) {
//            if (p.getAge() >= 65)
//                groups.add(p.getGroup());
//        }
//        List<Group > sorted = new ArrayList<>( groups );
//        Collections. sort(sorted, new Comparator<Group>() {
//            public int compare(Group a, Group b) {
//                return Integer.compare(a.getSize(), b.getSize());
//            }
//        });
//        for (Group g:sorted) System.out.println(g.getName());
//    }
//
//    public void printGroups (List<People> people ) {
//        people.stream()
//              .filter(p -> p.getAge () > 65)
//              .map(p -> p.getGroup())
//              .distinct()
//              .sorted(comparing(g -> g.getSize()))
//              .map(g -> g.getName())
//              .forEach(System.out::println);
//    }

    public static class People {
        private String name;
        private int age;

        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }
    }

}
