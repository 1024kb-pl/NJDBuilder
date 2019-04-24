package com.company;

class Camel {
    private final Long id;
    private final String name;
    private final int age;
    private final Gender gender;
    private final double weight;
    private final double height;
    private final String colorFur;

    public Camel(Long id, String name, int age, Gender gender, double weight, double height, String colorFur) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.colorFur = colorFur;
    }

    static NeedId builder () {
        return new Builder();
    }

    private static class Builder implements NeedAge, NeedGender, NeedId, NeedName, CanBeBuilt {
        private Long id;
        private String name;
        private int age;
        private Gender gender;
        private double weight;
        private double height;
        private String colorFur;
        
        @Override
        public NeedName id(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public NeedAge name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public NeedGender age(int age) {
            this.age = age;
            return this;
        }

        @Override
        public CanBeBuilt gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        @Override
        public CanBeBuilt weight(double weight) {
            this.weight = weight;
            return this;
        }

        @Override
        public CanBeBuilt height(double height) {
            this.height = height;
            return this;
        }

        @Override
        public CanBeBuilt furColor(String color) {
            this.colorFur = color;
            return this;
        }

        @Override
        public Camel build() {
            return new Camel(
                    id, name, age, gender, weight, height, colorFur
            );
        }
    }

    interface NeedId {
        NeedName id(Long id);
    }

    interface NeedName {
        NeedAge name(String name);
    }

    interface NeedAge {
        NeedGender age(int age);
    }

    interface NeedGender {
        CanBeBuilt gender(Gender gender);
    }

    interface CanBeBuilt {
        CanBeBuilt weight(double weight);
        CanBeBuilt height(double height);
        CanBeBuilt furColor(String color);
        Camel build();
    }
}
